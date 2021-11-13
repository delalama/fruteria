DROP TABLE IF EXISTS billionaires;
DROP TABLE IF EXISTS offers;

CREATE TABLE offers (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  fact VARCHAR(250) NOT NULL,
  consequence VARCHAR(250) DEFAULT NULL
);

INSERT INTO offers (name, fact, consequence) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');