

SELECT product_name
FROM orders
         JOIN customers c on c.id = orders.customers_id
WHERE LOWER (name) = LOWER (:name);