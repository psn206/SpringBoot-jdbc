insert into customers(name, surname, age, phone_number)
values ('Иван', 'Иванов', 18, 11112),
       ('Алексей', 'Алексеев', 30, 11113),
       ('Сергей', 'Сергеев', 22, 11114),
       ('Степан', 'Степанов', 27, 11115),
       ('Артем', 'Артемов', 45, 11116);

insert into orders(CUSTOMERS_ID, PRODUCT_NAME, AMOUNT)
values (1, 'хлеб', 50),
       (1, 'масло', 150),
       (2, 'икра', 3000),
       (2, 'шоколад', 100),
       (3, 'молоко', 60),
       (4, 'рыба', 1000),
       (3, 'мясо', 350);