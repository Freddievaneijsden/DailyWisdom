package com.example.dailywisdom2025;

import com.example.dailywisdom2025.domain.entity.DailyWisdom;
import com.example.dailywisdom2025.infrastructure.persistence.DailyWisdomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DailyWisdom2025Application {

    public static void main(String[] args) {
        SpringApplication.run(DailyWisdom2025Application.class, args);
    }
}
