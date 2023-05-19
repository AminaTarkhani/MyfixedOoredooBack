package com.example.security.ooredoo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prospections")
public class Prospection {
    private static final long serialVersionUID = 6085852202727021613L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="full_name")
    private String fullName;

    @Column(name="contract_number")
    private Long contractNum;

    @Column(name="id_number")
    private Long numID;

    //@JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="creation_date")
    private LocalDateTime dateCreation;

    //@JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="modification_date")
    private LocalDateTime dateDernièreModification;

    @Column(name="offre_type")
    private String offreType;

    @Column(name="residence_name")
    private String residenceName;

    @Column(name="latitude")
    private Double latitude;

    @Column(name="longitude")
    private Double longitude;

    @Column(name="zone")
    private String zone;

    @Column(name="access", nullable = true)
    private String access;

    @Column(name="bloc", nullable = true)
    private int bloc;

    @Column(name="etage", nullable = true)
    private int etage;

    @Column(name="appartement", nullable = true)
    private int appartement;

    @Column(name="raison", nullable = true)
    private String raison;

    @Column(name="etat")
    private String etat;

}

