CREATE SCHEMA IF NOT EXISTS webservice
CHARACTER SET utf8
COLLATE utf8_general_ci;
COMMIT;

CREATE TABLE users (
  id          BIGINT AUTO_INCREMENT,
  first_name  VARCHAR(100),
  last_name   VARCHAR(100),
  salary      DOUBLE,

  PRIMARY KEY (id)
);