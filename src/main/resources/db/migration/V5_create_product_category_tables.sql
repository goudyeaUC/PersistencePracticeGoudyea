create table categories
(
    id   BIGINT auto_increment
        primary key,
    name varchar(255) not null
);

create table products(
    id          BIGINT auto_increment
        primary key,
    name        VARCHAR(255) not null,
    description TEXT         null,
    price       DECIMAL(10, 2) not null,
    category_id BIGINT       not null,
    constraint products_categories_id_fk
        foreign key (category_id) references categories (id)
);