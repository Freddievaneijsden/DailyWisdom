package com.example.dailywisdom2025.controller;

import com.example.dailywisdom2025.domain.entity.DailyWisdom;
import com.example.dailywisdom2025.domain.DailyWisdomService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class DailyWisdomResolver {

    private final DailyWisdomService dailyWisdomService;

    public DailyWisdomResolver(DailyWisdomService dailyWisdomService) {
        this.dailyWisdomService = dailyWisdomService;
    }

    @QueryMapping
    public DailyWisdom getLatestDailyWisdom() {
        return dailyWisdomService.getLatestDailyWisdom();
    }

    @QueryMapping
    public List<DailyWisdom> getAllDailyWisdom() {
        return dailyWisdomService.getAllDailyWisdom();
    }

    @MutationMapping
    public void addDailyWisdom(@Argument String message) {
        dailyWisdomService.addNewDailyWisdom(message);
    }
}
