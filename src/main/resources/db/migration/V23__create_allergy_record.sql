CREATE TABLE if not exists allergy_question
(
    id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    clinic_id    UUID NOT NULL REFERENCES clinics (id) ON DELETE CASCADE,
    description  varchar (500)
);

CREATE TABLE if not exists patient_allergy_record
(
    id                      UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    patient_id              UUID NOT NULL REFERENCES patients (id) ON DELETE CASCADE,
    allergy_question_id     UUID REFERENCES allergy_question (id) ON DELETE CASCADE,
    has_past_record         Boolean DEFAULT FALSE,
    note                    TEXT
);