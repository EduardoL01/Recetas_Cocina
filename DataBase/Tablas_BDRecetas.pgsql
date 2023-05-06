-- create database recetas_cocina;

--tabla de usuarios
create table usuarios(
    ID_Usuario serial primary key,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    email varchar(50) not null,
    contrasena varchar(50) not null,
    tipo_usuario varchar(50)
);
--tabla dificultad
create table dificultad(
    ID_Dificultad serial primary key,
    dificultad varchar(50) not null
);

--tabla categoria
create table categoria(
    ID_Categoria serial primary key,
    nombre varchar(50) not null
);

--tabla de recetas
create table recetas(
    ID_Recetas serial primary key,
    titulo varchar(50) not null,
    descripcion varchar(50) not null,
    porciones varchar(50) not null,
    tiempo_preparacion integer not null,
    ingredientes varchar(50) not null,
    instrucciones varchar(50) not null,
    fecha_publicacion date default current_date,
    fecha_actualizacion date default current_date,
    --relacion con usuarios
    ID_Usuario integer references usuarios(ID_Usuario),
    --relacion con dificultad
    ID_Dificultad integer references dificultad(ID_Dificultad)
);

--tabla de recetas_categorias
create table recetas_categorias(
    ID_Recetas_Categorias serial primary key,
    --relacion con recetas
    ID_Recetas integer references recetas(ID_Recetas),
    --relacion con categoria
    ID_Categoria integer references categoria(ID_Categoria)
);

--tabla de comentarios
create table comentarios(
    ID_Comentario serial primary key,
    comentario varchar(50) not null,
    fecha_comentario date default current_date,
    fecha_actualizacion date default current_date,
    --relacion con usuarios
    ID_Usuario integer references usuarios(ID_Usuario),
    --relacion con recetas
    ID_Recetas integer references recetas(ID_Recetas)
);

--tabla respuesta_comentarios
create table respuesta_comentarios(
    ID_Respuesta_Comentarios serial primary key,
    respuesta varchar(50) not null,
    fecha_respuesta date default current_date,
    fecha_actualizacion date default current_date,
    --relacion con usuarios
    ID_Usuario integer references usuarios(ID_Usuario),
    --relacion con comentarios
    ID_Comentario integer references comentarios(ID_Comentario)
);

--tabla favoritos
create table favoritos(
    ID_Favoritos serial primary key,
    --relacion con usuarios
    ID_Usuario integer references usuarios(ID_Usuario),
    --relacion con recetas
    ID_Recetas integer references recetas(ID_Recetas)
);