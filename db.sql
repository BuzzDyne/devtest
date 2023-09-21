CREATE SCHEMA sql_comm;

USE sql_comm;

CREATE TABLE user_tm(
	id bigint auto_increment,
    name varchar(50),
	phone varchar(30),
    PRIMARY KEY (id)
) ENGINE InnoDB;

INSERT INTO user_tm(name, phone)
SELECT "Robb", 		"08111111111" 	UNION ALL
SELECT "Sansa", 	"082222222222" 	UNION ALL
SELECT "Arya", 		"08333333333" 	UNION ALL
SELECT "Bran", 		"081444444444" 	UNION ALL
SELECT "Rickon", 	"081555555555";

SELECT * FROM user_tm;