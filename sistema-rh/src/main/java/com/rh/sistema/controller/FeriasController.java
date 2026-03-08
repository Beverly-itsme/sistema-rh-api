package com.rh.sistema.controller;

import com.rh.sistema.model.Ferias;
import com.rh.sistema.model.Funcionario;
import com.rh.sistema.repository.FeriasRepository;
import com.rh.sistema.repository.FuncionarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ferias")
public class FeriasController {

    private final FeriasRepository feriasRepo;
    private final FuncionarioRepository funcRepo;

    public FeriasController(FeriasRepository feriasRepo, FuncionarioRepository funcRepo) {
        this.feriasRepo = feriasRepo;
        this.funcRepo = funcRepo;
    }

    // LISTAR FÉRIAS
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ferias", feriasRepo.findAll());
        return "ferias";
    }

    // FORMULÁRIO
    @GetMapping("/cadastrar")
    public String formCadastrar(Model model) {
        model.addAttribute("funcionarios", funcRepo.findAll());
        return "cadastrar_ferias";
    }

    // SALVAR FÉRIAS
    @PostMapping("/cadastrar")
    public String cadastrar(@RequestParam Long funcionarioId,
                            @RequestParam String dataInicio,
                            @RequestParam String dataFim) {

        Funcionario funcionario = funcRepo.findById(funcionarioId).orElse(null);

        Ferias ferias = new Ferias();
        ferias.setFuncionario(funcionario);
        ferias.setDataInicio(dataInicio);
        ferias.setDataFim(dataFim);
        ferias.setStatus("Pendente");

        feriasRepo.save(ferias);

        return "redirect:/ferias";
    }
}