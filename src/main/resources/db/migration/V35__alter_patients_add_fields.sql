ALTER TABLE patients
ADD COLUMN  active Boolean  DEFAULT TRUE,
ADD COLUMN  created_at TIMESTAMPTZ  DEFAULT now(),
ADD COLUMN  updated_at TIMESTAMPTZ,
ADD COLUMN  gender VARCHAR(10),
ADD COLUMN  profession VARCHAR(50),
ADD COLUMN  address VARCHAR(150),
ADD COLUMN  identity_number VARCHAR(20),
ADD COLUMN  health_care_number VARCHAR(20);


