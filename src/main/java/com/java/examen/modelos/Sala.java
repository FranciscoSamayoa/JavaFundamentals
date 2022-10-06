package com.java.examen.modelos;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "c_sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id_sala;
    @Column
    private Short numero_sala;
    @Column
    private Integer total_asientos;
    @Column
    private Timestamp fecha_alta;
    @Column
    private Timestamp fecha_modificacion;
    @Column
    private Boolean registro_activo;

    public Integer getId_sala() {
        return id_sala;
    }

    public void setId_sala(Integer id_sala) {
        this.id_sala = id_sala;
    }

    public Short getNumero_sala() {
        return numero_sala;
    }

    public void setNumero_sala(Short numero_sala) {
        this.numero_sala = numero_sala;
    }

    public Integer getTotal_asientos() {
        return total_asientos;
    }

    public void setTotal_asientos(Integer total_asientos) {
        this.total_asientos = total_asientos;
    }

    public Timestamp getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Timestamp fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Timestamp getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Timestamp fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public Boolean getRegistro_activo() {
        return registro_activo;
    }

    public void setRegistro_activo(Boolean registro_activo) {
        this.registro_activo = registro_activo;
    }

}
