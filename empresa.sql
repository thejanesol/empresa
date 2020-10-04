CREATE SCHEMA IF NOT EXISTS empresa;
USE empresa;

CREATE TABLE funcionario (
	matricula INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    cpf VARCHAR(14) UNIQUE,
    rg VARCHAR(14) UNIQUE,
    salario DECIMAL(10,2),
    data_nascimento DATE,
    email VARCHAR(100) UNIQUE,
    senha VARCHAR(10) DEFAULT 0,
    habilitado BOOL DEFAULT 1
) ENGINE = InnoDB;

INSERT INTO funcionario VALUES (3080, "Ana", "659.321.879-85", "33.854.898-44", 5000,
"1980-05-18", "ana_gerente@gmail.com", "ana8585", 1);
INSERT INTO funcionario VALUES (4020, "Mario", "678.322.878-84", "34.855.899-45", 2000,
"1990-03-02", "mario90@gmail.com", "mario90", 1);
INSERT INTO funcionario VALUES (4030, "Julia", "679.322.878-84", "35.855.899-45", 2000,
"1992-09-21", "julia92@gmail.com", "julia92", 1);


CREATE TABLE autorizacao (
	id INT PRIMARY KEY,
    autoridade VARCHAR(20),
    fk_email VARCHAR(100),
    FOREIGN KEY (fk_email) REFERENCES funcionario(email),
     FOREIGN KEY (id) REFERENCES funcionario(matricula)
) ENGINE = InnoDB;

INSERT INTO autorizacao VALUES (3080, "ROLE_GERENTE", "ana_gerente@gmail.com");
INSERT INTO autorizacao VALUES (4020, "ROLE_FUNCIONARIO", "mario90@gmail.com");
INSERT INTO autorizacao VALUES (4030, "ROLE_FUNCIONARIO", "julia92@gmail.com");


CREATE TABLE cliente (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    cpf VARCHAR(14) UNIQUE,
    rg VARCHAR(14) UNIQUE,
    email VARCHAR(100) UNIQUE
) ENGINE = InnoDB;

insert into cliente (nome, cpf, rg, email) values("João da Silva",  "524.628.674-52", "25.623.184-12", "jsilva96@gmail.com");
insert into cliente (nome, cpf, rg, email) values("Maria Emilia", "448.236.764-28", "48.354.658-69", "emy_ma@gmail.com");
insert into cliente values(null, "José Benevides", "658.321.879-85", "32.854.898-44", "bene_87@gmail.com");


CREATE TABLE endereco (
	id INT PRIMARY KEY AUTO_INCREMENT,
	numero INT NOT NULL,
    rua VARCHAR(100) NOT NULL,
	bairro VARCHAR(100) NOT NULL,
    complemento VARCHAR(255),
    cidade VARCHAR(100),
    estado VARCHAR(50),
    fk_cliente INT,
    fk_funcionario INT,
    FOREIGN KEY (fk_cliente) REFERENCES cliente(id),
    FOREIGN KEY (fk_funcionario) REFERENCES funcionario(matricula)
) ENGINE = InnoDB;


INSERT INTO endereco (numero, rua, bairro, complemento, cidade, estado, fk_funcionario)
VALUES(27, "Rua Michel Clarck", "Rio vermelho", NULL, "Salvador", "Bahia", 3080);
INSERT INTO endereco (numero, rua, bairro, complemento, cidade, estado, fk_funcionario)
VALUES(9, "Rua Flores", "Rio vermelho", NULL, "Salvador", "Bahia", 4020);
INSERT INTO endereco (numero, rua, bairro, complemento, cidade, estado, fk_funcionario)
VALUES(9, "Rua das Lagoas", "Rio vermelho", NULL, "Salvador", "Bahia", 4030);

INSERT INTO endereco (numero, rua, bairro, complemento, cidade, estado, fk_cliente)
VALUES(27, "Travessa Rio Tietê", "Jardim Santa Luzia", NULL, "Passos", "Minas Gerais", 1), 
(346 ,"Rua Samuel da Rocha Galvão", "Cidade da Saúde", NULL, "Itapevi", "São Paulo", 2),
(169 ,"Rua 4 de Dezembro", "Vila Formosa", NULL, "São Paulo", "São Paulo", 3);


