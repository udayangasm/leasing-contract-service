CREATE TABLE IF NOT EXISTS `customer` (
    id BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    date_of_birth DATETIME,
    PRIMARY KEY (id)
    );


CREATE TABLE IF NOT EXISTS `vehicle` (
    id BIGINT NOT NULL AUTO_INCREMENT,
    brand VARCHAR(255),
    model VARCHAR(255),
    model_year INT,
    price DOUBLE,
    vehicle_identification_number VARCHAR(255),
    PRIMARY KEY (id)
    );


CREATE TABLE IF NOT EXISTS `leasing_contract` (
    id BIGINT NOT NULL AUTO_INCREMENT,
    contract_number VARCHAR(255),
    monthly_rate DOUBLE,
    customer_id BIGINT,
    vehicle_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(id)
    );