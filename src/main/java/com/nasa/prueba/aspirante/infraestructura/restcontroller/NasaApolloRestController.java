package com.nasa.prueba.aspirante.infraestructura.restcontroller;

import com.nasa.prueba.aspirante.dominio.dto.NasaResponseDto;
import com.nasa.prueba.aspirante.infraestructura.service.NasaCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nasa")
public class NasaApolloRestController {

    @Autowired
    NasaCustomService nasaCustomService;

    @GetMapping("/apollo")
    public ResponseEntity<List<NasaResponseDto>> getApolloInfo() {
        return new ResponseEntity<>(nasaCustomService.retrieveNasaApolloEntries(), HttpStatus.OK);
    }
}
