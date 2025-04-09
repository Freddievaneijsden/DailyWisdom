package com.example.dailywisdom2025.infrastructure.persistence;

import com.example.dailywisdom2025.domain.entity.DailyWisdom;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface DailyWisdomRepository extends ListCrudRepository<DailyWisdom, Integer> {

    Optional<DailyWisdom> findTopByOrderByIdDesc();

}
