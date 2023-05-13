CREATE TABLE car_auction
(
    id                   BIGSERIAL PRIMARY KEY,
    seller_name           VARCHAR(255)     NOT NULL,
    seller_address        VARCHAR(255)     NOT NULL,
    car_make              VARCHAR(255)     NOT NULL,
    car_model             VARCHAR(255)     NOT NULL,
    car_year              INT              NOT NULL,
    car_price             DOUBLE PRECISION NOT NULL,
    general_description    VARCHAR(255)     NOT NULL,
    car_mileage           INT              NOT NULL,
    car_condition_body     VARCHAR(255)     NOT NULL,
    car_condition_interior VARCHAR(255)     NOT NULL
);

INSERT INTO car_auction (seller_name, seller_address, car_make, car_model, car_year, car_price, general_description, car_mileage, car_condition_body, car_condition_interior)
VALUES ('John Doe', '123 Main St', 'Opel', 'Corsa', 2015, 8000.0, 'Good condition', 60000, 'Excellent', 'Good');

INSERT INTO car_auction (seller_name, seller_address, car_make, car_model, car_year, car_price, general_description, car_mileage, car_condition_body, car_condition_interior)
VALUES ('Jane Smith', '456 Oak St', 'Volkswagen', 'Passat', 2018, 15000.0, 'Excellent condition', 40000, 'Good', 'Good');

INSERT INTO car_auction (seller_name, seller_address, car_make, car_model, car_year, car_price, general_description, car_mileage, car_condition_body, car_condition_interior)
VALUES ('Mike Johnson', '789 Elm St', 'BMW', 'X5', 2020, 45000.0, 'Very good condition', 20000, 'Excellent', 'Excellent');

