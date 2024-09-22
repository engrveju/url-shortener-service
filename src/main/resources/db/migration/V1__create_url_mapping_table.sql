-- V1__create_url_mapping_table.sql
CREATE TABLE IF NOT EXISTS url_mapping (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    original_url VARCHAR(2048) NOT NULL,
    short_url VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(short_url)
    );

CREATE INDEX IF NOT EXISTS idx_short_url ON url_mapping(short_url);


