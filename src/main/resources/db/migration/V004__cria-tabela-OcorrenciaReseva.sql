create table ocorrencia_reserva (
	id bigint not null auto_increment,
    reserva_id bigint not null,
    unidade_id bigint not null,
    descricao text not null,
    data_registro datetime not null,

    primary key (id)
);


alter table ocorrencia_reserva add constraint fk_ocorrencia_reserva_reserva
foreign key (reserva_id) references reserva (id);
alter table ocorrencia_reserva add constraint fk_ocorrencia_reserva_unidade
foreign key (unidade_id) references unidade (id);