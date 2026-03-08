package com.rh.sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rh.sistema.model.Funcionario;
import com.rh.sistema.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario salvar(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarTodos(){
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorId(Long id){
        return funcionarioRepository.findById(id).orElse(null);
    }

    public void deletar(Long id){
        funcionarioRepository.deleteById(id);
    }

}