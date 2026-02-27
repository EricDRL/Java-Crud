package com.er.school.controllers;

import com.er.school.models.AlunoModel;
import com.er.school.repositories.AlunoRepository;
import com.er.school.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public AlunoModel criarAluno(@RequestBody AlunoModel alunoModel){
        return alunoService.criarAluno(alunoModel);
    }

    @GetMapping
    public List<AlunoModel> buscarTodosAlunos(){
        return alunoService.buscarTodosAlunos();
    }

    @GetMapping("/{id}")
    public AlunoModel buscarAlunoPorId(@PathVariable Long id){
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    /* ATUALIZAR BUSCA ALUNO POR ID
    @PutMapping("/{id}")
    public AlunoModel atualizarAluno(@PathVariable Long id, @RequestBody AlunoModel alunoDetails){
        AlunoModel alunoModel = alunoRepository.findById(id);

        return alunoRepository.save(alunoModel);

    } */

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id){
        alunoService.deletarAluno(id);
    }
}
