package com.copilot.desafio_tecnico.repository;

import com.copilot.desafio_tecnico.dto.TaskDTOTest;
import com.copilot.desafio_tecnico.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepositoryTest extends JpaRepository<Task, Long> {
    @Query("select t from Task t")
    List<TaskDTOTest> findEverything();

    @Query("select t from Task t where id = :id")
    TaskDTOTest findTaskById(Long id);
}
