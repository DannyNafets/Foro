create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(100) not null unique,
    fecha_creacion datetime not null,
    status_topico varchar(100) not null,
    usuario_id int not null,
    curso_id int not null,

    primary key (id)
);