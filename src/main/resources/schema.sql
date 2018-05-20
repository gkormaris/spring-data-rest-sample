DROP TABLE IF EXISTS department;

CREATE TABLE department (
    id          INT           NOT NULL,
    name        VARCHAR(40)   NOT NULL,
    building    VARCHAR(40)   NOT NULL,
    PRIMARY KEY (id),
    UNIQUE  KEY (name)
);

DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
    id          INT             NOT NULL,
    name        VARCHAR(14)     NULL,
    age         VARCHAR(16)     NULL,
    email       VARCHAR(16)     NULL,
    dep_id      INT             NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (dep_id) REFERENCES department (id),
);
