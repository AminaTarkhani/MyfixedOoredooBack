package com.example.security.ooredoo.entities;

import com.example.security.ooredoo.controller.CustomBooleanDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FastBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String categorie ;
    private String numeroserie;
    private String debit;
    private String abonnement;
    private String prix;
    private String msisdn;
    private String numeroTT;

    @Column(name = "contrat_image", columnDefinition = "LONGBLOB")
    private byte[] contratImage;

    @Column(name = "preuve_image", columnDefinition = "LONGBLOB")
    private byte[] preuveImage;

    @Column(name = "demande_image", columnDefinition = "LONGBLOB")
    private byte[] demandeImage;



    @JsonProperty("clientPossedeNumero")
    @JsonDeserialize(using = CustomBooleanDeserializer.class)
    private boolean clientPossedeNumero;



    @Column(name = "signature_image", columnDefinition = "BLOB")
    private byte[] signatureImage;

}
