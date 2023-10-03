create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(100) not null unique,
    fecha_creacion datetime not null,
    status_topico varchar(100) not null,
    nombre_usuario varchar(100) not null,
    email varchar(100) not null,
    clave varchar(100) not null,
    nombre_curso varchar(100) not null,
    categoria varchar(100) not null,

    primary key (id)
);