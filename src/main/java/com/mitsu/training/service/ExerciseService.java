package com.mitsu.training.service;

import com.mitsu.training.entity.BodyPart;
import com.mitsu.training.entity.Exercise;
import com.mitsu.training.repository.BodyPartRepository;
import com.mitsu.training.repository.ExerciseRepository;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Service;

import java.util.List;

// 種目ロジック
@Service
public class ExerciseService {

    private final ExerciseRepository repository;
    private final BodyPartRepository bodyPartRepository;

    // コンストラクタインジェクション
    public ExerciseService(ExerciseRepository repository, BodyPartRepository bodyPartRepository) {
        this.repository = repository;
        this.bodyPartRepository = bodyPartRepository;
    }

    // 全件取得
    public List<Exercise> findAll() {
        return repository.findAll();
    }

    // IDで取得（存在しない場合はnullになる）
    public Exercise findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // 保存（BodyPartの紐付けを考慮）
    public Exercise save(Exercise exercise) {

        // bodyPartがリクエストに含まれている場合
        if (exercise.getBodyPart() != null) {

            // リクエストからbodyPartのIDを取得
            Long bodyPartId = exercise.getBodyPart().getId();

            // DBから正しいBodyPartを取得
            BodyPart bodyPart = bodyPartRepository.findById(bodyPartId)
                    .orElse(null);

            // Exerciseにセット（紐付け）
            exercise.setBodyPart(bodyPart);
        }

        // DBに保存
        return repository.save(exercise);
    }
}