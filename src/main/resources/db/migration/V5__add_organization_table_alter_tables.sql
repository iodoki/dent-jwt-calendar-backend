CREATE TABLE clinics
(
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name       VARCHAR(100) NOT NULL,
    address    VARCHAR(200),
    phone      VARCHAR(50),
    email      VARCHAR(100),
    nipt       VARCHAR(100) not null unique,
    created_at TIMESTAMPTZ      DEFAULT now()
);

ALTER TABLE patients
    ADD COLUMN clinic_id UUID NOT NULL REFERENCES clinics(id);
ALTER TABLE doctors
    ADD COLUMN clinic_id UUID NOT NULL REFERENCES clinics(id);
ALTER TABLE services
    ADD COLUMN clinic_id UUID NOT NULL REFERENCES clinics(id);
ALTER TABLE appointments
    ADD COLUMN clinic_id UUID NOT NULL REFERENCES clinics(id);
alter table appointments
    owner to dentaluser;
