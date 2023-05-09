package com.example.security.ooredoo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class Maps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String longitude;
    private String latitude;
    private String adresse;
    @Enumerated(EnumType.STRING)
   private Etat etat;
private Date date_creation;
}
