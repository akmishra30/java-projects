DROP TABLE IF EXISTS stock;
DROP TABLE IF EXISTS trade;

CREATE TABLE IF NOT EXISTS stock (
  id        BIGINT IDENTITY PRIMARY KEY,
  code      VARCHAR(10) NOT NULL,
  description VARCHAR(50) NOT NULL,
  price  	DECIMAL(20, 4) NOT NULL,
  quantity     BIGINT
);

CREATE TABLE IF NOT EXISTS trade (
  id	BIGINT IDENTITY PRIMARY KEY,
  code  VARCHAR(10) NOT NULL,
  trade_amount  	DECIMAL(20, 4) NOT NULL,
  trade_time timestamp NOT NULL,
  quantity	BIGINT
);

