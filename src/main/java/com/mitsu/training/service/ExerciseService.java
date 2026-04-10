package com.mitsu.training.service;

import com.mitsu.training.entity.Exercise;
import com.mitsu.training.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// 種目ロジック
@Service
public class ExerciseService {

    private final ExerciseRepository repository;

    public ExerciseService(ExerciseRepository repository) {
        this.repository = repository;
    }

    // 全件取得
    public List<Exercise> findAll() {
        return repository.findAll();
    }

    // 保存
    public Exercise save(Exercise exercise) {
        return repository.save(exercise);
    }
}