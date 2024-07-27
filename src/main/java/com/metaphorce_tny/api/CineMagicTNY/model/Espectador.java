package com.metaphorce_tny.api.CineMagicTNY.model;

import jakarta.persistence.*;

@Entity
@Table(name = "espectador")
public class Espectador{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_espectador")
    private Long id_espectador;

    @Column(name = "puntos", nullable = false)
    private String puntos;

    public Espectador() {
    }

    public Espectador(Long id_espectador, String puntos, int edad, String correo_electronico, String tipo) {
        this.id_espectador = id_espectador;
        this.puntos = puntos;
    }

    public Long getIdUsuario() {
        return id_espectador;
    }

    public void setIdUsuario(Long id_espectador) {
        this.id_espectador = id_espectador;
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
                ", puntos='" + puntos + '\'' +
                '}';
    }
}

