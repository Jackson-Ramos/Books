CREATE TABLE users
(
    user_id                 UUID PRIMARY KEY,
    login                   VARCHAR(255) UNIQUE NOT NULL,
    full_name               VARCHAR(255)        NOT NULL,
    password                VARCHAR(255)        NOT NULL,
    account_non_expired     BOOLEAN             NOT NULL,
    account_non_locked      BOOLEAN             NOT NULL,
    credentials_non_expired BOOLEAN             NOT NULL,
    enabled                 BOOLEAN             NOT NULL
);
