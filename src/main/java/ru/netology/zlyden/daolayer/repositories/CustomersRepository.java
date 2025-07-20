package ru.netology.zlyden.daolayer.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.netology.zlyden.daolayer.domain.Customer;

import java.util.List;

@Repository
public class CustomersRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomersRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM netology.customers";
        return jdbcTemplate.query(sql, (rs, rowNum)-> {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));
            customer.setSurname(rs.getString("surname"));
            customer.setAge(rs.getInt("age"));
            customer.setPhoneNumber(rs.getString("phone_number"));
            return customer;
        });
    }

    public Customer createCustomer(Customer customer) {
        String sql = "INSERT INTO netology.customers(name, surname, age, phone_number) " +
                "VALUES (:name, :surname, :age, :phoneNumber) RETURNING id;";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("name", customer.getName())
                .addValue("surname", customer.getSurname())
                .addValue("age", customer.getAge())
                .addValue("phoneNumber", customer.getPhoneNumber());
        int id = namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
        customer.setId(id);
        return customer;
    }
}
