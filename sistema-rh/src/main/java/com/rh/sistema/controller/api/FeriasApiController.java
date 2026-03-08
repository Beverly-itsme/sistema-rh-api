package com.rh.sistema.controller.api;

import com.rh.sistema.model.Ferias;
import com.rh.sistema.repository.FeriasRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ferias")
public class FeriasApiController {

    private final FeriasRepository repo;

    public FeriasApiController(FeriasRepository repo){
        this.repo = repo;
    }

    // LISTAR FÉRIAS
    @GetMapping
    public List<Ferias> listar(){
        return repo.findAll();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Ferias buscar(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }

    // CRIAR SOLICITAÇÃO DE FÉRIAS
    @PostMapping
    public Ferias criar(@RequestBody Ferias ferias){
        return repo.save(ferias);
    }

    // ATUALIZAR FÉRIAS
    @PutMapping("/{id}")
    public Ferias atualizar(@PathVariable Long id, @RequestBody Ferias dados){

        Ferias f = repo.findById(id).orElse(null);

        if(f != null){
            f.setFuncionario(dados.getFuncionario());
            f.setDataInicio(dados.getDataInicio());
            f.setDataFim(dados.getDataFim());
            repo.save(f);
        }

        return f;
    }

    // EXCLUIR FÉRIAS
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        repo.deleteById(id);
    }

}