create table telefone(
	id INT PRIMARY KEY AUTO_INCREMENT,
	ddd VARCHAR(2) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    fk_cliente INT,
    fk_funcionario INT,
    FOREIGN KEY (fk_cliente) REFERENCES cliente(id),
    FOREIGN KEY (fk_funcionario) REFERENCES funcionario(matricula)
) ENGINE = InnoDB;

insert into telefone (ddd, numero, fk_funcionario) values("71", "992882500", 3080);
insert into telefone (ddd, numero, fk_funcionario) values("71", "992882600", 4020);
insert into telefone (ddd, numero, fk_funcionario) values("71", "992882700", 4030);

insert into telefone (ddd, numero, fk_cliente) values("25", "988457125", 1);
insert into telefone (ddd, numero, fk_cliente) values("16", "991782541", 1);
insert into telefone (ddd, numero, fk_cliente) values("51", "981571152", 2);
insert into telefone (ddd, numero, fk_cliente) values("86", "998825416", 3);

CREATE TABLE produto (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(70) NOT NULL,
  descricao TEXT NOT NULL,
  estoque INT NOT NULL,
  preco DECIMAL(10,2) NOT NULL
) ENGINE = InnoDB;

insert  into produto (nome, descricao, estoque, preco) values 

('1969 Harley Davidson Ultimate Chopper' ,'This replica features working kickstand, front suspension, gear-shift lever, footbrake lever, drive chain, wheels and steering. All parts are particularly delicate due to their precise scale and require special care and attention.',33,'20810.00'),

('1952 Alpine Renault 1300','Turnable front wheels; steering function; detailed interior; detailed engine; opening hood; opening trunk; opening doors; and detailed chassis.',73,'21430.00'),

('1996 Moto Guzzi 1100i','Official Moto Guzzi logos and insignias, saddle bags located on side of motorcycle, detailed engine, working steering, working suspension, two leather seats, luggage rack, dual exhaust pipes, small saddle bag located on handle bars, two-tone paint with chrome accents, superior die-cast detail , rotating wheels , working kick stand, diecast metal with plastic parts and baked enamel finish.',25,'11894.00'),

('2003 Harley-Davidson Eagle Drag Bike','Model features, official Harley Davidson logos and insignias, detachable rear wheelie bar, heavy diecast metal with resin parts, authentic multi-color tampo-printed graphics, separate engine drive belts, free-turning front fork, rotating tires and rear racing slick, certificate of authenticity, detailed engine, display stand\r\n, precision diecast replica, baked enamel finish, 1:10 scale model, removable fender, seat and tank cover piece for displaying the superior detail of the v-twin engine',55,'19360.00'),

('1972 Alfa Romeo GTA','Features include: Turnable front wheels; steering function; detailed interior; detailed engine; opening hood; opening trunk; opening doors; and detailed chassis.',32,'13600.00'),

('1962 LanciaA Delta 16V','Features include: Turnable front wheels; steering function; detailed interior; detailed engine; opening hood; opening trunk; opening doors; and detailed chassis.',67,'14774.00'),

('1968 Ford Mustang','Hood, doors and trunk all open to reveal highly detailed interior features. Steering wheel actually turns the front wheels. Color dark green.',68,'19457.00'),

('2001 Ferrari Enzo','Turnable front wheels; steering function; detailed interior; detailed engine; opening hood; opening trunk; opening doors; and detailed chassis.',36,'20780.00'),

('1958 Setra Bus','Model features 30 windows, skylights & glare resistant glass, working steering system, original logos',15,'13667.00'),

('2002 Suzuki XREO','Official logos and insignias, saddle bags located on side of motorcycle, detailed engine, working steering, working suspension, two leather seats, luggage rack, dual exhaust pipes, small saddle bag located on handle bars, two-tone paint with chrome accents, superior die-cast detail , rotating wheels , working kick stand, diecast metal with plastic parts and baked enamel finish.',99,'15062.00'),

('1969 Corvair Monza','1:18 scale die-cast about 10\" long doors open, hood opens, trunk opens and wheels roll','22', '15108.00'),

