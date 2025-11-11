CREATE TABLE if not exists allergy_questioner
(
    id                      UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    patient_id              UUID NOT NULL REFERENCES patients (id) ON DELETE CASCADE,
    allergy_question_id     UUID REFERENCES allergy_questioner (id) ON DELETE CASCADE,
    hasPastRecord           Boolean DEFAULT FALSE,
    note  TEXT
);