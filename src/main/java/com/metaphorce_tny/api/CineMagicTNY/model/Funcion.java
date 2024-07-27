package com.metaphorce_tny.api.CineMagicTNY.model;

import jakarta.persistence.*;

@Entity
@Table(name = "funcion")
public class Funcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcion")
    private Long id_funcion;

    @Column(name = "horario", nullable = false)
    private String horario;

    @Column(name = "ultimo_editor", nullable = false)
    private int ultimo_editor;

    @Column(name = "id_sala", nullable = false)
    private int id_sala;

    @Column(name = "id_pelicula", nullable = false)
    private int id_pelicula;

    public Funcion() {
    }

    public Funcion(Long id_funcion, String horario, int ultimo_editor, int id_sala, int id_pelicula) {
        this.id_funcion = id_funcion;
        this.horario = horario;
        this.ultimo_editor = ultimo_editor;
        this.id_sala = id_sala;
        this.id_pelicula = id_pelicula;
    }

    public Long getIdFuncion() {
        return id_funcion;
    }

    public void setIdFuncion(Long id_funcion) {
        this.id_funcion = id_funcion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getUltimoEditor() {
        return ultimo_editor;
    }

    public void setUltimoEditor(int ultimo_editor) {
        this.ultimo_editor = ultimo_editor;
    }

    public int getIdSala() {
        return id_sala;
    }

    public void setIdSala(int id_sala) {
        this.id_sala = id_sala;
    }

    public int getIdPelicula() {
        return id_pelicula;
    }

    public void setIdPelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "id_funcion=" + id_funcion +
                ", horario='" + horario + '\'' +
                ", ultimo_editor=" + ultimo_editor +
                ", id_sala=" + id_sala +
                ", id_pelicula=" + id_pelicula +
                '}';
    }
}

