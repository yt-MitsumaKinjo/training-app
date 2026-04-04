package com.mitsu.training.service;

import com.mitsu.training.entity.Training;
import com.mitsu.training.repository.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// ビジネスロジックを扱うクラス
@Service
public class TrainingService {

    // DB操作用Repository
    private final TrainingRepository repository;

    // コンストラクタでDI（依存性注入）
    public TrainingService(TrainingRepository repository) {
        this.repository = repository;
    }

    // 全件取得
    public List<Training> findAll() {
        return repository.findAll();
    }

    // 1件保存
    public Training save(Training training) {
        return repository.save(training);
    }
}