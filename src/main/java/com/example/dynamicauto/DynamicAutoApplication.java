package com.example.dynamicauto;

import com.example.dynamicauto.service.AutomationService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DynamicAutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicAutoApplication.class, args);
    }

    @Bean
    public List<ToolCallback> toolCallbacks(AutomationService automationService) {
        return List.of(ToolCallbacks.from(automationService));
    }
}
