package com.java.examen.modulos.controlador;

import com.java.examen.modulos.dto.SalaDTO;
import com.java.examen.modulos.servicio.SalaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sala")
public class SalaControlador {

    @Autowired
    private SalaServicio salaServicio;
    @GetMapping("obtener")
    public ResponseEntity<List<SalaDTO>> obtenerSalas(){
        List<SalaDTO> respuesta = salaServicio.obtenerSala();
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("obtener/id")
    public ResponseEntity<SalaDTO> obtenerSalas(@RequestParam Long id_sala){
        SalaDTO respuesta = salaServicio.obtenerSalaPorId(id_sala);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping("guardar")
    public ResponseEntity<Boolean> guardarSala(@ModelAttribute SalaDTO parametros){
        Boolean respuesta = salaServicio.guardarSala(parametros);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PutMapping("actualizar")
    public ResponseEntity<Boolean> actualizarSala(@ModelAttribute SalaDTO parametros){
        boolean respuesta = salaServicio.actualizarSala(parametros);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @DeleteMapping("eliminar")
    public ResponseEntity<Boolean> eliminarSala(@RequestParam Long id_sala){
        Boolean respuesta = salaServicio.eliminarSala(id_sala);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
