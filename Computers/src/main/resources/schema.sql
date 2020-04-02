-- database computers

CREATE TABLE types
(
id SERIAL PRIMARY KEY,
periphery BOOLEAN NOT NULL,
energy_consumption INTEGER NOT NULL,
units VARCHAR (50) NOT NULL,
cooler_included BOOLEAN NOT NULL,
product_group VARCHAR(50) NOT NULL,
port VARCHAR(50) NOT NULL
);

CREATE TABLE parts
(
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
origin VARCHAR(50) NOT NULL,
price INTEGER NOT NULL,
currency VARCHAR (50) NOT NULL,
critical BOOLEAN NOT NULL,
type_id INTEGER REFERENCES types (id)
);


INSERT INTO types (periphery, energy_consumption, units, cooler_included, product_group, port) VALUES
(TRUE, 12, 'Watt', FALSE, 'input', 'USB'),
(FALSE, 60, 'Watt', TRUE, 'processing', 'LTP');

INSERT INTO parts (name, origin, price, currency, critical, type_id) VALUES
('keyboard', 'Malaysia', 798, 'MYR', FALSE , 1),
('motherboard', 'Korea', 100, 'USD', TRUE, 2);




