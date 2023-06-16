package com.example.security.ooredoo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FixeJdid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String abonnement;
    private String debit;
    private String imei;
    private String kitcode;
    private String msisdn;
    @Column(name = "formulaire", columnDefinition = "LONGBLOB")
    private byte[] formulaire;
    @Column(name = "conditions", columnDefinition = "LONGBLOB")
    private byte[] conditions;
    @Column(name = "preuves", columnDefinition = "LONGBLOB")
    private byte[] preuves;
    @Column(name = "contrats", columnDefinition = "LONGBLOB")
    private byte[] contrats;
    @Column(name = "signature_image", columnDefinition = "BLOB")
    private byte[] signatureImage;
}
