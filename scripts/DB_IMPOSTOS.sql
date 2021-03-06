DROP TABLE IF EXISTS PRODUTOS CASCADE;

CREATE TABLE PRODUTOS (
	PRO_COD INTEGER,
	PRO_NOME VARCHAR(20),
	PRO_PRECO NUMERIC(8,2),
	PRO_ALIQUOTA NUMERIC(5,2), 

	CONSTRAINT PRO_PK PRIMARY KEY (PRO_COD)
);

DROP TABLE IF EXISTS SERVICOS CASCADE;

CREATE TABLE SERVICOS (
	SER_COD INTEGER,
	SER_NOME VARCHAR(20),
	SER_PRECO NUMERIC(8,2),

	CONSTRAINT SER_PK PRIMARY KEY (SER_COD)
);

INSERT INTO PRODUTOS (PRO_COD, PRO_NOME, PRO_PRECO, PRO_ALIQUOTA) VALUES (1, 'BASE', 79.90, 12);
INSERT INTO PRODUTOS (PRO_COD, PRO_NOME, PRO_PRECO, PRO_ALIQUOTA) VALUES (2, 'PRIMER', 59.90, 12);
INSERT INTO PRODUTOS (PRO_COD, PRO_NOME, PRO_PRECO, PRO_ALIQUOTA) VALUES (3, 'BLUSH', 35.90, 12);

INSERT INTO SERVICOS (SER_COD, SER_NOME, SER_PRECO) VALUES (1, 'PEELING', 599.90);
INSERT INTO SERVICOS (SER_COD, SER_NOME, SER_PRECO) VALUES (2, 'ESFOLIACAO', 99.90);
INSERT INTO SERVICOS (SER_COD, SER_NOME, SER_PRECO) VALUES (3, 'MASSAGEM FACIAL', 39.90);


SELECT PRO_COD, PRO_NOME, PRO_PRECO, PRO_ALIQUOTA FROM PRODUTOS WHERE PRO_COD = ;
SELECT PRO_COD, PRO_NOME, PRO_PRECO, PRO_ALIQUOTA FROM PRODUTOS ORDER BY PRO_COD;

SELECT SER_COD, SER_NOME, SER_PRECO FROM SERVICOS WHERE SER_COD = ;
SELECT SER_COD, SER_NOME, SER_PRECO FROM SERVICOS ORDER BY SER_COD;