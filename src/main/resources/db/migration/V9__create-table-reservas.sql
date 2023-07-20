create table reservas(

    id bigint not null auto_increment,
    hospede_id bigint not null,
    quarto_id bigint not null ,
    check_in datetime not null,
    check_out datetime not null,
    valor_total int not null,

    primary key (id),
    constraint fk_reservas_hospede_id foreign key (hospede_id) references hospedes(id),
    constraint fk_reservas_quarto_id foreign key (quarto_id) references quartos(id)

);