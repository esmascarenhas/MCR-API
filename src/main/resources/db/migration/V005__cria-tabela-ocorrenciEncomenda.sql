create table ocorrencia_encomenda (
	id bigint not null auto_increment,
    encomenda_id bigint not null,
    unidade_id bigint not null,
    descricao text not null,
    data_registro datetime not null,

    primary key (id)
);

alter table ocorrencia_encomenda add constraint fk_ocorrencia_encomenda_encomenda
foreign key (encomenda_id) references encomenda (id);

alter table ocorrencia_encomenda add constraint fk_ocorrencia_encomenda_unidade
foreign key (unidade_id) references unidade (id);