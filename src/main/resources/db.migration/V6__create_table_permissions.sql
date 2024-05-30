CREATE TABLE permissions (
    permission_id BIGSERIAL PRIMARY KEY,
    permission VARCHAR(20) NOT NULL UNIQUE
);
