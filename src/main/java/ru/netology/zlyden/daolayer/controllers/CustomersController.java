package ru.netology.zlyden.daolayer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;
import ru.netology.zlyden.daolayer.domain.Customer;
import ru.netology.zlyden.daolayer.repositories.CustomersRepository;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    private final CustomersRepository customersRepository;

    @Autowired
    public CustomersController(CustomersRepository customersRepository) {
            this.customersRepository = customersRepository;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customersRepository.getAllCustomers();
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customersRepository.createCustomer(customer);
    }
}
