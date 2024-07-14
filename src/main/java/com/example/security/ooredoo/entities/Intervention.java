package com.example.security.ooredoo.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private Date date ;
    private String nature ;
    private String Categories;
    private String abonnement;
    private String msisdn;
    private String nom ;
    private String prenom;
    private String adresse;
    private String longitude;
    private String latitude;
    private String contact;
    private Date planification;

}
