package com.example.security.ooredoo.entities;

import io.micrometer.core.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlashBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String civilite;
    private String gouvernorat;
    private String localite;
    private Long codepostal;
    private String adresseInstallation;
    private String   adresseFacturation;
    private String delegation;
    private String   rdv;
    private String email;
    private Long   contact;
   private Double latitude;
    private Double longitude;
    private String offres;
    private String msisdn;
    private String debit;
    private String city;
    private String  isChecked;


    private String gouvernoratInstallation;
    private String localiteInstallation;
    private Long codepostalInstallation;
    private String delegationInstallation;


}

