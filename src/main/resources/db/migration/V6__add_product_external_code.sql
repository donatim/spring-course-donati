ALTER TABLE products
    ADD COLUMN external_code VARCHAR(100);

ALTER TABLE products
    ADD CONSTRAINT uk_products_external_code
        UNIQUE (external_code);
