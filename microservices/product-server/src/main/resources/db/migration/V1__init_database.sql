create table if not exists category (
    id bigint not null primary key,
    name varchar(255),
    description varchar(255)
);

create table if not exists product (
    id bigint not null primary key,
    name varchar(255),
    description varchar(255),
    available_quantity double precision not null,
    price numeric(38, 2),
    category_id bigint constraint fk_category_id references category(id)
);
