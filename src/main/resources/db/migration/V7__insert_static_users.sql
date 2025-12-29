INSERT INTO users (id, username, password, full_name)
SELECT
    'c6f06140-504a-4681-a48d-ee6bff91b356',
    'maria.kola@dentalconnect.al',
    '$2a$10$yQv30sREx5/HZNgEh0sV9uwKqP3ol3LH/ZHx6xPnt.N.A/0oZGRaC',
    'Maria Kola'
    TRUE
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE username = 'maria.kola@dentalconnect.al'
);
