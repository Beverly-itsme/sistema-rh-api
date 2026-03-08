package com.rh.sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rh.sistema.model.FolhaPagamento;
import com.rh.sistema.repository.FolhaPagamentoRepository;

@Service
public class FolhaPagamentoService {

    @Autowired
    private FolhaPagamentoRepository folhaPagamentoRepository;

    // Registrar pagamento
    public FolhaPagamento registrarPagamento(FolhaPagamento pagamento){
        return folhaPagamentoRepository.save(pagamento);
    }

    // Listar pagamentos
    public List<FolhaPagamento> listarPagamentos(){
        return folhaPagamentoRepository.findAll();
    }

    // Calcular imposto (10%)
    public double calcularImposto(double salarioBruto){
        return salarioBruto * 0.10;
    }

    // Calcular comissão (5%)
    public double calcularComissao(double salarioBruto){
        return salarioBruto * 0.05;
    }

    // Calcular salário líquido
    public double calcularSalarioLiquido(double salarioBruto){

        double imposto = calcularImposto(salarioBruto);
        double comissao = calcularComissao(salarioBruto);

        return salarioBruto + comissao - imposto;
    }

}