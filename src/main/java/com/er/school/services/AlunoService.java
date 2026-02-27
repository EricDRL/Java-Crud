package com.er.school.services;

import com.er.school.models.AlunoModel;
import com.er.school.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoModel criarAluno(AlunoModel alunoModel){
        return alunoRepository.save(alunoModel);
    }

    public List<AlunoModel> buscarTodosAlunos(){
        return alunoRepository.findAll();
    }

    public void deletarAluno(Long id){
        alunoRepository.deleteById(id);
    }
}