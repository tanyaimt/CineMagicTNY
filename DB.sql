CREATE DATABASE IF NOT EXISTS CineMagicTNYDB CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE CineMagicTNYDB;

-- Tabla de Usuarios
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    edad INT,
    correo_electronico VARCHAR(100) NOT NULL UNIQUE,
    tipo ENUM('espectador', 'administrador') NOT NULL,
    CONSTRAINT chk_tipo CHECK (tipo IN ('espectador', 'administrador'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Tabla de Espectadores
CREATE TABLE espectador (
    id_espectador INT PRIMARY KEY,
    puntos INT,
    FOREIGN KEY (id_espectador) REFERENCES usuario(id_usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Tabla de Administradores
CREATE TABLE administrador (
    id_administrador INT PRIMARY KEY,
    salario DOUBLE(10, 2),
    puesto VARCHAR(100),
    FOREIGN KEY (id_administrador) REFERENCES usuario(id_usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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

-- Tabla de Salas
CREATE TABLE sala (
    id_sala INT AUTO_INCREMENT PRIMARY KEY,
    cantidad_asientos INT,
    tipo ENUM('normal', 'vip') NOT NULL,
    costo DOUBLE(10, 2),
    ultimo_editor INT,
    FOREIGN KEY (ultimo_editor) REFERENCES administrador(id_administrador)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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

-- Trigger para establecer el costo según el tipo de sala
DELIMITER //
CREATE TRIGGER trg_set_costo_sala BEFORE INSERT ON sala
FOR EACH ROW
BEGIN
    IF NEW.tipo = 'vip' THEN
        SET NEW.costo = 200.00;
    ELSEIF NEW.tipo = 'normal' THEN
        SET NEW.costo = 100.00;
    END IF;
END//
DELIMITER ;