CREATE TABLE cpu (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL NOT NULL
);

INSERT INTO cpu (name, price) VALUES
('Intel i5-12400F', 8240),
('AMD Ryzen 5 5600X', 12360),
('Intel i7-12700K', 16480),
('AMD Ryzen 7 5800X', 18540);

CREATE TABLE motherboard (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL NOT NULL
);

INSERT INTO motherboard (name, price) VALUES
('ASUS ROG STRIX B550-F', 6180),
('MSI MAG B660M', 4940),
('Gigabyte AORUS B450', 4120),
('ASRock B460M Pro4', 3300);

CREATE TABLE ram (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL NOT NULL
);

INSERT INTO ram (name, price) VALUES
('Corsair Vengeance LPX 16GB', 3710),
('Kingston Fury Beast 32GB', 6590),
('G.Skill Ripjaws V 16GB', 3300),
('Crucial Ballistix 8GB', 1650);

CREATE TABLE storage (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL NOT NULL
);

INSERT INTO storage (name, price) VALUES
('Samsung 970 EVO Plus 1TB', 5360),
('Seagate Barracuda 2TB', 2470),
('Western Digital Blue SN550 500GB', 2060),
('Toshiba X300 4TB', 4940);

CREATE TABLE gpu (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL NOT NULL
);

INSERT INTO gpu (name, price) VALUES
('NVIDIA RTX 3060', 16500),
('AMD RX 6700 XT', 19760),
('NVIDIA RTX 3080', 28840),
('AMD RX 6800 XT', 26780);

CREATE TABLE psu (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL NOT NULL
);

INSERT INTO psu (name, price) VALUES
('Seasonic FOCUS GX-650', 4120),
('Corsair RM750x', 4940),
('EVGA SuperNOVA 750 G5', 5350),
('Cooler Master MWE Gold 650', 2880);

CREATE TABLE pc_case (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL NOT NULL
);

INSERT INTO pc_case (name, price) VALUES
('NZXT H510', 2880),
('Cooler Master MB311L', 2470),
('Fractal Design Meshify C', 3710),
('Phanteks P400A', 3300);
