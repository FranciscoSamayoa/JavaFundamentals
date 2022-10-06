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

    @GetMapping("obtenerListaSala")
    public ResponseEntity<List<SalaDTO>> obtenerSala(){
        List<SalaDTO> lista = salaServicio.obtenerSala();
        return new ResponseEntity<>( lista, HttpStatus.OK);
    }

    @GetMapping("obtenerIdSala")
    public ResponseEntity<SalaDTO> obtenerSalaId(@RequestParam Integer idSala){
        SalaDTO respuesta = salaServicio.obtenerSalaId(idSala);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @PostMapping("crear")
    public ResponseEntity<Boolean> crearSala(@RequestBody SalaDTO paramentros){
        boolean respuesta = salaServicio.crearSala(paramentros);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @PutMapping ("actualizar")
    public ResponseEntity<Boolean> actualizarSala(@RequestBody SalaDTO parametros){
        boolean respuesta = salaServicio.actualizarSala(parametros);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @DeleteMapping("eliminar")
    public ResponseEntity<Boolean> eliminartSala(@RequestParam Integer idSala){
        boolean respuesta = salaServicio.eliminarSala(idSala);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

}
