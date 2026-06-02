package com.copilot.desafio_tecnico.service;

import com.copilot.desafio_tecnico.dto.TaskDTOTest;
import com.copilot.desafio_tecnico.entity.Task;
import com.copilot.desafio_tecnico.handlers.TaskNotFoundException;
import com.copilot.desafio_tecnico.repository.TaskRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceTest {
    @Autowired
    private TaskRepositoryTest taskRepository;

    public List<TaskDTOTest> searchTasks(){
        return taskRepository.findEverything();
    }

    public TaskDTOTest searchTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task não encontrada"));
        return new TaskDTOTest(task.getTitle(), task.getDescription(), task.getCompleted(), task.getCreatedAt());
    }

    public Task criarTarefa(TaskDTOTest novaTask) {
        Task task = new Task();

        task.setCompleted(false);
        task.setCreatedAt(LocalDateTime.now());
        task.setDescription(novaTask.description());
        task.setTitle(novaTask.title());

        if (task.getTitle() == null || task.getTitle().isBlank()) {
            throw new RuntimeException("Título não pode vir vazio");
        }

        return taskRepository.save(task);
    }

    public Task atualizaTask(Long id, TaskDTOTest dto) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task não encontrada"));

        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setCompleted(dto.completed());

        return taskRepository.save(task);
    }

    public void deletaTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task não encontrada"));
        taskRepository.delete(task);
    }
}
