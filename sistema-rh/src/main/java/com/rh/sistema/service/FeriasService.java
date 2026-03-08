package com.rh.sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rh.sistema.model.Ferias;
import com.rh.sistema.repository.FeriasRepository;

@Service
public class FeriasService {

    @Autowired
    private FeriasRepository feriasRepository;

    public Ferias registrarFerias(Ferias ferias){
        return feriasRepository.save(ferias);
    }

    public List<Ferias> listarFerias(){
        return feriasRepository.findAll();
    }

}