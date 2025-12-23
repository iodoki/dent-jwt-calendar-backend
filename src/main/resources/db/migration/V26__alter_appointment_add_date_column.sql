ALTER TABLE appointments
ADD COLUMN  created_at TIMESTAMPTZ  DEFAULT now();

ALTER TABLE patient_services
ADD COLUMN  created_at TIMESTAMPTZ  DEFAULT now();
