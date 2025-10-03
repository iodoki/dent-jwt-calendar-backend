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


-- Insert Users
-- Encrypted versions of "password123"
-- (BCrypt is salted so each hash looks different, but all verify the same)
-- $2a$10$Dow1YHDjOQy3OB2dZDDU..w7LPfk2Dnq0dL6tzw9Ax0m7z6R5KyP6
-- $2a$10$G1Q9vXcHfJbGpg4m2e7yO.FB3UPmB87x1tGDdPiZ6M3f4Heo3fMtq
-- $2a$10$Ec7RRYlX.zNslS/RcDuhAOT2cI6UpaI1Cp1HbPvF6w/1kyrXw3z1iI

INSERT INTO users (id, username, email, password, clinic_id, enabled)
VALUES ('a3e6f1d2-7b47-4c2a-bc45-1c9a0d8f1a11', 'john_user', 'john.user@example.com',
        '$2a$10$Dow1YHDjOQy3OB2dZDDU..w7LPfk2Dnq0dL6tzw9Ax0m7z6R5KyP6',
        '64b8bb56-426c-4eb8-975e-28c0ca7d7d76', true),
       ('a3e6f1d2-7b47-4c2a-bc45-1c9a0d8f1a22', 'admin', 'doki@example.com',
        '$2a$10$Dow1YHDjOQy3OB2dZDDU..w7LPfk2Dnq0dL6tzw9Ax0m7z6R5KyP6',
        '64b8bb56-426c-4eb8-975e-28c0ca7d7d76', true),

       ('b7d8e2c3-6c34-4d1b-8f23-5e8b7f1c2d22', 'dr_smith', 'dr.smith@example.com',
        '$2a$10$G1Q9vXcHfJbGpg4m2e7yO.FB3UPmB87x1tGDdPiZ6M3f4Heo3fMtq',
        '64b8bb56-426c-4eb8-975e-28c0ca7d7d76', true),

       ('c9f1a4e5-8a56-41a2-9f67-6d8a9b1f3e33', 'dr_jones', 'dr.jones@example.com',
        '$2a$10$Ec7RRYlX.zNslS/RcDuhAOT2cI6UpaI1Cp1HbPvF6w/1kyrXw3z1i',
        '64b8bb56-426c-4eb8-975e-28c0ca7d7d76', true);

-- Insert Roles
INSERT INTO roles (id, name)
VALUES ('r1', 'ROLE_USER'),
       ('r2', 'ROLE_DOCTOR');

-- Map User Roles
INSERT INTO user_roles (user_id, role_id)
VALUES ('a3e6f1d2-7b47-4c2a-bc45-1c9a0d8f1a11', 'r1'), -- john_user is ROLE_USER
       ('b7d8e2c3-6c34-4d1b-8f23-5e8b7f1c2d22', 'r2'), -- dr_smith is ROLE_DOCTOR
       ('c9f1a4e5-8a56-41a2-9f67-6d8a9b1f3e33', 'r2');
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

-- Appointments
INSERT INTO appointments (id, patient_id, start_time, status, notes, clinic_id)
VALUES ('6d9fa5fb-8e85-4db0-c3f5-6e5d4b582014', '550e8400-e29b-41d4-a716-446655440000', '2025-10-01 10:00:00',
        'SCHEDULED', 'First-time consultation', '64b8bb56-426c-4eb8-975e-28c0ca7d7d76'),
       ('7ea0b60c-9f96-4ec1-d4f6-7f6d4b582015', '123e4567-e89b-12d3-a456-426614174000', '2025-10-02 14:30:00',
        'COMPLETED', 'Routine dental check', '64b8bb56-426c-4eb8-975e-28c0ca7d7d76'),
       ('9gc2d82e-b018-40e3-f6g8-9h8d4b582017', '550e8400-e29b-41d4-a716-446655440000', '2025-10-05 11:00:00',
        'SCHEDULED', 'Follow-up checkup', '64b8bb56-426c-4eb8-975e-28c0ca7d7d76');

-- Appointment Services (junction table)
INSERT INTO appointment_services (appointment_id, patient_service_id)
VALUES ('6d9fa5fb-8e85-4db0-c3f5-6e5d4b582014',
        '2f1c63b7-4c41-45a5-8f11-2a1d4b582010'),                                         -- John Doe - General Consultation
       ('7ea0b60c-9f96-4ec1-d4f6-7f6d4b582015', '3a6f72c8-5b52-4a7e-91e2-3b2d4b582011'), -- Jane Smith - Dental Cleaning
       ('8fb1c71d-af07-4fd2-e5f7-8g7d4b582016',
        '4b7f83d9-6c63-4b9f-a1f3-4c3d4b582012'),                                         -- Alice Brown - Eye Examination
       ('9gc2d82e-b018-40e3-f6g8-9h8d4b582017',
        '2f1c63b7-4c41-45a5-8f11-2a1d4b582010'),                                         -- John Doe - Follow-up General Consultation
       ('9gc2d82e-b018-40e3-f6g8-9h8d4b582017',
        '5c8f94ea-7d74-4caf-b2f4-5d4d4b582013'); -- John Doe - Cardiology Checkup

INSERT INTO service_categories (id, name)
VALUES ('99999999-9999-9999-9999-999999999999', 'General Dentistry'),
       ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Cosmetic Dentistry');

INSERT INTO patient_services (patient_id, service_id)
VALUES ('9f8c62a7-5c31-4a5f-91d4-8a2a4b582001',
        '2f1c63b7-4c41-45a5-8f11-2a1d4b582010'); -- John Doe - General Consultation

INSERT INTO users (id, username, password, full_name, email, clinic_id, enabled)
VALUES (gen_random_uuid(),
        'admin',
        '$2a$10$Dow1gI2xGZIQDZqXvUrL6O7hqQdpw3hRVGr2hwA0wK8F1JmAq5q9u', -- password: admin123
        'Admin Admin',
        'admin@gmail.com',
            '64b8bb56-426c-4eb8-975e-28c0ca7d7d76',
        true);