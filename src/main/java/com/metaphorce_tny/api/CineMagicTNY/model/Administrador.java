package com.metaphorce_tny.api.CineMagicTNY.model;

import jakarta.persistence.*;

@Entity
@Table(name = "administrador")
public class Administrador{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administrador")
    private Long id_administrador;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "correo_electronico")
    private String correo_electronico;

    @Column(name = "puesto", nullable = false)
    private String puesto;

    @Column(name = "salario")
    private double salario;

    public Administrador() {
    }

    public Administrador(Long id_administrador, String puesto, double salario) {
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_administrador=" + id_administrador +
                ", nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", puesto='" + puesto + '\'' +
                ", salario='" + salario + '\'' +
                '}';
    }
}

