CREATE TABLE books
(
    id          UUID PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    description TEXT         NOT NULL,
    author_id   UUID REFERENCES authors (id),
    CONSTRAINT books_author_id_fkey FOREIGN KEY (author_id) REFERENCES authors (id) ON DELETE CASCADE
);
