package com.rh.sistema.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class FolhaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double salarioBruto;
    private double imposto;
    private double comissao;
    private double salarioLiquido;
    private String dataPagamento;

    @ManyToOne
    @JoinColumn(name="funcionario_id")
    @JsonBackReference
    private Funcionario funcionario;

    public FolhaPagamento(){}

    public FolhaPagamento(Funcionario funcionario,
                          double salarioBruto,
                          double imposto,
                          double comissao,
                          double salarioLiquido,
                          String dataPagamento){

        this.funcionario = funcionario;
        this.salarioBruto = salarioBruto;
        this.imposto = imposto;
        this.comissao = comissao;
        this.salarioLiquido = salarioLiquido;
        this.dataPagamento = dataPagamento;
    }

    public Long getId(){
        return id;
    }

    public double getSalarioBruto(){
        return salarioBruto;
    }

    public double getImposto(){
        return imposto;
    }

    public double getComissao(){
        return comissao;
    }

    public double getSalarioLiquido(){
        return salarioLiquido;
    }

    public String getDataPagamento(){
        return dataPagamento;
    }

    public Funcionario getFuncionario(){
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }

    public void setSalarioBruto(double salarioBruto){
        this.salarioBruto = salarioBruto;
    }

    public void setImposto(double imposto){
        this.imposto = imposto;
    }

    public void setComissao(double comissao){
        this.comissao = comissao;
    }

    public void setSalarioLiquido(double salarioLiquido){
        this.salarioLiquido = salarioLiquido;
    }

    public void setDataPagamento(String dataPagamento){
        this.dataPagamento = dataPagamento;
    }
}