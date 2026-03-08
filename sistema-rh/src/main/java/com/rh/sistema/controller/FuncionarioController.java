package com.rh.sistema.controller;

import com.rh.sistema.model.Funcionario;
import com.rh.sistema.repository.FuncionarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioRepository repository;

    public FuncionarioController(FuncionarioRepository repository) {
        this.repository = repository;
    }

    // Listar todos os funcionários
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("funcionarios", repository.findAll());
        return "funcionarios"; // funcionarios.html
    }

    // Formulário de cadastro
    @GetMapping("/cadastrar")
    public String formCadastrar(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "cadastrar_funcionario"; // cadastrar_funcionario.html
    }

    // Cadastrar funcionário
    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute Funcionario funcionario) {
        repository.save(funcionario);
        return "redirect:/funcionarios";
    }

    // Editar funcionário
    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable Long id, Model model) {
        Funcionario funcionario = repository.findById(id).orElse(null);
        if (funcionario != null) {
            model.addAttribute("funcionario", funcionario);
            return "cadastrar_funcionario"; // Reutiliza o mesmo formulário
        }
        return "redirect:/funcionarios";
    }

    // Excluir funcionário
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/funcionarios";
    }
}