('1968 Dodge Charger','1:12 scale model of a 1968 Dodge Charger. Hood, doors and trunk all open to reveal highly detailed interior features. Steering wheel actually turns the front wheels. Color black',91,'11744.00'),

('1969 Ford Falcon','Turnable front wheels; steering function; detailed interior; detailed engine; opening hood; opening trunk; opening doors; and detailed chassis.',10,'17302'),

('1970 Plymouth Hemi Cuda','Very detailed 1970 Plymouth Cuda model in 1:12 scale. The Cuda is generally accepted as one of the fastest original muscle cars from the 1970s. This model is a reproduction of one of the orginal 652 cars built in 1970. Red color.',56,'7980'),

('1957 Chevy Pickup','1:12 scale die-cast about 20\" long Hood opens, Rubber wheels',61,'11850'),

('1969 Dodge Charger','Detailed model of the 1969 Dodge Charger. This model includes finely detailed interior and exterior features. Painted in red and white.',73,'11516'),

('1940 Ford Pickup Truck','This model features soft rubber tires, working steering, rubber mud guards, authentic Ford logos, detailed undercarriage, opening doors and hood,  removable split rear gate, full size spare mounted in bed, detailed interior with opening glove box',26,'11667'),

('1993 Mazda RX-7','This model features, opening hood, opening doors, detailed engine, rear spoiler, opening trunk, working steering, tinted windows, baked enamel finish. Color red.',39,'14154'),

('1937 Lincoln Berline','Features opening engine cover, doors, trunk, and fuel filler cap. Color black',86,'10274'),

('1936 Mercedes-Benz 500K Special Roadster','This 1:18 scale replica is constructed of heavy die-cast metal and has all the features of the original: working doors and rumble seat, independent spring suspension, detailed interior, working steering system, and a bifold hood that reveals an engine so accurate that it even includes the wiring. All this is topped off with a baked enamel finish. Color white.',86,'5391'),

('1965 Aston Martin DB5','Die-cast model of the silver 1965 Aston Martin DB5 in silver. This model includes full wire wheels and doors that open with fully detailed passenger compartment. In 1:18 scale, this model measures approximately 10 inches/20 cm long.',90,'12444');


CREATE TABLE pedido (
	nfe INT PRIMARY KEY AUTO_INCREMENT,
    data_emissao DATE NOT NULL,
    valor_total DECIMAL(10,2) NOT NULL DEFAULT 0,
    status_pedido VARCHAR(10) NOT NULL DEFAULT "pendente",
    fk_cliente INT,
    FOREIGN KEY (fk_cliente) REFERENCES cliente(id)
) ENGINE = InnoDB;

INSERT INTO pedido 
VALUES (1, '2020-02-22', (SELECT preco FROM produto WHERE id = 1), "pendente", 1),
(2, '2020-02-23', (SELECT preco FROM produto WHERE id = 5) + (SELECT preco FROM produto WHERE id = 10), "concluído", 2),
(3, '2020-02-23', (SELECT preco FROM produto WHERE id = 7), "cancelado", 3),
(4, '2020-02-23', (SELECT preco FROM produto WHERE id = 9), "concluído", 3);

CREATE TABLE produto_pedido(
	id INT AUTO_INCREMENT PRIMARY KEY,
	fk_produto INT NOT NULL,
    fk_pedido INT NOT NULL,
    quantidade_produto INT DEFAULT 1,
    FOREIGN KEY (fk_produto) REFERENCES produto(id),
    FOREIGN KEY (fk_pedido) REFERENCES pedido(nfe)
) ENGINE = InnoDB;

INSERT INTO produto_pedido (fk_produto, fk_pedido, quantidade_produto) VALUES(1, 1, 1);
INSERT INTO produto_pedido (fk_produto, fk_pedido, quantidade_produto) VALUES(5, 2, 1);
INSERT INTO produto_pedido (fk_produto, fk_pedido, quantidade_produto) VALUES(10, 2, 1);
INSERT INTO produto_pedido (fk_produto, fk_pedido, quantidade_produto) VALUES(7, 3, 1);
INSERT INTO produto_pedido (fk_produto, fk_pedido, quantidade_produto) VALUES(9, 4, 1);