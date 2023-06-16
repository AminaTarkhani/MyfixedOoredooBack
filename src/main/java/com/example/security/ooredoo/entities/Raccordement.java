package com.example.security.ooredoo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Raccordement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String offres ;

    private String debit ;
    @Column(name = "mondatTT", columnDefinition = "LONGBLOB")
    private byte[] mondatTT;
}
