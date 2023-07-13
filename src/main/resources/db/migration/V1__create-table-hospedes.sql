create table hospedes(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    telefone varchar(20) not null,
    email varchar(100) not null unique,
    ativo tinyint(1) not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(8) not null,
    cidade varchar(50) not null,
    uf varchar(2) not null,
    complemento varchar(100) not null,
    numero varchar(20) not null,

    primary key (id)

);