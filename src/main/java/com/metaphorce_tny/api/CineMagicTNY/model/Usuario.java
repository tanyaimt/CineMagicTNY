package com.metaphorce_tny.api.CineMagicTNY.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id_usuario;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "correo_electronico", nullable = false, unique = true)
    private String correo_electronico;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    public Usuario() {
    }

    public Usuario(Long id_usuario, String nombre, int edad, String correo_electronico, String tipo) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.edad = edad;
        this.correo_electronico = correo_electronico;
        this.tipo = tipo;
    }

    public Long getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreoElectronico() {
        return correo_electronico;
    }

    public void setCorreoElectronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}

