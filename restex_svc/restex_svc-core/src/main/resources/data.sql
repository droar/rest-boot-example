DROP TABLE IF EXISTS exm_users;

CREATE TABLE exm_users (
  usr_id INT AUTO_INCREMENT  PRIMARY KEY,
  usr_first_name VARCHAR(250) NOT NULL,
  usr_last_name VARCHAR(250) NOT NULL,
  usr_career VARCHAR(250) DEFAULT NULL
);

INSERT INTO exm_users (usr_first_name, usr_last_name, usr_career) VALUES
  ('Sergio', 'Roa', 'Software Engineer'),
  ('Sergio Clone', 'Roa clone', 'Software Engineer'),
  ('Example user 1', 'ex', 'Software Engineer'); 