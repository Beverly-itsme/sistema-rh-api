package com.rh.sistema.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Ferias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataInicio;
    private String dataFim;
    private String status;

    @ManyToOne
    @JoinColumn(name="funcionario_id")
    @JsonBackReference
    private Funcionario funcionario;

    public Ferias(){}

    public Ferias(Funcionario funcionario, String dataInicio, String dataFim, String status){
        this.funcionario = funcionario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
    }

    public Long getId(){ 
        return id; 
    }

    public String getDataInicio(){ 
        return dataInicio; 
    }

    public String getDataFim(){ 
        return dataFim; 
    }

    public String getStatus(){ 
        return status; 
    }

    public Funcionario getFuncionario(){ 
        return funcionario; 
    }

    public void setStatus(String status){ 
        this.status = status; 
    }

    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }

    public void setDataInicio(String dataInicio){
        this.dataInicio = dataInicio;
    }

    public void setDataFim(String dataFim){
        this.dataFim = dataFim;
    }
}