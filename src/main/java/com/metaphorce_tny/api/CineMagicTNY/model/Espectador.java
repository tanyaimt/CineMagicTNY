package com.metaphorce_tny.api.CineMagicTNY.model;

import jakarta.persistence.*;

@Entity
@Table(name = "espectador")
public class Espectador{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_espectador")
    private Long id_espectador;
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "correo_electronico")
    private String correo_electronico;

    @Column(name = "puntos", nullable = false)
    private String puntos;

    public Espectador() {
    }

    public Espectador(Long id_espectador, String puntos) {
        this.id_espectador = id_espectador;
        this.puntos = puntos;
    }

    public Long getIdUsuario() {
        return id_espectador;
    }

    public void setIdUsuario(Long id_espectador) {
        this.id_espectador = id_espectador;
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
    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_espectador=" + id_espectador +
                ", nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", puntos='" + puntos + '\'' +
                '}';
    }
}

