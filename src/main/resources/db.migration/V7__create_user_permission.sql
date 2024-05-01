CREATE TABLE user_permission
(
    user_id       UUID REFERENCES users (user_id),
    permission_id UUID REFERENCES permissions (permission_id),
    PRIMARY KEY (user_id, permission_id)
);
