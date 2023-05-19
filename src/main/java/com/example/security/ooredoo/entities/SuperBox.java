package com.example.security.ooredoo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SuperBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String choix ;
    private String iccid;
    private String numeroserie;
    private String zonerecherche;
    private String msisdn;

    @Column(name = "signature_image", columnDefinition = "BLOB")
    private byte[] signatureImage;
}
