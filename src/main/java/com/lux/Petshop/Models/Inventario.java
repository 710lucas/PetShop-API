package com.lux.Petshop.Models;

import com.lux.Petshop.Models.Servicos.Servico;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Inventario implements Serializable {

    private List<Servico> servicos = new LinkedList<>();

    public void setServicos(List<Servico> s){
        this.servicos = s;
    }

    public void addServico(Servico s){
        servicos.add(s);
    }

    public void removeServico(Servico s){
        servicos.remove(s);
    }

    public double calculaServicoPosicao(int posicao){
        return servicos.get(posicao).calculaPreco();
    }

    public double calculaServicoCodigo(int codigo){
        for(Servico s : servicos)
            if(s.getCodigo() == codigo)
                return s.calculaPreco();
        throw new IllegalArgumentException("Codigo "+codigo+" informado é invalido");
    }

    public double calculaTotalServicos(){
        double total = 0;
        for(Servico s : servicos)
            total+=s.calculaPreco();
        return total;
    }

    public String toString(){
        String out = "";
        for(Servico s : servicos)
            out+=s.toString()+"\n";
        return out;
    }

}
