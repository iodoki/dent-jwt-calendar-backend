-- 1. Create clinic per clinic

INSERT INTO clinics (id, name, address, phone, email, tax_identity, enabled)
SELECT 'f68e0a99-6083-4605-9807-6ecf5a0d80dd', 'Elda & Edison Kola Dental', 'Lac', '00355....', 'kola@dentalconnect.al',  'kola_dental_connect_122025', TRUE
WHERE NOT EXISTS (SELECT 1 FROM clinics WHERE  tax_identity = 'kola_dental_connect_122025');

INSERT INTO clinics (id, name, address, phone, email, tax_identity, enabled)
SELECT '55116308-d862-4d15-83d1-062db5934fc5', 'Doki Dental', 'Tirane, Besnik Sykja 13', '00355....', 'doki@dentalconnect.al',  'doki_dental_connect_122025', TRUE
WHERE NOT EXISTS (SELECT 1 FROM clinics WHERE  tax_identity = 'doki_dental_connect_122025');


INSERT INTO clinics (id, name, address, phone, email, tax_identity, enabled)
SELECT '18086732-c546-478f-bb42-a1ecf1a8cd6b', 'Bright Dental Smile', 'Shkoder', '00355....', 'brightsmile@dentalconnect.al',  'brightsmile_dental_connect_122025', TRUE
WHERE NOT EXISTS (SELECT 1 FROM clinics WHERE  tax_identity = 'brightsmile_dental_connect_122025');

-- 2. Create users per clinic

-- KOLA DENTAL---
INSERT INTO users (id, username, password, full_name, role_name, email, clinic_id, enabled)
SELECT
    'c6f06140-504a-4681-a48d-ee6bff91c96f',
    'kola@dentalconnect.al',
    '$2a$10$yQv30sREx5/HZNgEh0sV9uwKqP3ol3LH/ZHx6xPnt.N.A/0oZGRaC',
    'Kola Assistant',
    'ADMIN',
    'kola@dentalconnect.al',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    TRUE
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE username = 'kola@dentalconnect.al'
);

INSERT INTO users (id, username, password, full_name, role_name, email, clinic_id, enabled)
SELECT
    'eebeaf51-08fe-4cb9-bd05-6005aa8a7f36',
    'elda.kola@dentalconnect.al',
    '$2a$10$lvhxt.nHy0LFQb7H0jC1Aum3OWU08AYZ5e7vvyNb9se7EI/KtzIu6',
    'Elda GJ. Kola',
    'DOCTOR',
    'elda.kola@dentalconnect.al',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    TRUE
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE username = 'elda.kola@dentalconnect.al'
);

INSERT INTO users (id, username, password, full_name, role_name, email, clinic_id, enabled)
SELECT
    'aac8d4a7-5e4f-4866-9aa3-cfdff4206fc4',
    'edison.kola@dentalconnect.al',
    '$2a$10$EOlJJl9jo5hS62yerUnxy.kqTxJ/ARyjMKOcbIFzzUQNXHHfWyv9i',
    'Edison Kola',
    'DOCTOR',
    'edison.kola@dentalconnect.al',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    TRUE
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE username = 'edison.kola@dentalconnect.al'
);

-- DOKI DENTAL---
INSERT INTO users (id, username, password, full_name, role_name, email, clinic_id, enabled)
SELECT
    '4e2a315a-2d12-4e2f-95da-ef9b2f3246d1',
    'mdoklea',
    '$2a$10$2pgn5ZCs31B9yWIG7Wqrl.GPCTT7XUwGa2uhDCzwQbkBo2MywCBQ6',
    'Klea Mc.',
    'SUPER_ADMIN',
    'doklea.meci@gmail.com',
    '55116308-d862-4d15-83d1-062db5934fc5',
    TRUE
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE username = 'mdoklea'
);

INSERT INTO users (id, username, password, full_name, role_name, email, clinic_id, enabled)
SELECT
    '1a041ea6-fb34-4cd5-a198-ae08c722563e',
    'doki@dentalconnect.al',
    '$2a$10$2pgn5ZCs31B9yWIG7Wqrl.GPCTT7XUwGa2uhDCzwQbkBo2MywCBQ6',
    'Doki Mc.',
    'ADMIN',
    'doki@dentalconnect.al',
    '55116308-d862-4d15-83d1-062db5934fc5',
    TRUE
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE username = 'doki@dentalconnect.al'
);

