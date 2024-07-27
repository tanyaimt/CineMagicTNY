package com.metaphorce_tny.api.CineMagicTNY.model;

import jakarta.persistence.*;

@Entity
@Table(name = "boleto")
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleto")
    private Long id_boleto;

    @Column(name = "fecha_compra", nullable = false)
    private String fecha_compra;

    @Column(name = "id_funcion")
    private int id_funcion;

    @Column(name = "id_espectador", nullable = false, unique = true)
    private int id_espectador;

    @Column(name = "asiento", nullable = false)
    private int asiento;

    public Boleto() {
    }

    public Boleto(Long id_boleto, String fecha_compra, int id_funcion, int id_espectador, int asiento) {
        this.id_boleto = id_boleto;
        this.fecha_compra = fecha_compra;
        this.id_funcion = id_funcion;
        this.id_espectador = id_espectador;
        this.asiento = asiento;
    }

    public Long getIdBoleto() {
        return id_boleto;
    }

    public void setIdBoleto(Long id_boleto) {
        this.id_boleto = id_boleto;
    }

    public String getFechaCompra() {
        return fecha_compra;
    }

    public void setFechaCompra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getIdFuncion() {
        return id_funcion;
    }

    public void setIdFuncion(int id_funcion) {
        this.id_funcion = id_funcion;
    }

    public int getIdEspectador() {
        return id_espectador;
    }

    public void setIdEspectador(int id_espectador) {
        this.id_espectador = id_espectador;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "id_boleto=" + id_boleto +
                ", fecha_compra='" + fecha_compra + '\'' +
                ", id_funcion=" + id_funcion +
                ", id_espectador='" + id_espectador + '\'' +
                ", asiento='" + asiento + '\'' +
                '}';
    }
}

