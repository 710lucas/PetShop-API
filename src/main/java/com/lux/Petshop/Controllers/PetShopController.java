package com.lux.Petshop.Controllers;

import com.lux.Petshop.DTOs.AnimalDTO;
import com.lux.Petshop.DTOs.ServicoDTO;
import com.lux.Petshop.Models.Animal;
import com.lux.Petshop.Services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PetShopController {

    private final InventarioService inventario;

    @Autowired
    public PetShopController(InventarioService inventario){
        this.inventario = inventario;
    }

    @GetMapping("/servico")
    public ResponseEntity<String> getServico(@RequestBody ServicoDTO servico){
        return ResponseEntity.ok(inventario.getServicoDescricao(servico.getCodigo()));
    }
    @GetMapping("/servicos")
    public ResponseEntity<String> getServicos(@RequestBody ServicoDTO servico){
        return ResponseEntity.ok(inventario.toString());
    }

    @PostMapping("/servico/banho")
    public int addServicoBanho(@RequestBody AnimalDTO animal){
        Animal a = new Animal(animal.getTamanho(), animal.getTamanhoPelo(), animal.getNome());
        inventario.addBanho(a);
        return HttpStatus.OK.value();
    }
    @PostMapping("/servico/tosa")
    public int addServicoTosa(@RequestBody AnimalDTO animal){
        Animal a = new Animal(animal.getTamanho(), animal.getTamanhoPelo(), animal.getNome());
        inventario.addTosa(a);
        return HttpStatus.OK.value();
    }
    @PostMapping("/servico/hotel")
    public int addServicoHotel(@RequestBody Map<String, Object> json){
        Animal a = new Animal((String) json.get("tamanho"), (String) json.get("tamanhoPelo"), (String) json.get("nome"));
        inventario.addHotel(a, (int) json.get("horas"));
        return HttpStatus.OK.value();
    }

    @PutMapping("/deletar")
    public ResponseEntity<String> deletar (@RequestBody ServicoDTO servico){
        inventario.removeServico(servico.getCodigo());
        return ResponseEntity.ok("Deletado com sucesso");
    }

}
