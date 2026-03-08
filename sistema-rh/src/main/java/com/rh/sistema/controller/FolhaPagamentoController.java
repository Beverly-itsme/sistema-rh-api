package com.rh.sistema.controller;

import com.rh.sistema.model.FolhaPagamento;
import com.rh.sistema.model.Funcionario;
import com.rh.sistema.repository.FolhaPagamentoRepository;
import com.rh.sistema.repository.FuncionarioRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/folhapagamento")
public class FolhaPagamentoController {

    private final FolhaPagamentoRepository folhaRepo;
    private final FuncionarioRepository funcRepo;

    public FolhaPagamentoController(FolhaPagamentoRepository folhaRepo,
                                    FuncionarioRepository funcRepo) {
        this.folhaRepo = folhaRepo;
        this.funcRepo = funcRepo;
    }

    // LISTAR PAGAMENTOS
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pagamentos", folhaRepo.findAll());
        return "folha_pagamento";
    }

    // FORMULÁRIO
    @GetMapping("/cadastrar")
    public String formCadastrar(Model model) {
        model.addAttribute("funcionarios", funcRepo.findAll());
        return "cadastrar_folha";
    }

    // REGISTRAR PAGAMENTO
    @PostMapping("/cadastrar")
    public String cadastrar(@RequestParam Long funcionarioId,
                            @RequestParam double salarioBruto,
                            @RequestParam double comissao,
                            @RequestParam String dataPagamento) {

        Funcionario funcionario = funcRepo.findById(funcionarioId).orElse(null);

        // cálculo do imposto
        double imposto = salarioBruto * 0.10;

        // salário líquido
        double salarioLiquido = salarioBruto + comissao - imposto;

        FolhaPagamento folha = new FolhaPagamento(
                funcionario,
                salarioBruto,
                imposto,
                comissao,
                salarioLiquido,
                dataPagamento
        );

        folhaRepo.save(folha);

        return "redirect:/folhapagamento";
    }
}