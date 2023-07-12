package com.nasa.prueba.aspirante.dominio.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NasaResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String href;
    private String center;
    private String title;
    private String nasa_id;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date creation_date;

}
