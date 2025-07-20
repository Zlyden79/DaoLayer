package ru.netology.zlyden.daolayer.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Order {
    private int id;
    private LocalDate date;
    private int customerId;
    private String productName;
    private int amount;

    public Order() {
    }

    public Order(int amount, String productName, int customerId, LocalDate date, int id) {
        this.amount = amount;
        this.productName = productName;
        this.customerId = customerId;
        this.date = date;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", customerId=" + customerId +
                ", productName='" + productName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
