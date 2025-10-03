CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE roles
(
    id   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users
(
    id        UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    username  VARCHAR(100) UNIQUE NOT NULL,
    password  VARCHAR(200)        NOT NULL,
    full_name VARCHAR(200)
);

CREATE TABLE user_roles
(
    user_id UUID REFERENCES users (id),
    role_id UUID REFERENCES roles (id),
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE services
(
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name             VARCHAR(200) NOT NULL,
  --  duration_minutes INT          NOT NULL,
    price            double precision
);

CREATE TABLE doctors
(
    id        UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id   UUID REFERENCES users (id),
    specialty VARCHAR(200)
);

CREATE TABLE patients
(
    id            UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id       UUID REFERENCES users (id),
    date_of_birth DATE,
    phone         VARCHAR(50),
    fatherName    VARCHAR(50),
    email         VARCHAR(50)

);

CREATE TABLE appointments
(
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    doctor_id  UUID        NOT NULL REFERENCES doctors (id),
    patient_id UUID        NOT NULL REFERENCES patients (id),
    service_id UUID        NOT NULL REFERENCES services (id),
    start_time TIMESTAMPTZ NOT NULL,
    end_time   TIMESTAMPTZ NOT NULL,
    status     VARCHAR(20) NOT NULL,
    notes TEXT
);
