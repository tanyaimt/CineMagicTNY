CREATE DATABASE IF NOT EXISTS CineMagicTNYDB CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE CineMagicTNYDB;
#drop database CineMagicTNYDB;
#drop table Usuario;

-- Tabla de Usuario
CREATE TABLE Usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(100) NOT NULL UNIQUE,
    password_usuario VARCHAR(100) NOT NULL,
    rol ENUM('espectador', 'administrador') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `cinemagictnydb`.`Usuario` (`nombre_usuario`,`password_usuario`, `rol`) VALUES ('taroj', 'Pwd123', 'administrador');
INSERT INTO `cinemagictnydb`.`Usuario` (`nombre_usuario`,`password_usuario`, `rol`) VALUES ('joesp', 'Pwd123', 'espectador');
select * from Usuario;

-- Tabla de Espectadores
CREATE TABLE espectador (
    id_espectador INT PRIMARY KEY AUTO_INCREMENT,
    puntos INT,
    nombre VARCHAR(100) NOT NULL,
    edad INT,
    correo_electronico VARCHAR(100) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `cinemagictnydb`.`espectador` (`puntos`,`nombre`, `edad`, `correo_electronico`) VALUES (348,'Tanya', '35', 'anonimo@anom.com');
INSERT INTO `cinemagictnydb`.`espectador` (`puntos`,`nombre`, `edad`, `correo_electronico`) VALUES (465,'Luis', '35', 'anonimo2@anom.com');

-- Tabla de Administradores
CREATE TABLE administrador (
    id_administrador INT PRIMARY KEY AUTO_INCREMENT,
    salario DOUBLE(10, 2),
    puesto VARCHAR(100),
    nombre VARCHAR(100) NOT NULL,
    edad INT,
    correo_electronico VARCHAR(100) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `cinemagictnydb`.`administrador` (`salario`,`puesto`,`nombre`, `edad`, `correo_electronico`) VALUES (10230,'Cajero','Ana', '35', 'anonimo@anom.com');
INSERT INTO `cinemagictnydb`.`administrador` (`salario`,`puesto`,`nombre`, `edad`, `correo_electronico`) VALUES (11350,'Encargado','Sofia', '35', 'anonimo2@anom.com');

-- Tabla de Películas
CREATE TABLE pelicula (
    id_pelicula INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    duracion INT,
    descripcion TEXT,
    clasificacion VARCHAR(10),
    fecha_estreno DATE,
    ultimo_editor INT,
    FOREIGN KEY (ultimo_editor) REFERENCES administrador(id_administrador)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `cinemagictnydb`.`pelicula` (`nombre`,`duracion`,`descripcion`, `clasificacion`, `fecha_estreno`, `ultimo_editor`) VALUES ('Titcanic',128,'Titanic es una película estadounidense de 1997, dramática y de catástrofe, dirigida y escrita por James Cameron y protagonizada por Leonardo DiCaprio, Kate Winslet, Billy Zane, Kathy Bates, Gloria Stuart y Bill Paxton.2​3​ La trama, una epopeya romántica,3​4​ relata la relación de Jack Dawson y Rose DeWitt Bukater, dos jóvenes que se conocen y se enamoran a bordo del transatlántico RMS Titanic en su viaje inaugural desde Southampton (Inglaterra) a Nueva York (Estados Unidos) en abril de 1912. Pertenecientes a diferentes clases sociales, intentan salir adelante pese a las adversidades que los separarían de forma definitiva, entre ellas el prometido de Rose, Caledon «Cal» Hockley (un adinerado del cual ella no está enamorada, pero su madre la ha obligado a permanecer con él para garantizar un futuro económico próspero) y el hundimiento del barco tras chocar con un iceberg.','C', NOW(), 1);
INSERT INTO `cinemagictnydb`.`pelicula` (`nombre`,`duracion`,`descripcion`, `clasificacion`, `fecha_estreno`, `ultimo_editor`) VALUES ('Cars',104,'Cars es una película de comedia deportiva animada por ordenador de 2006 producida por Pixar Animation Studios y lanzada por Walt Disney Pictures. Fue dirigida por John Lasseter a partir de un guion propio junto con Daniel Fogelman, Joseph Henry Ranft, Kiel Murray, Philip Lorin y Jorgen Klubien, y una historia ideada más en profundidad por Lasseter y Ranft. Fue la última producción independiente por parte de Pixar antes de ser comprada por Disney en enero de 2006. La película está ambientada en un mundo poblado enteramente por coches parlantes antropomórficos entre otros vehículos, sigue a Lightning McQueen —Rayo McQueen en Español—, un auto deportivo novato que, de camino a la carrera más importante de su vida, se queda varado en un pueblo llamado Radiator Springs y aprende un par de cosas sobre la amistad, la familia y vida por las que realmente vale la pena esperar.','AA', NOW(), 1);

-- Tabla de Salas
CREATE TABLE sala (
    id_sala INT AUTO_INCREMENT PRIMARY KEY,
    cantidad_asientos INT,
    tipo ENUM('normal', 'vip','3d') NOT NULL,
    costo DOUBLE(10, 2),
    ultimo_editor INT,
    FOREIGN KEY (ultimo_editor) REFERENCES administrador(id_administrador)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Trigger para establecer el costo según el tipo de sala
DELIMITER //
CREATE TRIGGER trg_set_costo_sala BEFORE INSERT ON sala
FOR EACH ROW
BEGIN
    IF NEW.tipo = 'vip' THEN
        SET NEW.costo = 200.00;
    ELSEIF NEW.tipo = 'normal' THEN
        SET NEW.costo = 100.00;
    ELSEIF NEW.tipo = '3d' THEN
        SET NEW.costo = 150.00;
    END IF;
END//
DELIMITER ;
INSERT INTO `cinemagictnydb`.`sala` (`cantidad_asientos`,`tipo`, `ultimo_editor`) VALUES (30,'vip',1);
INSERT INTO `cinemagictnydb`.`sala` (`cantidad_asientos`,`tipo`, `ultimo_editor`) VALUES (40,'3d',1);

-- Tabla de Funciones
CREATE TABLE funcion (
    id_funcion INT AUTO_INCREMENT PRIMARY KEY,
    horario DATETIME,
    id_sala INT,
    id_pelicula INT,
    ultimo_editor INT,
    FOREIGN KEY (id_sala) REFERENCES sala(id_sala),
    FOREIGN KEY (id_pelicula) REFERENCES pelicula(id_pelicula),
    FOREIGN KEY (ultimo_editor) REFERENCES administrador(id_administrador)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `cinemagictnydb`.`funcion` (`horario`,`id_sala`,`id_pelicula`, `ultimo_editor`) VALUES (now(),1,1,1);
INSERT INTO `cinemagictnydb`.`funcion` (`horario`,`id_sala`,`id_pelicula`, `ultimo_editor`) VALUES (now(),2,2,1);

-- Tabla de Boletos
CREATE TABLE boleto (
    id_boleto INT AUTO_INCREMENT PRIMARY KEY,
    id_funcion INT,
    id_espectador INT,
    asiento INT,
    fecha_compra DATETIME,
    FOREIGN KEY (id_funcion) REFERENCES funcion(id_funcion),
    FOREIGN KEY (id_espectador) REFERENCES espectador(id_espectador)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `cinemagictnydb`.`boleto` (`id_funcion`,`id_espectador`,`asiento`, `fecha_compra`) VALUES (1,1,1,now());
INSERT INTO `cinemagictnydb`.`boleto` (`id_funcion`,`id_espectador`,`asiento`, `fecha_compra`) VALUES (2,2,2,now());

select * from sala