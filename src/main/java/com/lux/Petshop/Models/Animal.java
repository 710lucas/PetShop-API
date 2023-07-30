package com.lux.Petshop.Models;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "TABLE_ANIMAL")
public class Animal implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private String tamanho;
    private String tamanhoPelo;
    private String nome;

    public Animal(String tamanho, String tamanhoPelo, String nome){
        tamanho = tamanho.toLowerCase();
        tamanhoPelo = tamanhoPelo.toLowerCase();
        if(!tamanho.equals("p") && !tamanho.equals("m") && !tamanho.equals("g"))
            throw new IllegalArgumentException("Tamanho do animal é inválido: "+tamanho);
        if(!tamanhoPelo.equals("curto") && !tamanhoPelo.equals("medio") && !tamanhoPelo.equals("médio") && !tamanhoPelo.equals("longo"))
            throw new IllegalArgumentException("Tamanho do pelo do animal é inválido: "+tamanhoPelo);
        this.tamanho = tamanho;
        this.tamanhoPelo = tamanhoPelo;
        this.nome = nome;
    }

    public String getTamanho(){
        return tamanho;
    }

    public String getNome() {
        return nome;
    }

    public String getTamanhoPelo() {
        return tamanhoPelo;
    }

    public void tosar(){
        tamanhoPelo = "curto";
    }

    @Override
    public String toString(){
        return "Animal: "+nome+"\ntamanho:" + tamanho+"\nTamanho do pelo: "+tamanhoPelo+"\n\n";
    }
}
