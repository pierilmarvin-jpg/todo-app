package com.example.todo.config;

import com.example.todo.repository.TodoRepository;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoMetricsConfig {

    public TodoMetricsConfig(MeterRegistry meterRegistry, TodoRepository repo) {
        Gauge.builder("todo_total", repo, TodoRepository::count)
                .description("Nombre total de tâches TODO")
                .register(meterRegistry);
    }
}
