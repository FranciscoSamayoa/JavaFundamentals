package com.java.examen.modelos;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name= "m_cine")
public class Cine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_cine;
    @Column
    private String nombre;
    @Column
    private Timestamp fecha_alta;
    @Column
    private Timestamp fecha_modificacion;
    @Column
    private Boolean registro_activo;

    public Integer getId_cine() {return id_cine;}

    public void setId_cine(Integer id_cine) {this.id_cine = id_cine;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public Timestamp getFecha_alta() {return fecha_alta;}

    public void setFecha_alta(Timestamp fecha_alta) {this.fecha_alta = fecha_alta;}

    public Timestamp getFecha_modificacion() {return fecha_modificacion;}

    public void setFecha_modificacion(Timestamp fecha_modificacion) {this.fecha_modificacion = fecha_modificacion;}

    public Boolean getRegistro_activo() {return registro_activo;}

    public void setRegistro_activo(Boolean registro_activo) {this.registro_activo = registro_activo;}

}
