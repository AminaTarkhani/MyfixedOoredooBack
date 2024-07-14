package com.example.security.ooredoo.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SousTraitant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String nomSte;
    private String nom;
    private String prenom ;
    private String emailSte;
    private String msisdn;
    private String zone;
    private String regions;

    private String cin;
    private Date date;
    private String etat;
    private boolean desactive;
    private String commentaire;

}
