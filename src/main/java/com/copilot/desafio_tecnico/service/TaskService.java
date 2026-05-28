package com.copilot.desafio_tecnico.service;

import com.copilot.desafio_tecnico.dto.TaskDTO;
import com.copilot.desafio_tecnico.entity.Task;
import com.copilot.desafio_tecnico.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDTO> searchTasks(){
        return taskRepository.findEverything();
    }

    public Task criarTarefa(TaskDTO novaTask) {
        Task task = new Task();

        task.setCompleted(novaTask.completed());
        task.setCreatedAt(LocalDateTime.now());
        task.setDescription(novaTask.description());
        task.setTitle(novaTask.title());

        return taskRepository.save(task);
    }

    public TaskDTO listaTasksPorId(Long id) {
        return taskRepository.findTaskById(id);
    }
}
