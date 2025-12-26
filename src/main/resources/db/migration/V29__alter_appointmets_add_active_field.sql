ALTER TABLE appointments
ADD COLUMN  active Boolean  DEFAULT TRUE;

ALTER TABLE patient_services
ADD COLUMN  active Boolean  DEFAULT TRUE;