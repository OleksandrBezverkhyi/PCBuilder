CREATE TABLE CPU
(
    ID    SERIAL PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL,
    PRICE DECIMAL      NOT NULL,
    COMP_INTERFACE VARCHAR(100) NOT NULL
);

CREATE TABLE MOTHERBOARD
(
    ID                SERIAL PRIMARY KEY,
    NAME              VARCHAR(100) NOT NULL,
    PRICE             DECIMAL      NOT NULL,
    CASE_FORM_FACTOR  TEXT         NOT NULL,
    CPU_SOCKET        TEXT         NOT NULL,
    GPU_INTERFACE     TEXT         NOT NULL,
    PSU_INTERFACE     TEXT         NOT NULL,
    RAM_INTERFACE     TEXT         NOT NULL,
    STORAGE_INTERFACE TEXT         NOT NULL,
    RAM_COUNT         INTEGER      NOT NULL

);

CREATE TABLE RAM
(
    ID             SERIAL PRIMARY KEY,
    NAME           VARCHAR(100) NOT NULL,
    PRICE          DECIMAL      NOT NULL,
    COMP_INTERFACE VARCHAR(100) NOT NULL
);

CREATE TABLE STORAGE
(
    ID             SERIAL PRIMARY KEY,
    NAME           VARCHAR(100) NOT NULL,
    PRICE          DECIMAL      NOT NULL,
    COMP_INTERFACE VARCHAR(100) NOT NULL
);

CREATE TABLE GPU
(
    ID             SERIAL PRIMARY KEY,
    NAME           VARCHAR(100) NOT NULL,
    PRICE          DECIMAL      NOT NULL,
    COMP_INTERFACE VARCHAR(100) NOT NULL
);

CREATE TABLE PC_CASE
(
    ID             SERIAL PRIMARY KEY,
    NAME           VARCHAR(100) NOT NULL,
    PRICE          DECIMAL      NOT NULL,
    COMP_INTERFACE VARCHAR(100) NOT NULL
);

CREATE TABLE PSU
(
    ID    SERIAL PRIMARY KEY,
    NAME  VARCHAR(100) NOT NULL,
    PRICE DECIMAL      NOT NULL
);

INSERT INTO CPU (NAME, PRICE, COMP_INTERFACE)
VALUES ('Intel Core i5-9600K',     6600.00,  'LGA1151'),
       ('Intel Core i7-10700K',    9900.00,  'LGA1200'),
       ('Intel Core i9-12900K',    17600.00, 'LGA1700'),
       ('AMD Ryzen 5 5600X',       6000.00,  'AM4'    ),
       ('AMD Ryzen 7 5800X',       9600.00,  'AM4'    ),
       ('AMD Ryzen 9 7950X',       21000.00, 'AM5'    ),
       ('AMD Threadripper 3960X',  40500.00, 'sTRX4'  ),
       ('AMD Threadripper 2990WX', 27000.00, 'TR4'    ),
       ('Intel Core i3-10100',     3300.00,  'LGA1200'),
       ('Intel Core i5-13400',     7200.00,  'LGA1700');

INSERT INTO MOTHERBOARD
(NAME, PRICE, CASE_FORM_FACTOR, CPU_SOCKET, GPU_INTERFACE, PSU_INTERFACE, RAM_INTERFACE, STORAGE_INTERFACE, RAM_COUNT)
VALUES ('ASUS ROG STRIX B550-F',     5400.00,  'ATX',       'AM4',     'PCI_EXPRESS_4_0', 'ATX_24_PIN', 'DDR4', 'SATA', 4),
       ('Gigabyte B660M DS3H',       3900.00,  'MICRO_ATX', 'LGA1700', 'PCI_EXPRESS_4_0', 'ATX_24_PIN', 'DDR4', 'M_2',  2),
       ('MSI MAG B660 TOMAHAWK',     5700.00,  'ATX',       'LGA1700', 'PCI_EXPRESS_4_0', 'EPS_8_PIN',  'DDR4', 'NVME', 4),
       ('ASRock B450M Steel Legend', 3000.00,  'MICRO_ATX', 'AM4',     'PCI_EXPRESS_3_0', 'ATX_24_PIN', 'DDR4', 'SATA', 2),
       ('ASUS PRIME X570-P',         4500.00,  'ATX',       'AM4',     'PCI_EXPRESS_4_0', 'ATX_24_PIN', 'DDR4', 'NVME', 4),
       ('Gigabyte TRX40 AORUS PRO',  11100.00, 'ATX',       'sTRX4',   'PCI_EXPRESS_4_0', 'EPS_8_PIN',  'DDR4', 'M_2',  8),
       ('ASUS ROG CROSSHAIR VIII',   9600.00,  'ATX',       'AM4',     'PCI_EXPRESS_4_0', 'EPS_8_PIN',  'DDR4', 'NVME', 4),
       ('MSI MPG Z490 GAMING EDGE',  6000.00,  'ATX',       'LGA1200', 'PCI_EXPRESS_3_0', 'ATX_24_PIN', 'DDR4', 'SATA', 4),
       ('ASRock Z790 PG Lightning',  6300.00,  'ATX',       'LGA1700', 'PCI_EXPRESS_5_0', 'EPS_8_PIN',  'DDR5', 'M_2',  4),
       ('ASUS ROG STRIX TRX40-E',    12000.00, 'ATX',       'TR4',     'PCI_EXPRESS_4_0', 'EPS_8_PIN',  'DDR4', 'NVME', 8);

