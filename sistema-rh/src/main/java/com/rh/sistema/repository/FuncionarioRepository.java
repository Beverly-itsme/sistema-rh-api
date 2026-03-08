package com.rh.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rh.sistema.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}