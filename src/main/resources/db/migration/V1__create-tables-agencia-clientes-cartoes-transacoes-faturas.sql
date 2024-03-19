create table agencia
(
    numero   INT primary key unique,
    endereco varchar(45) not null
);
create table clientes
(
    numero_conta      bigint primary key unique auto_increment,
    cpf_cnpj          varchar(14)        not null unique,
    nome              varchar(14)        not null,
    sobrenome         varchar(14)        not null,
    telefone          varchar(11) unique not null,
    saldo double not null,
    senha             varchar(14)        not null,
    email             varchar(45) unique not null,
    endereco          varchar(45),
    ativo             TINYINT(1),
    fk_numero_agencia INT,
    foreign key (fk_numero_agencia) references agencia (numero)
);

create table transacoes
(
    id               bigint primary key unique auto_increment,
    conta_favorecido bigint not null,
    valor double not null,
    data             datetime,
    fk_numero_conta  bigint,
    foreign key (fk_numero_conta) references clientes (numero_conta)
);