--insercion tabla usuarios
insert into usuarios(nombre, apellido, email, contrasena, tipo_usuario)VALUES
('Juan', 'Fernandez', 'juan@email.com', 'juan123', 'admin'),
('Maria', 'Garcia', 'maria@email.com', 'maria123', ''),
('Pedro', 'Lopez', 'pedro@email.com', 'pedro123', ''),
('Eduardo', 'Lopez', 'eduardo@emial.com', 'eduardo123', 'admin');

--insercion tabla dificultad
insert into dificultades(dificultad)VALUES
('Facil'),
('Intermedio'),
('Avanzado');

--insercion tabla categoria
insert into categoria(nombre)VALUES
('Entradas'),
('Ensaladas'),
('Sopas'),
('Platos Principales'),
('Acompañamientos'),
('Postres'),
('Bebidas'),
('Salsas'),
('Marinados'),
('Snacks');

SELECT * from usuarios