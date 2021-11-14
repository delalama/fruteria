DROP TABLE IF EXISTS offers;

CREATE TABLE offers (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  fact VARCHAR(250) NOT NULL,
  consequence VARCHAR(250) DEFAULT NULL
);

INSERT INTO offers (id, name, fact, consequence) VALUES
  (1, 'Aliko', 'Dangote', 'Billionaire Industrialist'),
  (2, 'Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  (3, 'Folrunsho', 'Alakija', 'Billionaire Oil Magnate');

CREATE TABLE offersDesc (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  product VARCHAR(250) NOT NULL,
);

INSERT INTO offersDesc (id, name, product) VALUES
  (1, 'BuyThreeAndPayTwo', 'ORANGE,PEAR');
