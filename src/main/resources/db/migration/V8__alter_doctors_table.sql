ALTER TABLE doctors
    ADD COLUMN first_name VARCHAR(25),
    ADD COLUMN last_name VARCHAR(25),
    ADD COLUMN full_name VARCHAR(50);

UPDATE doctors
    SET full_name = CONCAT(first_name, ' ', last_name);
    -- Use CONCAT() or the appropriate concatenation operator for your specific SQL dialect