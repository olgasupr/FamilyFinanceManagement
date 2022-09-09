CREATE DATABASE IF NOT EXISTS Family_Finance_Management;

USE Family_Finance_Management;

CREATE TABLE IF NOT EXISTS period(
    id int NOT NULL auto_increment,
    from_date DATE,
    to_date DATE,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS income(
    id int NOT NULL auto_increment,
    amount DECIMAL(10, 2),
    period_id INT NOT NULL,
    FOREIGN KEY(period_id) REFERENCES period (id),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS spending_category(
    id int NOT NULL auto_increment,
    category_name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(50),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS target_spending(
    id int NOT NULL auto_increment,
    period_id INT NOT NULL,
    category_id INT NOT NULL,
    target_percent DECIMAL(3,2),
    within_income BOOLEAN,
    FOREIGN KEY(period_id) REFERENCES period (id),
    FOREIGN KEY (category_id) REFERENCES spending_category (id),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS actual_spending(
    id int NOT NULL auto_increment,
    category_id INT NOT NULL,
    amount DECIMAL(10, 2),
    spending_date DATE,
    FOREIGN KEY (category_id) REFERENCES spending_category (id),
    PRIMARY KEY (id)
);
