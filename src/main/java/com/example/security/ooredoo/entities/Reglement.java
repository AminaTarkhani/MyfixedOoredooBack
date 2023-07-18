package com.example.security.ooredoo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Reglement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String paiement;
    private Double montant;
    private String rib;
    private String numeroCheque;
    private String codeBanque;
    private String codeAgence;
    private Date dateEcheance;
    private String typeIdentite;
    private String numeroIdentite;
    private String code;

   private String numerocarte;
    private String expirationMonth;
    private String expirationYear;
    private String nomdetenteur;
    private String ccv;
    private String email;
}