SELECT product_name
FROM netology.ORDERS O
         LEFT JOIN netology.customers C on O.customer_id = C.id
WHERE lower(C.name) = lower(:name);