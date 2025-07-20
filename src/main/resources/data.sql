INSERT INTO netology.CUSTOMERS (name, surname, age, phone_number)
VALUES ('alexey', 'Bogomolov', 44, '+79173412345'),
       ('Alexey', 'Orlov', 45, '+79173454321'),
       ('ALEXEY', 'Mirin', 44, '+79173454321'),
       ('Vasiliy', 'Stepanov', 58, '+79271378965'),
       ('Vasiliy', 'Utkin', 19, '+79271378966');

INSERT INTO netology.ORDERS(date, customer_id, product_name, amount)
VALUES ('31.12.2024', 1, 'Ель искуственная', 1),
       ('31.12.2024', 2, 'Ель натуральная', 3),
       ('31.12.2024', 3, 'Игрушка ёлочная Медведь', 10),
       ('31.12.2024', 4, 'Презервативы Visit 3шт', 1),
       ('31.01.2025', 5, 'Презервативы Visit 12шт', 1);