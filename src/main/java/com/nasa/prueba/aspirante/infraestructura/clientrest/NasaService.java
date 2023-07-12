package com.nasa.prueba.aspirante.infraestructura.clientrest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nasa.prueba.aspirante.dominio.entities.NasaResponseEntity;
import com.nasa.prueba.aspirante.infraestructura.repository.INasaResponseEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NasaService {


    @Autowired
    INasaResponseEntityRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    private final String nasaEndpoint = "https://images-api.nasa.gov/search?q=";

    public void callRestApolloEndpoint() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        ResponseEntity<String> response
                = restTemplate.getForEntity(nasaEndpoint + "apollo 11", String.class);

        System.out.println("I am running to do some scheduled job");

        JsonNode root = mapper.readTree(response.getBody());
        JsonNode collection = root.path("collection");


        JsonNode arrNode = new ObjectMapper().readTree(collection.toPrettyString()).get("items");
        if (arrNode.isArray()) {
            for (JsonNode objNode : arrNode) {

                //Extract fields
                String href = objNode.path("href").toString();
                JsonNode array = objNode.get("data");
                JsonNode topEntry = array.get(0);
                String center = topEntry.get("center").toString();
                String title = topEntry.path("title").toString();
                String nasa_id = topEntry.path("nasa_id").toString();

                NasaResponseEntity entity = NasaResponseEntity.builder()
                        .center(center)
                        .nasa_id(nasa_id)
                        .title(title)
                        .href(href)
                        .build();

                repository.save(entity);
            }
        }
    }

}
