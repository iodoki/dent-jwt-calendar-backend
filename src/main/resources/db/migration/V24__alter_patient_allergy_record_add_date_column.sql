ALTER TABLE patient_allergy_record
ADD COLUMN  created_at TIMESTAMPTZ  DEFAULT now();

ALTER TABLE allergy_question
    ALTER COLUMN description TYPE TEXT;
