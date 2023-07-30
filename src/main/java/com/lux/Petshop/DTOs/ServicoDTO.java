package com.lux.Petshop.DTOs;

import com.lux.Petshop.Models.Animal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicoDTO {

    private Animal animal;
    private int codigo;
    private Date data;
    private String nome;
    protected double precoP, precoM, precoG;
    protected double precoPeloP, precoPeloM, precoPeloG;
}
