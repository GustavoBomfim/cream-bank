create table agencia
(
    numero   INT primary key unique,
    endereco varchar(45) not null
);
create table clientes
(
    numero_conta      bigint primary key unique auto_increment,
    cpf_cnpj          varchar(14)        not null unique,
    telefone          varchar(9) unique  not null,
    saldo double not null,
    email             varchar(45) unique not null,
    endereco          varchar(45),
    fk_numero_agencia INT,
    foreign key (fk_numero_agencia) references agencia (numero)
);