package com.copilot.desafio_tecnico.controller;

import com.copilot.desafio_tecnico.dto.TaskDTO;
import com.copilot.desafio_tecnico.entity.Task;
import com.copilot.desafio_tecnico.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<TaskDTO> listaTasks() {
        return taskService.searchTasks();
    }

    @PostMapping("/tasks")
    public Task criarTask(@RequestBody TaskDTO novaTask) {
        return taskService.criarTarefa(novaTask);
    }

    @GetMapping("/tasks/{id}")
    public TaskDTO buscaTasksPorId(@PathVariable("id") Long id) {
        return taskService.listaTasksPorId(id);
    }
}