-- Bright Smiles DENTAL---
INSERT INTO users (id, username, password, full_name, role_name, email, clinic_id, enabled)
SELECT
    '14001c02-181d-4444-9498-5bbc77db6109',
    'bruno.mars@dentalconnect.al',
    '$2a$10$tmmfxBlcLAfhRL8c4UPPW.mBx0IMDKJtQyKjE9PNkHsdXv/AqX7eW',
    'Bruno Mars',
    'USER',
    'bruno.mars@dentalconnect.al',
    '18086732-c546-478f-bb42-a1ecf1a8cd6b',
    TRUE
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE username = 'bruno.mars@dentalconnect.al'
);

INSERT INTO users (id, username, password, full_name, role_name, email, clinic_id, enabled)
SELECT
    '07c60abc-56fe-4f07-a0fb-3f32df46d8bf',
    'alice.meta@dentalconnect.al',
    '$2a$10$DAcZwqq30R6nvRum6wmK7eQ4AoF.eTXC9sYmI4RIVCFbsSbN6Dzv.',
    'Alice Meta',
    'DOCTOR',
    'alice.meta@dentalconnect.al',
    '18086732-c546-478f-bb42-a1ecf1a8cd6b',
    TRUE
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE username = 'alice.meta@dentalconnect.al'
);
-- 3. Create doctors per clinic

INSERT INTO doctors (id, user_id, specialty, clinic_id, first_name, last_name, full_name, enabled)
SELECT
    '9fe2bfb7-47c6-40fb-a8a3-bc9922ef5b19',
    'eebeaf51-08fe-4cb9-bd05-6005aa8a7f36',
    'DENTIST',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'Elda Gj.',
     'Kola',
    'Elda Gj. Kola',
    TRUE
WHERE NOT EXISTS (
    SELECT 1 FROM doctors WHERE id = '9fe2bfb7-47c6-40fb-a8a3-bc9922ef5b19'
);

INSERT INTO doctors (id, user_id, specialty, clinic_id, first_name, last_name, full_name, enabled)
SELECT
    '29ec0998-e934-4180-9949-5d33de3efea3',
    'aac8d4a7-5e4f-4866-9aa3-cfdff4206fc4',
    'DENTIST',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'Edison',
    'Kola',
    'Edison Kola',
    TRUE
WHERE NOT EXISTS (
    SELECT 1 FROM doctors WHERE id = '29ec0998-e934-4180-9949-5d33de3efea3'
);

INSERT INTO doctors (id, user_id, specialty, clinic_id, first_name, last_name, full_name, enabled)
SELECT
    '29ec0998-e934-4180-9949-5d33de3efea3',
    '07c60abc-56fe-4f07-a0fb-3f32df46d8bf',
    'DENTIST',
    '55116308-d862-4d15-83d1-062db5934fc5',
    'Alice',
    'Meta',
    'Alice Meta',
    TRUE
WHERE NOT EXISTS (
    SELECT 1 FROM doctors WHERE id = '29ec0998-e934-4180-9949-5d33de3efea3'
);

INSERT INTO doctors (id, user_id, specialty, clinic_id, first_name, last_name, full_name, enabled)
SELECT
    'b52c5637-05fa-4257-8256-aa14494005d7',
    null,
    'DENTIST',
    '55116308-d862-4d15-83d1-062db5934fc5',
    'Ben',
    'Qendro',
    'Ben Qendro',
    TRUE
WHERE NOT EXISTS (
    SELECT 1 FROM doctors WHERE id = 'b52c5637-05fa-4257-8256-aa14494005d7'
);

INSERT INTO doctors (id, user_id, specialty, clinic_id, first_name, last_name, full_name, enabled)
SELECT
    '9ff081c0-d37e-411e-a1f4-4769306dc66b',
    null,
    'DENTIST',
    '18086732-c546-478f-bb42-a1ecf1a8cd6b',
    'Andonis',
    'Kuin',
    'Andonis Kuin',
    TRUE
