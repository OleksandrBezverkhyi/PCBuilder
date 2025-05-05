 sql
CREATE TABLE cpu (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL NOT NULL,
    socket VARCHAR(50) NOT NULL DEFAULT 'LGA1200'
);

INSERT INTO cpu (name, price, socket) VALUES
('Intel i5-12400F', 8240, 'LGA1700'),
('AMD Ryzen 5 5600X', 12360, 'AM4'),
('Intel i7-12700K', 16480, 'LGA1200'),
('AMD Ryzen 7 5800X', 18540, 'AM4');

CREATE TABLE motherboard (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL NOT NULL,
    socket VARCHAR(50) NOT NULL DEFAULT 'LGA1200',
    max_ram_size_gb INT NOT NULL DEFAULT 64
);

INSERT INTO motherboard (name, price, socket) VALUES
('ASUS ROG STRIX B550-F', 6180, 'AM4'),
('MSI MAG B660M', 4940, 'LGA1700'),
('Gigabyte AORUS B450', 4120, 'AM4'),
('ASRock B460M Pro4', 3300, 'LGA1200');

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
    price DECIMAL NOT NULL,
    length_mm INT NOT NULL DEFAULT 250,
    min_psu_wattage INT NOT NULL DEFAULT 500
);

INSERT INTO gpu (name, price, length_mm, min_psu_wattage) VALUES
('NVIDIA RTX 3060', 16500, 242, 550),
('AMD RX 6700 XT', 19760, 267, 650),
('NVIDIA RTX 3080', 28840, 285, 750),
('AMD RX 6800 XT', 26780, 267, 700);

CREATE TABLE psu (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL NOT NULL,
    wattage INT NOT NULL DEFAULT 650
);

INSERT INTO psu (name, price, wattage) VALUES
('Seasonic FOCUS GX-650', 4120, 650),
('Corsair RM750x', 4940, 750),
('EVGA SuperNOVA 750 G5', 5350, 750),
('Cooler Master MWE Gold 650', 2880, 650);

CREATE TABLE pc_case (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL NOT NULL,
    max_gpu_length_mm INT NOT NULL DEFAULT 300
);

INSERT INTO pc_case (name, price, max_gpu_length_mm) VALUES
('NZXT H510', 2880, 325),
('Cooler Master MB311L', 2470, 345),
('Fractal Design Meshify C', 3710, 315),
('Phanteks P400A', 3300, 420);
