create table respuestas(

    id bigint not null auto_increment,
    mensaje varchar(300) not null unique,
    topico_id int not null,
    fecha_creacion datetime not null,
    usuario_id int not null,
    solucion tinyint,
    
    primary key (id)
);