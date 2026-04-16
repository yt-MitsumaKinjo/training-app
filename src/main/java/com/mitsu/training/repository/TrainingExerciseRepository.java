package com.mitsu.training.repository;

import com.mitsu.training.entity.TrainingExercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//TrainigExercise用DB操作
public interface TrainingExerciseRepository extends JpaRepository<TrainingExercise, Long> {

    //TrainingExercise の training.id を条件に検索する
    List<TrainingExercise> findByTrainingId(Long trainingId);
}
