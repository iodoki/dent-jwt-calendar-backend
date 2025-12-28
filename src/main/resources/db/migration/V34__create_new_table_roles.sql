DROP TABLE dent_roles;


CREATE TABLE if not exists roles (
    id UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);