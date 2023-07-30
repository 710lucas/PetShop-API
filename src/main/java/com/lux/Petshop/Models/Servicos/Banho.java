package com.lux.Petshop.Models.Servicos;

import com.lux.Petshop.Models.Animal;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TABELA_SERVICO")
public class Banho extends Servico{

    public Banho(){

    }
    public Banho(Animal a) {
        super(a);
        this.precoP = 20;
        this.precoM = 30;
        this.precoG = 40;
        this.precoPeloP = 0;
        this.precoPeloM = 10;
        this.precoG = 20;
        setNome("Banho");
    }
}
