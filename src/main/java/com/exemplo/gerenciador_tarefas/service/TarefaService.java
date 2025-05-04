package com.exemplo.gerenciador_tarefas.service;

import java.time.LocalDateTime;
import java.util.List;
import com.exemplo.gerenciador_tarefas.model.Tarefa;
import com.exemplo.gerenciador_tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class TarefaService {

    @Autowired TarefaRepository tarefaRepository;

    public List<Tarefa> listarTarefas(){
       return tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarTarefaPorId(Long id){
        return tarefaRepository.findById(id);
    }

    public Tarefa criarTarefa(Tarefa tarefa){
        tarefa.setDataCriacao(LocalDateTime.now());
       return  tarefaRepository.save(tarefa);
    }

    public Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada){
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setTitulo(tarefaAtualizada.getTitulo());
                    tarefa.setDescricao(tarefaAtualizada.getDescricao());
                    tarefa.setStatus(tarefaAtualizada.getStatus());
                    return tarefaRepository.save(tarefa);
                }
        )
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public void deletarTarefa(Long id){
        tarefaRepository.deleteById(id);
    }

}
