create table quartos(

    id bigint not null auto_increment,
    numero_quarto varchar(10) not null,
    tipo_quarto varchar(50) not null,
    status_quarto varchar(100) not null,
    preco_quarto double not null,

    primary key (id)

);