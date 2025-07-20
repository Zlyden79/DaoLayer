CREATE SCHEMA IF NOT EXISTS netology AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS netology.CUSTOMERS
(
    id serial not null PRIMARY KEY,
    name varchar(255) not null,
    surname varchar(255) not null,
    age smallint,
    phone_number varchar(12)
);


CREATE TABLE IF NOT EXISTS netology.ORDERS
(
    id serial not null PRIMARY KEY,
    date date not null,
    customer_id integer not null,
    product_name text not null,
    amount integer not null,
    FOREIGN KEY (customer_id) REFERENCES netology.CUSTOMERS(id)
);
