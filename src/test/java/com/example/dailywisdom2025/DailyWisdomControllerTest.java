package com.example.dailywisdom2025;

import com.example.dailywisdom2025.controller.DailyWisdomController;
import com.example.dailywisdom2025.domain.DailyWisdomService;
import com.example.dailywisdom2025.domain.entity.DailyWisdom;
import com.example.dailywisdom2025.infrastructure.persistence.DailyWisdomRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DailyWisdomController.class)
@ExtendWith(MockitoExtension.class)
class DailyWisdomControllerTest {

    @MockitoBean
    DailyWisdomService dailyWisdomService;

    @MockitoBean
    DailyWisdomRepository dailyWisdomRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("getAllDailyWisdom")
    void getAllDailyWisdom() throws Exception {
        var dailyWisdom = new DailyWisdom();
        dailyWisdom.setId(1);
        dailyWisdom.setMessage("test");
        when(dailyWisdomService.getAllDailyWisdom()).thenReturn(List.of(dailyWisdom));

        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    @DisplayName("getLatestDailyWisdom")
    void getLatestDailyWisdom() throws Exception {
        var dailyWisdom = new DailyWisdom();
        dailyWisdom.setId(1);
        dailyWisdom.setMessage("test");

        when(dailyWisdomService.getLatestDailyWisdom()).thenReturn(dailyWisdom);

        mockMvc.perform(get("/dailywisdomrespons"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));

    }

}