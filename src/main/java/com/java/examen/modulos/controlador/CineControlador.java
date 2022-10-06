package com.java.examen.modulos.controlador;

import com.java.examen.modulos.dto.CineDTO;
import com.java.examen.modulos.servicio.CineServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cine")
public class CineControlador {

    @Autowired
    private CineServicio cineServicio;

    @GetMapping("obtenerListaCine")
    public ResponseEntity<List<CineDTO>> obtenerCine(){
        List<CineDTO> lista = cineServicio.obtenerCine();
        return new ResponseEntity<>( lista, HttpStatus.OK);
    }

    @GetMapping("obtenerIdCine")
    public ResponseEntity<CineDTO> obtenerCineId(@RequestParam Integer idCine){
        CineDTO respuesta = cineServicio.obtenerCineId(idCine);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @PostMapping("crear")
    public ResponseEntity<Boolean> crearCine(@RequestBody CineDTO paramentros){
        boolean respuesta = cineServicio.crearCine(paramentros);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @PutMapping ("actualizar")
    public ResponseEntity<Boolean> actualizarCine(@RequestBody CineDTO parametros){
        boolean respuesta = cineServicio.actualizarCine(parametros);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @DeleteMapping("eliminar")
    public ResponseEntity<Boolean> eliminarCine(@RequestParam Integer idCine){
        boolean respuesta = cineServicio.eliminarCine(idCine);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

}
