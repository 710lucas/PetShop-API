package com.lux.Petshop.Models.Servicos;

import com.lux.Petshop.Models.Animal;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TABELA_SERVICO")
public class Tosa extends Servico{

    public Tosa(){

    }

    public Tosa(Animal a) {
        super(a);
        this.precoP = 22;
        this.precoM = 30;
        this.precoG = 40;
        this.precoPeloG = this.precoPeloM = this.precoPeloP = 0;
        setNome("Tosa");
    }

}
