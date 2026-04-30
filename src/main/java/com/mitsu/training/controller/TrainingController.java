package com.mitsu.training.controller;

import com.mitsu.training.entity.Training;
import com.mitsu.training.service.TrainingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// トレーニングAPI
@RestController
@RequestMapping("/trainings")
public class TrainingController {

    private final TrainingService service;

    // コンストラクタインジェクション
    public TrainingController(TrainingService service) {
        this.service = service;
    }

    // 一覧取得
    @GetMapping
    public List<Training> getAll(@RequestParam(required = false) String date) {

        // dateが指定されている場合（例：?date=2026-04-11）
        if (date != null && !date.isEmpty()) {
            // 日付で絞り込んで取得
            return service.findByDate(date);
        }

        // dateがない場合は全件取得
        return service.findAll();
    }

    // IDで取得
    @GetMapping("/{id}")
    public Training getById(@PathVariable Long id) {
        return service.findByIdWithRelations(id);
    }

    // 登録
    @PostMapping
    public Training create(@RequestBody Training training) {
        Training saved = service.save(training);
        return service.findByIdWithRelations(saved.getId());
    }

    // 一括登録（追加）
    @PostMapping("/bulk")
    public Training createBulk(@RequestBody Training training) {
        return service.saveWithRelations(training);
    }

    // 削除
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}