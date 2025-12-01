--
-- PostgreSQL database dump
--



CREATE TABLE public.hospede (
    cpf VARCHAR(20) PRIMARY KEY,
    telefone VARCHAR(30),
    nome VARCHAR(50),
    rua VARCHAR(50),
    bairro VARCHAR(50),
    cidade VARCHAR(50)
);

CREATE TABLE public.quarto (
    numero INTEGER PRIMARY KEY,
    andar INTEGER,
    num_camas INTEGER
);

CREATE TABLE public.estadia (
    id_estadia INTEGER PRIMARY KEY,
    qtd_pessoas INTEGER,
    data_chegada VARCHAR(20),
    data_saida VARCHAR(20)
);

CREATE TABLE public.reserva (
    cpf VARCHAR(20) NOT NULL,
    id_estadia INTEGER NOT NULL,
    data_reserva VARCHAR(20),
    PRIMARY KEY (cpf, id_estadia),
    FOREIGN KEY (cpf) REFERENCES hospede(cpf) ON DELETE CASCADE,
    FOREIGN KEY (id_estadia) REFERENCES estadia(id_estadia) ON DELETE CASCADE
);

CREATE TABLE public.funcionarios (
    id_func INTEGER NOT NULL,
    nome VARCHAR(100) NOT NULL,
    turno VARCHAR(50)
);

INSERT INTO hospede (cpf, telefone, nome, rua, bairro, cidade) VALUES
('111111111', '47912345678', 'Maria', 'São João', 'America', 'Joinville'),
('222222222', '47923456789', 'João', 'Iririu', 'Iririu', 'Joinville'),
('333333333', '47934567890', 'Julia', 'São Paulo', 'Ilha', 'Florianopolis'),
('444444444', '47967892345', 'Gabriel', 'Canoinhas', 'Boa Vista', 'Palhoça'),
('555555555', '47926587419', 'Vitor', 'São Pedro', 'Centro', 'Itajai');

INSERT INTO quarto (numero, andar, num_camas) VALUES
(101, 1, 2),
(102, 1, 2),
(201, 2, 1),
(202, 2, 1),
(301, 3, 2);

INSERT INTO estadia (id_estadia, qtd_pessoas, data_chegada, data_saida) VALUES
(1, 1, '2025-11-25', '2025-11-30'),
(2, 2, '2025-11-24', '2025-12-01'),
(3, 1, '2025-11-25', '2025-11-30'),
(4, 1, '2025-11-23', '2025-11-25'),
(5, 2, '2025-11-20', '2025-11-30');

INSERT INTO reserva (cpf, id_estadia, data_reserva) VALUES
('111111111', 1, '2025-10-31'),
('222222222', 2, '2025-11-17'),
('333333333', 3, '2025-11-16'),
('444444444', 4, '2025-10-29'),
('555555555', 5, '2025-10-31');

INSERT INTO funcionarios (id_func, nome, turno) VALUES
(1, 'Mariana', 'Matutino'),
(2, 'Rafael', 'Vespertino'),
(3, 'Felipe', 'Noturno')
--
-- PostgreSQL database dump complete
--

