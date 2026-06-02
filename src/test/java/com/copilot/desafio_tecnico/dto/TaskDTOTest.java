package com.copilot.desafio_tecnico.dto;

import java.time.LocalDateTime;

public record TaskDTOTest(
        String title,
        String description,
        Boolean completed,
        LocalDateTime createdAt
) {
    @Override
    public String title() {
        return title;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public Boolean completed() {
        return completed;
    }

    @Override
    public LocalDateTime createdAt() {
        return createdAt;
    }
}
