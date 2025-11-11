CREATE TABLE if not exists clinic_users
(
    clinic_id     UUID REFERENCES clinics (id) ON DELETE CASCADE,
    user_id       UUID REFERENCES users (id) ON DELETE CASCADE,
    PRIMARY KEY (clinic_id, user_id)
);