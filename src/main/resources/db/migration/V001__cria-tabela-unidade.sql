create table unidade(
	id bigint not null auto_increment,
    proprietario varchar (60) not null,
    contato varchar (25) not null,
    email varchar(120) not null,
    unidade bigint not null,
    torre varchar (60) not null,


    primary key (id)
);