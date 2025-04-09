package com.example.dailywisdom2025.domain;

import com.example.dailywisdom2025.domain.entity.DailyWisdom;
import com.example.dailywisdom2025.infrastructure.persistence.DailyWisdomRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DailyWisdomServiceTest {

    @Mock
    DailyWisdomRepository dailyWisdomRepository;
    @InjectMocks
    DailyWisdomService dailyWisdomService;


    @Test
    @DisplayName("getLatestDailyWisdom")
    void getLatestDailyWisdom() {
        DailyWisdom dailyWisdom = new DailyWisdom();
        when(dailyWisdomRepository.findTopByOrderByIdDesc()).thenReturn(Optional.of(dailyWisdom));
        assertThat(dailyWisdomService.getLatestDailyWisdom()).isExactlyInstanceOf(DailyWisdom.class);
    }
}
