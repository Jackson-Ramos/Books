CREATE TABLE library_book
(
    library_id UUID REFERENCES libraries (id),
    book_id    UUID REFERENCES books (id),
    PRIMARY KEY (library_id, book_id)
);
