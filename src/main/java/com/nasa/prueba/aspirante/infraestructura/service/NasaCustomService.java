package com.nasa.prueba.aspirante.infraestructura.service;

import com.nasa.prueba.aspirante.dominio.dto.NasaResponseDto;
import com.nasa.prueba.aspirante.dominio.entities.NasaResponseEntity;
import com.nasa.prueba.aspirante.infraestructura.repository.INasaResponseEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NasaCustomService {

    @Autowired
    INasaResponseEntityRepository repository;

    public List<NasaResponseDto> retrieveNasaApolloEntries(){

        List<NasaResponseDto> dtos = new ArrayList<>();
        List<NasaResponseEntity> entities = repository.findAll();

        for(NasaResponseEntity dbEntity : entities){
            dtos.add(NasaResponseDto.builder()
                            .nasa_id(dbEntity.getNasa_id())
                    .nasa_id(dbEntity.getNasa_id())
                    .id(dbEntity.getId())
                    .title(dbEntity.getTitle())
                    .center(dbEntity.getCenter())
                    .href(dbEntity.getHref())
                    .build());
        }

        return dtos;
    }
}
