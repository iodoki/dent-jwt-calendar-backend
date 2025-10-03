-- V3__add_appointment_services-table.sql

CREATE TABLE appointment_services
(
    appointment_id     UUID REFERENCES appointments (id) ON DELETE CASCADE,
    patient_service_id UUID REFERENCES patient_services (id) ON DELETE CASCADE,
    PRIMARY KEY (appointment_id, patient_service_id)
);