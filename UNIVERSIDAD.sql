create table alumnos
(
    ID       int         not null
        primary key,
    NOMBRE   varchar(25) null,
    APELLIDO varchar(25) null,
    EDAD     int         null
);

create table hibernate_sequence
(
    next_val bigint null
);

create table matricula
(
    Curso_imparte    varchar(30) null,
    id_matricula     int         not null
        primary key,
    universidad      varchar(30) null,
    precio_matricula decimal     null,
    id_alumno        int         null,
    constraint matricula_alumnos_ID_fk
        foreign key (id_alumno) references alumnos (ID)
);

create table profesores
(
    idPROFESORES       int         not null
        primary key,
    NOMBRE             varchar(25) null,
    APELLIDO           varchar(25) null,
    ASIGNATURA_IMPARTE varchar(45) null
);

create table nomina
(
    salario          decimal    null,
    seguridad_social varchar(5) null,
    id_nomina        int        not null
        primary key,
    id_profesor      int        null,
    constraint nomina_profesores_idPROFESORES_fk
        foreign key (id_profesor) references profesores (idPROFESORES)
);

create table universidad
(
    direccion          varchar(40) null,
    nombre_universidad varchar(35) null,
    id_universidad     int         not null
        primary key,
    id_alumno          int         null,
    id_profesor        int         null,
    constraint universidad_alumnos_ID_fk
        foreign key (id_alumno) references alumnos (ID),
    constraint universidad_profesores_idPROFESORES_fk
        foreign key (id_profesor) references profesores (idPROFESORES)
);