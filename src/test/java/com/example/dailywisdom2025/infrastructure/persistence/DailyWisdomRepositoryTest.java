package com.example.dailywisdom2025.infrastructure.persistence;

import com.example.dailywisdom2025.domain.entity.DailyWisdom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Testcontainers
class DailyWisdomRepositoryTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("testdb")
    .withUsername("test")
    .withPassword("test");

    @Autowired
    DailyWisdomRepository dailyWisdomRepository;

    @BeforeEach
    void beforeEach() {
        System.out.println("PostgreSQL Container URL: " + postgreSQLContainer.getJdbcUrl());
        var dailyWisdom = new DailyWisdom();
        dailyWisdom.setMessage("Try harder");
        dailyWisdomRepository.save(dailyWisdom);
    }

    @Test
    @DisplayName("getLatestDailyWisdomReturnsDailyWisdomWithHighestId")
    void getLatestDailyWisdomReturnsDailyWisdomWithHighestId() {
        var dailyWisdom = new DailyWisdom();
        dailyWisdom.setMessage("Test");
        dailyWisdomRepository.save(dailyWisdom);

        var result = dailyWisdomRepository.findTopByOrderByIdDesc().orElse(null);
        assertThat(result)
                .isNotNull()
                .extracting(DailyWisdom::getMessage)
                .isEqualTo("Test");
    }

}