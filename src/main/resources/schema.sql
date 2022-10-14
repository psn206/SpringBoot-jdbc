create table customers(
                          id int primary key auto_increment,
                          name varchar(250) not null,
                          surname varchar(250) not null,
                          age int check ( age> 0 ) not null ,
                          phone_number varchar(20) not null
);



create table orders(
                       id int primary key auto_increment,
                       date timestamp default now(),
                       customers_id bigint references customers (id),
                       product_name varchar(200) not null,
                       amount bigint not null check ( amount > 0 )
);


