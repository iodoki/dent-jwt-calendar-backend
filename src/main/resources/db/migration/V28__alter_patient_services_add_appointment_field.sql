ALTER TABLE patient_services
ADD COLUMN  appointment_id  UUID REFERENCES appointments (id) ON DELETE CASCADE;

