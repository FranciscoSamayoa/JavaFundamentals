package com.java.examen.modelos;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "c_sala")

public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = " id_sala")
    private Long id_sala;

    @Column(name = "numero_sala")
    private Long numero_sala;

    @Column(name = "total_asientos")
    private Long total_asientos;

    @Column(name = "fecha_alta")
    private Timestamp fecha_alta;

    @Column(name = "fecha_modificacion")
    private Timestamp fecha_modificacion;

    @Column(name = "registro_activo")
    private Boolean registro_activo;

    public Long getId_sala() {
        return id_sala;
    }

    public void setId_sala(Long id_sala) {
        this.id_sala = id_sala;
    }

    public Long getNumero_sala() {
        return numero_sala;
    }

    public void setNumero_sala(Long numero_sala) {
        this.numero_sala = numero_sala;
    }

    public Long getTotal_asientos() {
        return total_asientos;
    }

    public void setTotal_asientos(Long total_asientos) {
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
