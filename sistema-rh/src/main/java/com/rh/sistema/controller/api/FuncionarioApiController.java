package com.rh.sistema.controller.api;

import com.rh.sistema.model.Funcionario;
import com.rh.sistema.repository.FuncionarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioApiController {

    private final FuncionarioRepository repo;

    public FuncionarioApiController(FuncionarioRepository repo){
        this.repo = repo;
    }

    // LISTAR FUNCIONÁRIOS
    @GetMapping
    public List<Funcionario> listar(){
        return repo.findAll();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Funcionario buscar(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }

    // CRIAR FUNCIONÁRIO
    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario){
        return repo.save(funcionario);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long id, @RequestBody Funcionario dados){

        Funcionario f = repo.findById(id).orElse(null);

        if(f != null){
            f.setNome(dados.getNome());
            f.setCargo(dados.getCargo());
            f.setSalario(dados.getSalario());
            repo.save(f);
        }

        return f;
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        repo.deleteById(id);
    }

}