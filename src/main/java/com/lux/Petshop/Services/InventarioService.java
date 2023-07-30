package com.lux.Petshop.Services;

import com.lux.Petshop.Models.Animal;
import com.lux.Petshop.Models.Inventario;
import com.lux.Petshop.Models.Servicos.Banho;
import com.lux.Petshop.Models.Servicos.Hotelzinho;
import com.lux.Petshop.Models.Servicos.Servico;
import com.lux.Petshop.Models.Servicos.Tosa;
import com.lux.Petshop.Repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioService {

    Inventario inventario = new Inventario();

    private final ServicoRepository servicos;

    @Autowired
    public InventarioService(ServicoRepository s){
        this.servicos = s;
        inventario.setServicos(s.findAll());
    }


    public void addBanho(Animal a){
        Servico servico = new Banho(a);
        inventario.addServico(servico);

        servicos.save(servico);
    }

    public void addHotel(Animal a, int horas){
        Servico servico = new Hotelzinho(a, horas);
        inventario.addServico(servico);

        servicos.save(servico);
    }

    public void addTosa(Animal a){
        Servico servico = new Tosa(a);
        inventario.addServico(servico);

        servicos.save(servico);
    }

    public String listarServicos(){
        return inventario.toString();
    }

    public double calculaServicoCodigo(int codigo){
        return servicos.findById(codigo).get().calculaPreco();
    }

    public void removeServico(int codigo){
        Servico s = servicos.findById(codigo).get();
        servicos.delete(s);
        inventario.removeServico(s);
    }

    public String getServicoDescricao(int codigo){
        return servicos.findById(codigo).get().toString();
    }

    public String toString(){
        return inventario.toString();
    }



}
