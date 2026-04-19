package com.mitsu.training.controller;

import com.mitsu.training.entity.TrainingSet;
import com.mitsu.training.service.TrainingSetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// トレーニングセットAPI
@RestController
@RequestMapping("/training-sets")
public class TrainingSetController {

    private final TrainingSetService service;

    // コンストラクタインジェクション
    public TrainingSetController(TrainingSetService service) {
        this.service = service;
    }

    // 全件取得
    @GetMapping
    public List<TrainingSet> getAll() {
        return service.findAll();
    }

    // IDで取得
    @GetMapping("/{id}")
    public TrainingSet getById(@PathVariable Long id) {
        return service.findById(id);
    }

    //特定の種目に紐づくセット一覧を取得
    @GetMapping("/training-exercises/{trainingExerciseId}/sets")
    public List<TrainingSet> getByTrainingExerciseId(@PathVariable Long trainingExerciseId) {
        return service.findByTrainingExerciseId(trainingExerciseId);
    }

    // 登録
    @PostMapping
    public TrainingSet create(@RequestBody TrainingSet trainingSet) {
        return service.save(trainingSet);
    }

    // 削除
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}