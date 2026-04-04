package com.mitsu.training.controller;

import com.mitsu.training.entity.Training;
import com.mitsu.training.service.TrainingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// APIの入口（外部からのリクエストを受け取る）
@RestController
@RequestMapping("/trainings")
public class TrainingController {

    // Serviceクラス
    private final TrainingService service;

    // コンストラクタでDI（依存性注入）
    public TrainingController(TrainingService service) {
        this.service = service;
    }

    // 全件取得API
    // GET http://localhost:8080/trainings
    @GetMapping
    public List<Training> getAll() {
        return service.findAll();
    }

    // 新規作成API
    // POST http://localhost:8080/trainings
    @PostMapping
    public Training create(@RequestBody Training training) {
        return service.save(training);
    }
}