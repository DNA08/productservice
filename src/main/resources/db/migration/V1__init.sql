CREATE TABLE category
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at VARCHAR(255) NULL,
    updated_at VARCHAR(255) NULL,
    value      VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    VARCHAR(255) NULL,
    updated_at    VARCHAR(255) NULL,
    title         VARCHAR(255) NULL,
    price         VARCHAR(255) NULL,
    category_id   BIGINT NULL,
    `description` VARCHAR(255) NULL,
    image         VARCHAR(255) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE category
    ADD CONSTRAINT uc_category_value UNIQUE (value);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);