use controle_acesso;

create table sistema (
	id int not null primary key auto_increment,
    sigla varchar(5) not null,
    nome varchar(100) not null
);

create table usuario (
	id int not null primary key auto_increment,
    login varchar(100) not null,
    senha varchar(100) not null
);

create table perfil (
	id int not null primary key auto_increment,
    nome varchar(100) not null,
    sistema_id int not null,
    foreign key (sistema_id) references Sistema (id)
);

create table autorizacao (
	id int not null primary key auto_increment,
    usuario_id int not null,
    perfil_id int not null,
	foreign key (usuario_id) references Usuario (id),
    foreign key (perfil_id) references Perfil (id)
);

create table funcionalidade (
	id int not null primary key auto_increment,
    nome varchar(100) not null,
    descricao varchar(255) not null,
    sistema_id int not null,
    foreign key (sistema_id) references Sistema (id)
);

create table componente (
	id int not null primary key auto_increment,
    nome varchar(100) not null
);

create table usuario_sistema (
    usuario_id int not null,
	sistema_id int not null,
    foreign key (usuario_id) references Usuario (id),
    foreign key (sistema_id) references Sistema (id)
);

create table perfil_funcionalidade (
	perfil_id int not null,
    funcionalidade_id int not null,
    foreign key (perfil_id) references Perfil (id),
	foreign key (funcionalidade_id) references Funcionalidade (id)
);

create table funcionalidade_componente (
    funcionalidade_id int not null,
    componente_id int not null,
	foreign key (funcionalidade_id) references Funcionalidade (id),
    foreign key (componente_id) references Componente (id)
);



select * from sistema;