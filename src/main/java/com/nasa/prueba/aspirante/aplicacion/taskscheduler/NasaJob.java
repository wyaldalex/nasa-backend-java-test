package com.nasa.prueba.aspirante.aplicacion.taskscheduler;

import com.nasa.prueba.aspirante.infraestructura.clientrest.NasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class NasaJob {

    @Autowired
    NasaService nasaService;


    @Scheduled(cron = "0 */1 * ? * *")
    public void runNasaJob(){
        try {
            nasaService.callRestApolloEndpoint();
        } catch (Exception e) {
            System.out.println("Exception running Nasa Job: " + e.getMessage());
        }
    }
}
