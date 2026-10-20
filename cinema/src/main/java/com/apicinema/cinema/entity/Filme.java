package com.apicinema.cinema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity 
@Table(name = "filmw")
public class Filme {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFilme;

    @NotBlank 
    @Column(length = 40)
    private String tituloFilme;

    
}
