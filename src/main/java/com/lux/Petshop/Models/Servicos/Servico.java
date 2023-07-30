package com.lux.Petshop.Models.Servicos;

import com.lux.Petshop.Models.Animal;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TABELA_SERVICO")
public abstract class Servico implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private Animal animal;
    private Date data;
    private String nome;
    protected double precoP, precoM, precoG;
    protected double precoPeloP, precoPeloM, precoPeloG;

    public Servico(Animal a){
        this.animal = a;
        data = new Date();
    }

    public double calculaPreco(){
        double preco = 0;
        switch (getAnimal().getTamanho()){
            case "p":
                preco = precoP;
                break;
            case "m":
                preco = precoM;
                break;
            case "g":
                preco = precoG;
                break;
            default:
                break;
        }

        switch (getAnimal().getTamanhoPelo()){
            case "curto":
                preco+=precoPeloP;
                break;
            case "medio", "médio":
                preco += precoPeloM;
                break;
            case "longo":
                preco += precoPeloG;
                break;
            default:
                break;
        }

        return preco;

    }

    public int getCodigo(){
        return codigo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Date getData(){
        return data;
    }

    public String getNome() {
        return nome;
    }

    public void setAnimal(Animal a){
        this.animal = a;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
