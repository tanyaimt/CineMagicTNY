package com.metaphorce_tny.api.CineMagicTNY.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Long id_pelicula;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "duracion")
    private int duracion;

    @Column(name = "descripcion", nullable = false, unique = true)
    private String descripcion;

    @Column(name = "clasificacion", nullable = false)
    private String clasificacion;
    
    @Column(name = "fecha_estreno", nullable = false)
    private String fecha_estreno;

    @Column(name = "ultimo_editor")
    private int ultimo_editor;

    public Pelicula() {
    }

    public Pelicula(Long id_pelicula, String nombre, int duracion, String descripcion, String clasificacion, String fecha_estreno, int ultimo_editor) {
        this.id_pelicula = id_pelicula;
        this.nombre = nombre;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.clasificacion = clasificacion;
        this.fecha_estreno = fecha_estreno;
        this.ultimo_editor = ultimo_editor;
    }

    public Long getIdPelicula() {
        return id_pelicula;
    }

    public void setIdPelicula(Long id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getFechaEstreno() {
        return fecha_estreno;
    }

    public void setFechaEstreno(String fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public int getUltimoEditor() {
        return ultimo_editor;
    }

    public void setUltimoEditor(int ultimo_editor) {
        this.ultimo_editor = ultimo_editor;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id_pelicula=" + id_pelicula +
                ", nombre='" + nombre + '\'' +
                ", duracion=" + duracion +
                ", descripcion='" + descripcion + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                ", fecha_estreno='" + fecha_estreno + '\'' +
                ", ultimo_editor=" + ultimo_editor +
                '}';
    }
}
