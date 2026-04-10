package com.mitsu.training.repository;

import com.mitsu.training.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

// Exercise用DB操作
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
