package com.apicinema.cinema.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apicinema.cinema.entity.Filme;
import com.apicinema.cinema.service.FilmeService;

@RestController 
@RequestMapping("/api/filmes")
public class FilmeController {
    
    private final FilmeService filmeService;

    FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping 
    public Filme salvar(@RequestParam Filme filme){
        return filmeService.salvar(filme);
    }

    @GetMapping 
    public List<Filme> buscarTodos(){
        return filmeService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Long id){
        Filme filme = filmeService.buscaPorId(id);
        return ResponseEntity.ok(filme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(
            @PathVariable Long id,
            @RequestBody Filme filme){
        filme.setIdFilme(id);
        return ResponseEntity.ok(filmeService.salvar(filme));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        filmeService.deletarFilme(id);
        return ResponseEntity.noContent().build();
    }
}
