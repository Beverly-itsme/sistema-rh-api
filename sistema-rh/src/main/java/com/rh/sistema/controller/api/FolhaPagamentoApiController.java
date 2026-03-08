package com.rh.sistema.controller.api;

import com.rh.sistema.model.FolhaPagamento;
import com.rh.sistema.repository.FolhaPagamentoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/folha-pagamento")
public class FolhaPagamentoApiController {

    private final FolhaPagamentoRepository repo;

    public FolhaPagamentoApiController(FolhaPagamentoRepository repo){
        this.repo = repo;
    }

    // LISTAR PAGAMENTOS
    @GetMapping
    public List<FolhaPagamento> listar(){
        return repo.findAll();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public FolhaPagamento buscar(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }

    // REGISTRAR PAGAMENTO
    @PostMapping
    public FolhaPagamento criar(@RequestBody FolhaPagamento pagamento){
        return repo.save(pagamento);
    }

    // ATUALIZAR PAGAMENTO
    @PutMapping("/{id}")
    public FolhaPagamento atualizar(@PathVariable Long id, @RequestBody FolhaPagamento dados){

        FolhaPagamento p = repo.findById(id).orElse(null);

        if(p != null){
            p.setFuncionario(dados.getFuncionario());
            p.setSalarioBruto(dados.getSalarioBruto());
            p.setComissao(dados.getComissao());
            p.setSalarioLiquido(dados.getSalarioLiquido());
            repo.save(p);
        }

        return p;
    }

    // EXCLUIR PAGAMENTO
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        repo.deleteById(id);
    }

}