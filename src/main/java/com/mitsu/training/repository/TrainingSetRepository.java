package com.mitsu.training.repository;

import com.mitsu.training.entity.TrainingSet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingSetRepository extends JpaRepository<TrainingSet, Long> {
    List<TrainingSet> findByTrainingExerciseIdOrderBySetNumberAsc(Long trainingExerciseId);
}
