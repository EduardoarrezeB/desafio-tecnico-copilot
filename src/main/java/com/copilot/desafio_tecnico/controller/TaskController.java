package com.copilot.desafio_tecnico.controller;

import com.copilot.desafio_tecnico.dto.TaskDTO;
import com.copilot.desafio_tecnico.entity.Task;
import com.copilot.desafio_tecnico.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<TaskDTO> listaTasks() {
        return taskService.searchTasks();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskDTO> listaTaskPorId(@PathVariable Long id) {
        TaskDTO dto = taskService.searchTaskById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/tasks")
    public Task criarTask(@RequestBody TaskDTO novaTask) {
        return taskService.criarTarefa(novaTask);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> atualizaTask(@PathVariable Long id, @RequestBody TaskDTO dto) {
        Task updatedTask = taskService.atualizaTask(id, dto);

        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deletaTask(@PathVariable Long id) {
        taskService.deletaTask(id);

        return ResponseEntity.noContent().build();
    }
}
