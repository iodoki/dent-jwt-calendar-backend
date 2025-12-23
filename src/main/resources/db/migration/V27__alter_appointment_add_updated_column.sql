ALTER TABLE appointments
ADD COLUMN  updated_at TIMESTAMPTZ;

ALTER TABLE patient_services
ADD COLUMN  updated_at TIMESTAMPTZ;