-- create database recetas_cocina;
--Eduardo Garcia Lopez
--DAW 2023

--tabla de usuarios
create table usuarios(
    ID_Usuario serial primary key,
    nombre varchar(30) not null,
    apellido varchar(30) not null,
    email varchar(55) not null,
    contrasena varchar(50) not null,
    tipo_usuario varchar(50)
);
--tabla dificultad
create table dificultad(
    ID_Dificultad serial primary key,
    dificultad varchar(10) not null
);

--tabla categoria
create table categoria(
    ID_Categoria serial primary key,
    nombre varchar(50) not null
);

--tabla de recetas
create table recetas(
    ID_Recetas serial primary key,
    titulo varchar(30) not null,
    descripcion varchar(50) not null,
    porciones integer not null,
    tiempo_preparacion integer not null,
    ingredientes varchar(250) not null,
    instrucciones varchar(970) not null,
    fecha_publicacion date default current_date,
    --relacion con usuarios
    foreign key (ID_Usuario) references usuarios(ID_Usuario),
    --relacion con dificultad
    foreign key (ID_Dificultad) references dificultad(ID_Dificultad)
);

--tabla de recetas_categorias
create table recetas_categorias(
    ID_Recetas_Categorias serial primary key,
    --relacion con recetas
    foreign key (ID_Recetas) references recetas(ID_Recetas),
    --relacion con categoria
    foreign key (ID_Categoria) references categoria(ID_Categoria)
);

--tabla de comentarios
create table comentarios(
    ID_Comentario serial primary key,
    comentario varchar(250) not null,
    fecha_comentario date default current_date,
    --relacion con usuarios
    foreign key (ID_Usuario) references usuarios(ID_Usuario),
    --relacion con recetas
    foreign key (ID_Recetas) references recetas(ID_Recetas)
);

--tabla favoritos
create table favoritos(
    ID_Favoritos serial primary key,
    --relacion con usuarios
    foreign key (ID_Usuario) references usuarios(ID_Usuario),
    --relacion con recetas
    foreign key (ID_Recetas) references recetas(ID_Recetas)
);