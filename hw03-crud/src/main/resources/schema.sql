CREATE SCHEMA IF NOT EXISTS db_schema;

CREATE TABLE IF NOT EXISTS db_schema.users
(
    id        bigserial    not null primary key,
    user_name  varchar(256) not null unique,
    first_name varchar,
    last_name  varchar,
    email     varchar,
    phone     varchar
);