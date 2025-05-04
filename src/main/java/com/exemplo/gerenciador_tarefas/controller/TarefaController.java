package com.exemplo.gerenciador_tarefas.controller;

import com.exemplo.gerenciador_tarefas.model.Tarefa;
import com.exemplo.gerenciador_tarefas.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> listarTarefas(){
        return tarefaService.listarTarefas();
    }

    @PostMapping
    public Tarefa criarTarefa(@RequestBody @Valid Tarefa tarefa){
        return tarefaService.criarTarefa(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody @Valid Tarefa tarefa){
        return tarefaService.atualizarTarefa(id, tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
    }
}
