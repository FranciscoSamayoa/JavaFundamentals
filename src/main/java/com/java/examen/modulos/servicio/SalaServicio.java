package com.java.examen.modulos.servicio;

import com.java.examen.modelos.Sala;
import com.java.examen.modulos.dto.SalaDTO;
import com.java.examen.repositorios.SalaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalaServicio {

    @Autowired
    private SalaRepositorio salaRepositorio;
    public List<SalaDTO> obtenerSala(){
        List<Sala> lista = salaRepositorio.findAll();
        return lista.stream().map(e -> new SalaDTO(e.getId_sala(),e.getNumero_sala(),e.getTotal_asientos(),e.getFecha_alta(),e.getFecha_modificacion(),e.getRegistro_activo())).collect(Collectors.toList());
    }


    public SalaDTO obtenerSalaPorId(Long id_sala) {
        Optional<Sala> sala = salaRepositorio.findById(id_sala);

        if(sala.isPresent()){
            return new SalaDTO(sala.get().getId_sala(),sala.get().getNumero_sala(),sala.get().getTotal_asientos(),sala.get().getFecha_alta(),sala.get().getFecha_modificacion(),sala.get().getRegistro_activo());
        }
        return null;
    }

    public Boolean guardarSala(SalaDTO parametros) {
        Sala sala = new Sala();

        sala.setNumero_sala(parametros.getNumero_sala());
        sala.setTotal_asientos(parametros.getTotal_asientos());
        sala.setFecha_alta(parametros.getFecha_alta());
        sala.setFecha_modificacion(parametros.getFecha_modificacion());
        sala.setRegistro_activo(parametros.getRegistro_activo());

        salaRepositorio.save(sala);
        return true;
    }

    public boolean actualizarSala(SalaDTO parametros){

        Sala sala = salaRepositorio.getOne(parametros.getId_sala());
        sala.setNumero_sala(parametros.getNumero_sala());
        sala.setTotal_asientos(parametros.getTotal_asientos());
        sala.setFecha_alta(parametros.getFecha_alta());
        sala.setFecha_modificacion(parametros.getFecha_modificacion());
        sala.setRegistro_activo(parametros.getRegistro_activo());

        salaRepositorio.save(sala);
        return true;
    }

    public Boolean eliminarSala(long id_sala){
        Sala sala = salaRepositorio.getOne(id_sala);
        salaRepositorio.delete(sala);
        return true;
    }
}
