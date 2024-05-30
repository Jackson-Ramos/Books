CREATE TABLE authors
(
    id   UUID PRIMARY KEY,
    name VARCHAR(90) NOT NULL,
    CONSTRAINT authors_name_unique UNIQUE (name)
);
