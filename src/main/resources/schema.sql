CREATE TABLE IF NOT EXISTS sys_user (
                                      id   BIGINT      NOT NULL PRIMARY KEY,
                                      name VARCHAR(50) NULL DEFAULT NULL,
    role VARCHAR(50) NULL DEFAULT NULL
    );