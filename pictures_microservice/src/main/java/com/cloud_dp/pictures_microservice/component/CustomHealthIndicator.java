package com.cloud_dp.pictures_microservice.component;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    private boolean isHealthy = true;

    @Override
    public Health health() {
        if (isHealthy) {
            return Health.up().build();
        } else {
            return Health.down().withDetail("Error", "Simulated health check failure").build();
        }
    }


    @Scheduled(fixedRate = 40000) // 40000 milliseconds = 40 seconds
    public void toggleHealthStatus() {
        isHealthy = !isHealthy;
        System.out.println("Toggled health status to: " + (isHealthy ? "UP" : "DOWN"));
    }
}