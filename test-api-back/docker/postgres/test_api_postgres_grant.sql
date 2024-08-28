DROP DATABASE IF EXISTS test;
CREATE USER test_postgres WITH PASSWORD 'test_postgres';
CREATE DATABASE test;
GRANT ALL PRIVILEGES ON DATABASE test TO test_postgres;
\c test test_postgres;
CREATE SCHEMA test_schema;

CREATE TABLE test_schema.log_information (
    id SERIAL PRIMARY KEY,
    logger_date TIMESTAMP,
    card VARCHAR(150),
    client_ip VARCHAR(150)
);

