create table reserva (
	id bigint not null primary key auto_increment,
    unidade_id bigint not null,
    espaco_dados_do_espaco_id integer not null,
    espaco_dados_do_espaco_nome varchar(255) not null,
    status_reserva varchar(20) not null,
    data_inicio   datetime not null,
    data_termino datetime,
    vistoriador varchar(60) not null
);
create table espaco (
	dados_do_espaco_id integer primary key not null,
    dados_do_espaco_nome varchar(255) not null,
    status varchar(20) not null
);

alter table reserva add constraint fk_reserva_espaco
foreign key (espaco_dados_do_espaco_id) references espaco (dados_do_espaco_id);


alter table reserva add constraint fk_reserva_unidade
foreign key (unidade_id) references unidade (id);