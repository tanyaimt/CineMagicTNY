package com.metaphorce_tny.api.CineMagicTNY.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sala")
    private Long id_sala;

    @Column(name = "costo", nullable = false)
    private String costo;

    @Column(name = "cantidad_asientos")
    private int cantidad_asientos;

    @Column(name = "ultimo_editor", nullable = false, unique = true)
    private int ultimo_editor;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    public Sala() {
    }

    public Sala(Long id_sala, String costo, int cantidad_asientos, int ultimo_editor, String tipo) {
        this.id_sala = id_sala;
        this.costo = costo;
        this.cantidad_asientos = cantidad_asientos;
        this.ultimo_editor = ultimo_editor;
        this.tipo = tipo;
    }

    public Long getIdSala() {
        return id_sala;
    }

    public void setIdSala(Long id_sala) {
        this.id_sala = id_sala;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public int getCantidadAsientos() {
        return cantidad_asientos;
    }

    public void setCantidadAsientos(int cantidad_asientos) {
        this.cantidad_asientos = cantidad_asientos;
    }

    public int getUltimoEditor() {
        return ultimo_editor;
    }

    public void setUltimoEditor(int ultimo_editor) {
        this.ultimo_editor = ultimo_editor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id_sala=" + id_sala +
                ", costo='" + costo + '\'' +
                ", cantidad_asientos=" + cantidad_asientos +
                ", ultimo_editor='" + ultimo_editor + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}

