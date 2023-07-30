package com.lux.Petshop.Models.Servicos;

import com.lux.Petshop.Models.Animal;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TABELA_SERVICO")
public class Hotelzinho extends Servico{
    private double horas;

    public Hotelzinho(){

    }

    public Hotelzinho(Animal a, double horas) {
        super(a);
        this.horas = horas;
        this.precoP = 12;
        this.precoM = 18;
        this.precoG = 25;
        this.precoPeloG = this.precoPeloM = this.precoPeloP = 0;
        setNome("Hotelzinho");
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public double getHoras() {
        return horas;
    }

    @Override
    public double calculaPreco(){

        return super.calculaPreco()*horas;

    }

}
