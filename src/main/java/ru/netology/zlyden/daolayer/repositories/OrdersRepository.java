package ru.netology.zlyden.daolayer.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.netology.zlyden.daolayer.domain.Order;

import java.util.List;

@Repository
public class OrdersRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrdersRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM netology.orders";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setDate(rs.getDate("date").toLocalDate());
            order.setCustomerId(rs.getInt("customer_id"));
            order.setProductName(rs.getString("product_name"));
            order.setAmount(rs.getInt("amount"));
            return order;
        });
    }

    public Order createOrder(Order order) {
        String sql = "INSERT INTO netology.orders(date, customer_id, product_name, amount) " +
                "VALUES (:date, :customerId, :productName, :amount) RETURNING id;";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("date", order.getDate())
                .addValue("customerId", order.getCustomerId())
                .addValue("productName", order.getProductName())
                .addValue("amount", order.getAmount());
        int id = namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
        order.setId(id);
        return order;
    }
}
