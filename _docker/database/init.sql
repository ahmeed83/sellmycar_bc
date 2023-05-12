CREATE TABLE car_auction
(
    id          SERIAL PRIMARY KEY,
    make        VARCHAR(100)   NOT NULL,
    model       VARCHAR(100)   NOT NULL,
    year        INTEGER        NOT NULL,
    price       NUMERIC(10, 2) NOT NULL,
    description TEXT
);

INSERT INTO car_auction (make, model, year, price, description)
VALUES ('Toyota', 'Camry', 2018, 15000.00, 'Great condition, low mileage.'),
       ('Honda', 'Civic', 2017, 12000.00, 'Well-maintained, fuel-efficient.'),
       ('Ford', 'Mustang', 2020, 30000.00, 'Powerful sports car, excellent performance.');
