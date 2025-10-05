-- Insert Clinics
INSERT INTO clinics (id, name, address, phone, email, nipt)
VALUES ('64b8bb56-426c-4eb8-975e-28c0ca7d7d76', 'Kola Dental Clinic', '123 Main Street, Tirana, Albania',
        '+355-42-111-111',
        'contact@smiledental.com', 'n1234'),
       ('18086732-c546-478f-bb42-a1ecf1a8cd5b', 'Test Bright Smiles Orthodontics',
        '45 Rruga e Elbasanit, Tirana, Albania', '+355-42-222-222',
        'info@brightsmiles.com', 'n5678'),
       ('03d50abb-8c50-48ca-8884-e61c4ceacd12', 'Test Healthy Teeth Family Clinic',
        '78 Rruga Myslym Shyri, Tirana, Albania', '+355-42-333-333',
        'hello@healthyteeth.com', 'n0000');

-- dr_jones is ROLE_DOCTOR
-- Patients
INSERT INTO patients (id, first_name, last_name, email, phone, date_of_birth, clinic_id)
VALUES ('550e8400-e29b-41d4-a716-446655440000', 'John', 'Doe', 'john.doe@example.com', '+35560000001', '1990-05-12',
        '64b8bb56-426c-4eb8-975e-28c0ca7d7d76'),
       ('123e4567-e89b-12d3-a456-426614174000', 'Jane', 'Smith', 'jane.smith@example.com', '+35560000002',
        '1985-09-21', '64b8bb56-426c-4eb8-975e-28c0ca7d7d76'),
       ('9f8c62a7-5c31-4a5f-91d4-8a2a4b582001', 'Alice', 'Brown', 'alice.brown@example.com', '+35560000003',
        '1993-01-30', '64b8bb56-426c-4eb8-975e-28c0ca7d7d76');

-- Services
INSERT INTO services (id, name, price, clinic_id)
VALUES ('2f1c63b7-4c41-45a5-8f11-2a1d4b582010', 'General Consultation', 50.0, '64b8bb56-426c-4eb8-975e-28c0ca7d7d76'),
       ('3a6f72c8-5b52-4a7e-91e2-3b2d4b582011', 'Dental Cleaning', 75.0, '64b8bb56-426c-4eb8-975e-28c0ca7d7d76'),
       ('4b7f83d9-6c63-4b9f-a1f3-4c3d4b582012', 'Eye Examination', 60.0, '64b8bb56-426c-4eb8-975e-28c0ca7d7d76'),
       ('5c8f94ea-7d74-4caf-b2f4-5d4d4b582013', 'Cardiology Checkup', 120.0, '64b8bb56-426c-4eb8-975e-28c0ca7d7d76');

INSERT INTO service_categories (id, name)
VALUES ('99999999-9999-9999-9999-999999999999', 'General Dentistry'),
       ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Cosmetic Dentistry');
