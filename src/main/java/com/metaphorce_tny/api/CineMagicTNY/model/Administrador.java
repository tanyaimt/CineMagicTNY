package com.metaphorce_tny.api.CineMagicTNY.model;

import jakarta.persistence.*;

@Entity
@Table(name = "administrador")
public class Administrador{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administrador")
    private Long id_administrador;

    @Column(name = "puesto", nullable = false)
    private String puesto;

    @Column(name = "salario")
    private int salario;

    public Administrador() {
    }

    public Administrador(Long id_administrador, String puesto, int salario) {
        this.id_administrador = id_administrador;
        this.puesto = puesto;
        this.salario = salario;
    }

    public Long getIdUsuario() {
        return id_administrador;
    }

    public void setIdUsuario(Long id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_administrador=" + id_administrador +
                ", puesto='" + puesto + '\'' +
                ", salario='" + salario + '\'' +
                '}';
    }
}

