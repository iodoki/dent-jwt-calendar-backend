-- V2__add_service_categories_and_patient_services.sql

-- 1. Create service categories
CREATE TABLE service_categories
(
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        VARCHAR(100) NOT NULL UNIQUE,
    description TEXT
);

-- 2. Alter services table to add category relation
ALTER TABLE services
    ADD COLUMN category_id UUID REFERENCES service_categories (id);

-- 3. Create patient_services table
CREATE TABLE patient_services
(
    id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    patient_id   UUID NOT NULL REFERENCES patients (id) ON DELETE CASCADE,
    service_id   UUID NOT NULL REFERENCES services (id) ON DELETE CASCADE,
    description VARCHAR(10), -- e.g. "11", "26", "47" for toothNumber
    date         TIMESTAMP        DEFAULT now()
);

-- Optional: Indexes for faster lookups
CREATE INDEX idx_services_category_id ON services (category_id);
CREATE INDEX idx_patient_services_patient_id ON patient_services (patient_id);
CREATE INDEX idx_patient_services_service_id ON patient_services (service_id);