INSERT INTO RAM (NAME, PRICE, COMP_INTERFACE)
VALUES ('Corsair Vengeance LPX 16GB',          1800.00, 'DDR4'),
       ('Kingston HyperX Fury 8GB',            1050.00, 'DDR4'),
       ('G.SKILL Trident Z RGB 32GB',          4500.00, 'DDR4'),
       ('Corsair Dominator Platinum RGB 32GB', 5400.00, 'DDR5'),
       ('Kingston FURY Beast 16GB',            3600.00, 'DDR5'),
       ('Crucial Ballistix 8GB',               900.00,  'DDR4'),
       ('G.SKILL Ripjaws V 16GB',              1950.00, 'DDR4'),
       ('Patriot Viper Steel 16GB',            1650.00, 'DDR4'),
       ('TeamGroup T-Force Delta RGB 16GB',    3750.00, 'DDR5'),
       ('Corsair ValueSelect 4GB',             600.00,  'DDR3');

INSERT INTO STORAGE (NAME, PRICE, COMP_INTERFACE)
VALUES ('Samsung 970 EVO Plus 1TB',        3600.00,  'NVME'),
       ('Western Digital Blue 500GB',      1350.00,  'SATA'),
       ('Crucial MX500 1TB',               3000.00,  'SATA'),
       ('Samsung 980 PRO 2TB',             9600.00,  'NVME'),
       ('Seagate BarraCuda 2TB',           1650.00,  'SATA'),
       ('Kingston A2000 1TB',              3300.00,  'NVME'),
       ('Western Digital Black SN850 1TB', 7500.00,  'NVME'),
       ('Crucial P5 Plus 2TB',             10500.00, 'NVME'),
       ('ADATA XPG SX8200 Pro 1TB',        3900.00,  'NVME'),
       ('Samsung 860 EVO 500GB',           2100.00,  'SATA');

INSERT INTO GPU (NAME, PRICE, COMP_INTERFACE)
VALUES ('NVIDIA GeForce RTX 3060',       9900.00,  'PCI_EXPRESS_4_0'),
       ('AMD Radeon RX 6600 XT',         11400.00, 'PCI_EXPRESS_4_0'),
       ('NVIDIA GeForce RTX 3080',       21000.00, 'PCI_EXPRESS_4_0'),
       ('AMD Radeon RX 6900 XT',         30000.00, 'PCI_EXPRESS_4_0'),
       ('NVIDIA GeForce GTX 1660 Super', 6900.00,  'PCI_EXPRESS_3_0'),
       ('AMD Radeon RX 5700 XT',         12000.00, 'PCI_EXPRESS_4_0'),
       ('NVIDIA GeForce RTX 4090',       48000.00, 'PCI_EXPRESS_5_0'),
       ('AMD Radeon RX 7900 XT',         27000.00, 'PCI_EXPRESS_5_0'),
       ('NVIDIA GeForce RTX 3070',       15000.00, 'PCI_EXPRESS_4_0'),
       ('AMD Radeon RX 580',             6000.00,  'PCI_EXPRESS_3_0');

INSERT INTO PSU (NAME, PRICE)
VALUES ('Corsair RM750x',                   3900.00),
       ('EVGA SuperNOVA 650 G5',            3300.00),
       ('Seasonic Focus GX-850',            4200.00),
       ('Cooler Master MWE Gold 650',       2700.00),
       ('be quiet! Straight Power 11 750W', 4500.00),
       ('Thermaltake Toughpower GF1 850W',  4800.00),
       ('Corsair CX550M',                   2250.00),
       ('NZXT C750',                        3750.00),
       ('ASUS ROG Thor 850W',               6900.00),
       ('SilverStone Strider Gold S 650W',  3000.00);

INSERT INTO PC_CASE (NAME, PRICE, COMP_INTERFACE)
VALUES ('NZXT H510',                     2400.00, 'ATX'      ),
       ('Corsair Carbide Series 175R',   1800.00, 'ATX'      ),
       ('Cooler Master MasterBox Q300L', 1500.00, 'MICRO_ATX'),
       ('Fractal Design Define Mini C',  2700.00, 'MICRO_ATX'),
       ('Thermaltake Core V1',           1650.00, 'MINI_ITX' ),
       ('NZXT H210',                     3600.00, 'MINI_ITX' ),
       ('Phanteks Eclipse P400A',        2250.00, 'ATX'      ),
       ('Lian Li PC-O11 Dynamic',        4200.00, 'ATX'      ),
       ('SilverStone SG13',              1350.00, 'MINI_ITX' ),
       ('Corsair 4000D Airflow',         2850.00, 'ATX'      );