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
        //List<Empleado> lista2 = empleadoRepositorio.findByRegistro_activoIsTrue();
        List<SalaDTO> resultadoFinal = lista.stream().filter(s-> s.getRegistro_activo()==true).map(s -> {return new SalaDTO(s.getId_sala(), s.getNumero_sala() , s.getTotal_asientos(), s.getFecha_alta(), s.getFecha_modificacion(),s.getRegistro_activo()) ;}).collect(Collectors.toList());
        return resultadoFinal;
    }

    public SalaDTO obtenerSalaId(Integer idSala){
        Optional<Sala> sala = salaRepositorio.findById(idSala);
        if (sala.isPresent()){
            return new SalaDTO(sala.get().getId_sala(), sala.get().getNumero_sala(), sala.get().getTotal_asientos(),sala.get().getFecha_alta(), sala.get().getFecha_modificacion(), sala.get().getRegistro_activo());
        }
        return null;
    }

    public boolean crearSala(SalaDTO parametros){
        Sala sala = new Sala();

        sala.setNumero_sala(parametros.getNum_sala());
        sala.setTotal_asientos(parametros.getAsientos());
        sala.setFecha_alta(parametros.getFecha_alta());
        sala.setFecha_modificacion(parametros.getFecha_modificacion());
        sala.setRegistro_activo(parametros.getRegistro_activo());

        salaRepositorio.save(sala);
        return true;
    }

    public boolean actualizarSala(SalaDTO parametros){

        Sala sala = salaRepositorio.getOne(parametros.getSalaID());
        sala.setNumero_sala(parametros.getNum_sala());
        sala.setTotal_asientos(parametros.getAsientos());
        sala.setFecha_alta(parametros.getFecha_alta());
        sala.setFecha_modificacion(parametros.getFecha_modificacion());
        sala.setRegistro_activo(parametros.getRegistro_activo());

        salaRepositorio.save(sala);
        return true;
    }

    public boolean eliminarSala(Integer idSala){
        Sala sala = salaRepositorio.getReferenceById(idSala);
        salaRepositorio.delete(sala);
        return true;
    }

}
