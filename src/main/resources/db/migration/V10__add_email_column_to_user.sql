DELETE FROM users;

ALTER TABLE users
    ADD COLUMN email VARCHAR(255) UNIQUE NOT NULL;
