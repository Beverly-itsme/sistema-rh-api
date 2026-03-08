package com.rh.sistema.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cargo;

    private double salario;

    // RELAÇÃO COM FOLHA DE PAGAMENTO
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<FolhaPagamento> pagamentos;

    // RELAÇÃO COM FÉRIAS
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Ferias> ferias;

    public Funcionario() {
    }

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<FolhaPagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<FolhaPagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public List<Ferias> getFerias() {
        return ferias;
    }

    public void setFerias(List<Ferias> ferias) {
        this.ferias = ferias;
    }
}