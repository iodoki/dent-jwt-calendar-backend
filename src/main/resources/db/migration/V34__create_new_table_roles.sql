DROP TABLE IF EXISTS dent_roles CASCADE;


CREATE TABLE if not exists roles (
    id UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);