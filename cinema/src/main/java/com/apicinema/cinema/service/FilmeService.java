package com.apicinema.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apicinema.cinema.entity.Filme;
import com.apicinema.cinema.repository.FilmeRepository;

@Service 
public class FilmeService {
    
    private final FilmeRepository filmeRepository;

    FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public List<Filme>  buscarTodos(){
        return filmeRepository.findAll();
    }

    public Filme buscaPorId(Long id){
        return filmeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }

    public List<Filme> buscarPorTitulo(String tituloFilme){
        return filmeRepository.findByTituloFilmeContainingIgnoreCase(tituloFilme);
    }

    public Filme salvar(Filme filme){
        return filmeRepository.save(filme);
    }

    public void deletarFilme(Long id){
        filmeRepository.deleteById(id);
    }
}
