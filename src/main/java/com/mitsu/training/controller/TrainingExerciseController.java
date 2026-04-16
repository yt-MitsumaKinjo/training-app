package com.mitsu.training.controller;

import com.mitsu.training.entity.TrainingExercise;
import com.mitsu.training.service.TrainingExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// トレーニング種目API
@RestController
@RequestMapping("/training-exercises")
public class TrainingExerciseController {

    private final TrainingExerciseService service;

    // コンストラクタインジェクション
    public TrainingExerciseController(TrainingExerciseService service) {
        this.service = service;
    }

    // 全件取得
    @GetMapping
    public List<TrainingExercise> getAll() {
        return service.findAll();
    }

    // IDで取得
    @GetMapping("/{id}")
    public TrainingExercise getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // 特定のTrainingに紐づく一覧取得
    @GetMapping("/trainings/{trainingId}/exercises")
    public List<TrainingExercise> getByTrainingId(@PathVariable Long trainingId) {
        return service.findByTrainingId(trainingId);
    }

    // 登録
    @PostMapping
    public TrainingExercise create(@RequestBody TrainingExercise trainingExercise) {
        return service.save(trainingExercise);
    }

    // 削除
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}