WHERE NOT EXISTS (
    SELECT 1 FROM doctors WHERE id = '9ff081c0-d37e-411e-a1f4-4769306dc66b'
);
-- 4. Create categories per clinic
INSERT INTO service_categories (id, name, description)
SELECT
    '99999999-9999-9999-9999-999999999999',
    'General Dentistry',
    ''
WHERE NOT EXISTS(
    SELECT 1 FROM service_categories where id = '99999999-9999-9999-9999-999999999999'
);

INSERT INTO service_categories (id, name, description)
SELECT
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    'Cosmetic Dentistry',
    ''
WHERE NOT EXISTS(
    SELECT 1 FROM service_categories where id = 'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa'
);

INSERT INTO service_categories (id, name, description)
SELECT
    'a214c4a9-f7b8-44da-9fbf-05acb6358c92',
    'Aesthetic Treatment',
    ''
WHERE NOT EXISTS(
    SELECT 1 FROM service_categories where id = 'a214c4a9-f7b8-44da-9fbf-05acb6358c92'
);
-- 5. Create services per clinic
INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'b71255a2-86a3-45c3-935c-7b21b857788c',
    'Pastrim Gurëzash',
    2000.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'b71255a2-86a3-45c3-935c-7b21b857788c'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'b71255a2-86a3-45c3-935c-7b21b857788c',
    'Mbushje Dhëmbi për fëmije G.|| qumështi',
    1500.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'b71255a2-86a3-45c3-935c-7b21b857788c'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '032d122e-6f83-4ab5-992d-b65e759841b3',
    'Mbushje Dhëmbi për fëmije G.||| qumështi',
    2000.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '032d122e-6f83-4ab5-992d-b65e759841b3'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'e95c8106-5d68-498e-8b3e-150d6c55e2a8',
    'Mbushje Dhëmbi i përhershëm G.||',
    2500.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'e95c8106-5d68-498e-8b3e-150d6c55e2a8'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '0f955773-461e-48c4-8623-c1a812470be0',
    'Mbushje Dhëmbi i përhershëm G.|||',
    3500.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '0f955773-461e-48c4-8623-c1a812470be0'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'f1207493-b592-484f-b3c6-b21025dc9a84',
    'Mbushje Dhëmbi i përhershëm G.|V',
    4500.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'f1207493-b592-484f-b3c6-b21025dc9a84'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'f1207493-b592-484f-b3c6-b21025dc9a84',
    'Rikonstruksion me vidë',
    4000.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'f1207493-b592-484f-b3c6-b21025dc9a84'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'ae69a0a0-3af6-43f8-9424-41b31540d0d2',
    'Element Porcelani',
    9000.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'ae69a0a0-3af6-43f8-9424-41b31540d0d2'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'fcada426-4386-44b2-b6a0-95349b5850e5',
    'Element Zirkoni',
    20000.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'fcada426-4386-44b2-b6a0-95349b5850e5'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '9981884f-e13c-4ac8-86e4-54e777642577',
    'Protezë e skeletuar 1/2',
    3000.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '9981884f-e13c-4ac8-86e4-54e777642577'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '9995e7d2-5579-4b44-99c1-287a2a4d0717',
    'Protezë fleksibel 1/2',
    3500.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '9995e7d2-5579-4b44-99c1-287a2a4d0717'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'b7257712-10a9-429a-a9e5-a2afee2394f4',
    'Protezë klasike 1/2 totale',
    20000.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'b7257712-10a9-429a-a9e5-a2afee2394f4'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '1705c94d-c447-48a1-9f12-7ce11f12dab2',
    'Heqje dhëmbi pjekurie',
    2000.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '1705c94d-c447-48a1-9f12-7ce11f12dab2'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '537b13fc-c6d4-4817-a1a6-37e233dbe388',
    'Heqje dhembi të përhershëm',
    2000.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '537b13fc-c6d4-4817-a1a6-37e233dbe388'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'a9e79d98-1ac8-421f-9c04-08817a3aedbc',
    'Heqje dhembi të përhershëm',
    1000.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'a9e79d98-1ac8-421f-9c04-08817a3aedbc'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '6129cd16-360a-467f-96b2-35f2eb2303cf',
    'Heqje dhembi qumështi',
    500.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '6129cd16-360a-467f-96b2-35f2eb2303cf'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'a6129388-1398-4fd6-a2cf-ec9b9219572e',
    'Implant',
    70000.0,
    '99999999-9999-9999-9999-999999999999',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'a6129388-1398-4fd6-a2cf-ec9b9219572e'
);


INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '523bd048-968d-465a-98dd-95bb3f17f742',
    'Vizite e pare Ortontodike (studim rasti)',
    3000.0,
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '523bd048-968d-465a-98dd-95bb3f17f742'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '660ac9ba-ae89-4510-ba4e-4ae9472e1145',
    'Vizite mujore',
    2000.0,
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '660ac9ba-ae89-4510-ba4e-4ae9472e1145'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'da3a3d5c-45d7-493b-924b-0516baf574dc',
    'Aparat fiks me braketa metalike',
    100000.0,
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'da3a3d5c-45d7-493b-924b-0516baf574dc'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'fa2f401d-f250-470a-bdbe-dafdaf9e704f',
    'Aparat fiks me braketa qeramike',
    150000.0,
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'fa2f401d-f250-470a-bdbe-dafdaf9e704f'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '7a8540a4-87e9-4073-9cab-4047797786ab',
    'Zgjerues Rem',
    40000.0,
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '7a8540a4-87e9-4073-9cab-4047797786ab'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '8c738e96-89a9-47e1-b2b5-cde7d8d4308b',
    'Twin Block',
    50000.0,
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '8c738e96-89a9-47e1-b2b5-cde7d8d4308b'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '66c8531a-00d1-4af3-acf5-a789994ae9b5',
    'Pendulum',
    40000.0,
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '66c8531a-00d1-4af3-acf5-a789994ae9b5'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '172d57fe-07db-44d7-9085-deb81ddaf063',
    'Quad Helix me Grila',
    40000.0,
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '172d57fe-07db-44d7-9085-deb81ddaf063'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'adffd04c-8198-427f-8014-60d8aaeac771',
    'Buton Nance',
    20000.0,
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'adffd04c-8198-427f-8014-60d8aaeac771'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '7f1cfb9d-1055-4dc2-8f65-79ce6c41a19c',
    'Lip Bumper',
    25000.0,
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '7f1cfb9d-1055-4dc2-8f65-79ce6c41a19c'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '810c2e84-ef80-4008-a9ea-96fdb4731e4d',
    'Shine Ortondotike',
    5000.0,
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '810c2e84-ef80-4008-a9ea-96fdb4731e4d'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '2bb01ddd-e6e0-4387-8c64-db3e0fef6826',
    'Mask Faciale',
    30000.0,
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '2bb01ddd-e6e0-4387-8c64-db3e0fef6826'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'c96c9d7c-0059-448b-ba40-b1cb65082699',
    'Head Gear',
    30000.0,
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'c96c9d7c-0059-448b-ba40-b1cb65082699'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '63f7412b-3cff-469a-93a7-7e23d3b3450f',
    'Botox',
    200.0,
    'a214c4a9-f7b8-44da-9fbf-05acb6358c92',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'EUR'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '63f7412b-3cff-469a-93a7-7e23d3b3450f'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '61b6942b-a468-4dd8-ba07-991945f5cd90',
    'Baby Botox',
    150.0,
    'a214c4a9-f7b8-44da-9fbf-05acb6358c92',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'EUR'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '61b6942b-a468-4dd8-ba07-991945f5cd90'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '559445e8-e010-4f49-b976-ea749172ff2f',
    'Botox Gumy Smile',
    40.0,
    'a214c4a9-f7b8-44da-9fbf-05acb6358c92',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'EUR'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '559445e8-e010-4f49-b976-ea749172ff2f'
);


INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '85d74885-7bb3-423c-8979-2088d1079fb1',
    'Botox Burxismo',
    150.0,
    'a214c4a9-f7b8-44da-9fbf-05acb6358c92',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'EUR'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '85d74885-7bb3-423c-8979-2088d1079fb1'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '5a6dc9fa-1480-4ef0-81bb-4b76e6b34664',
    'Filler i Buzeve',
    200.0,
    'a214c4a9-f7b8-44da-9fbf-05acb6358c92',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'EUR'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '5a6dc9fa-1480-4ef0-81bb-4b76e6b34664'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'f4a5732c-265c-478c-8367-91defebb935f',
    'Filler Nazolabial',
    200.0,
    'a214c4a9-f7b8-44da-9fbf-05acb6358c92',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'EUR'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'f4a5732c-265c-478c-8367-91defebb935f'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'fed35f8f-9143-4fd3-bb57-80697bec66b7',
    'Filler i Mollzave',
    200.0,
    'a214c4a9-f7b8-44da-9fbf-05acb6358c92',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'EUR'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'fed35f8f-9143-4fd3-bb57-80697bec66b7'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'a057402f-4d68-46e8-b104-1c2e89f59de2',
    'Fije PDO',
    15.0,
    'a214c4a9-f7b8-44da-9fbf-05acb6358c92',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'EUR'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'a057402f-4d68-46e8-b104-1c2e89f59de2'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'e4aa9474-caa5-401f-808f-432eb84491b6',
    'Peeling Kimik',
    50.0,
    'a214c4a9-f7b8-44da-9fbf-05acb6358c92',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'EUR'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'e4aa9474-caa5-401f-808f-432eb84491b6'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'fd2607f9-7fbc-4238-a8d3-273295388864',
    'Mesoterapi Vitamina',
    70.0,
    'a214c4a9-f7b8-44da-9fbf-05acb6358c92',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'EUR'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'fd2607f9-7fbc-4238-a8d3-273295388864'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '0264cc27-aca4-41d7-a072-f04dd95dfb22',
    'PRP fytyre',
    50.0,
    'a214c4a9-f7b8-44da-9fbf-05acb6358c92',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'EUR'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '0264cc27-aca4-41d7-a072-f04dd95dfb22'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '024033d0-fdc8-410c-b5d7-c6d6bb2c217d',
    'PRP floket',
    50.0,
    'a214c4a9-f7b8-44da-9fbf-05acb6358c92',
    'f68e0a99-6083-4605-9807-6ecf5a0d80dd',
    'EUR'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '024033d0-fdc8-410c-b5d7-c6d6bb2c217d'
);

-- Testing Clinic Data --

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '52540497-ac1f-4efe-9c54-aef23576e1d6',
    'Vizite Nr.1',
    70000.0,
    '99999999-9999-9999-9999-999999999999',
    '55116308-d862-4d15-83d1-062db5934fc5',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '52540497-ac1f-4efe-9c54-aef23576e1d6'
);


INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'c3c284cd-0145-4dda-a2f1-e59284707ace',
    'Vizite Nr.2 (studim rasti)',
    3000.0,
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    '55116308-d862-4d15-83d1-062db5934fc5',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'c3c284cd-0145-4dda-a2f1-e59284707ace'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    'ff9973a9-84b4-4d84-82a0-e5d6d1f84b49',
    'Vizite Nr.3',
    70000.0,
    '99999999-9999-9999-9999-999999999999',
    '55116308-d862-4d15-83d1-062db5934fc5',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = 'ff9973a9-84b4-4d84-82a0-e5d6d1f84b49'
);


INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '96918908-526c-4f70-93b2-2deb225c764e',
    'Vizite Nr.4 (studim rasti)',
    3000.0,
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    '55116308-d862-4d15-83d1-062db5934fc5',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '96918908-526c-4f70-93b2-2deb225c764e'
);

INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '924359c9-f089-40b1-87a2-6c8e373988ed',
    'Vizite Nr.1',
    70000.0,
    '99999999-9999-9999-9999-999999999999',
    '18086732-c546-478f-bb42-a1ecf1a8cd6b',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '924359c9-f089-40b1-87a2-6c8e373988ed'
);


INSERT INTO services (id, name, price, category_id, clinic_id, currency)
SELECT
    '7b385ccd-1706-42d9-9370-965c50366b75',
    'Vizite Nr.2 (studim rasti)',
    3000.0,
    'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
    '18086732-c546-478f-bb42-a1ecf1a8cd6b',
    'ALL'
WHERE NOT EXISTS(
    SELECT 1 FROM services where id = '7b385ccd-1706-42d9-9370-965c50366b75'
);


-- 4. Create allergy question list per clinic






