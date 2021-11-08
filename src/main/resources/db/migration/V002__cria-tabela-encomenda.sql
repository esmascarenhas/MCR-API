create table encomenda (
	id bigint not null auto_increment,
    unidade_id bigint not null,
    status_encomenda varchar(20) not null,
    entrada_encomenda datetime not null,
    baixa_encomenda datetime,
    nota_fiscal varchar(40) not null,
    destinatario_nome varchar(40) not null,
    destinatario_rg varchar(20) not null,

    primary key (id)
);
alter table encomenda add constraint fk_encomenda_unidade
foreign key (unidade_id) references unidade (id);
