package com.mitsu.training.service;

import com.mitsu.training.entity.TrainingExercise;
import com.mitsu.training.entity.TrainingSet;
import com.mitsu.training.repository.TrainingExerciseRepository;
import com.mitsu.training.repository.TrainingSetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingSetService {

    // TrainingSet用Repository
    private final TrainingSetRepository repository;

    // 親エンティティ取得用
    private final TrainingExerciseRepository trainingExerciseRepository;

    // コンストラクタインジェクション
    public TrainingSetService(TrainingSetRepository repository,
                              TrainingExerciseRepository trainingExerciseRepository) {
        this.repository = repository;
        this.trainingExerciseRepository = trainingExerciseRepository;
    }

    // 全件取得
    public List<TrainingSet> findAll() {
        return repository.findAll();
    }

    // ID取得
    public TrainingSet findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    //特定の種目に紐づくセット一覧を取得
    public List<TrainingSet> findByTrainingExerciseId(Long trainingExerciseId) {
        return repository.findByTrainingExerciseIdOrderBySetNumberAsc(trainingExerciseId);
    }

    // 保存
    public TrainingSet save(TrainingSet trainingSet) {

        // TrainingExerciseの紐付け
        if (trainingSet.getTrainingExercise() != null) {

            Long trainingExerciseId = trainingSet.getTrainingExercise().getId();

            TrainingExercise trainingExercise =
                    trainingExerciseRepository.findById(trainingExerciseId)
                            .orElse(null);

            trainingSet.setTrainingExercise(trainingExercise);
        }

        return repository.save(trainingSet);
    }

    // 削除
    public void delete(Long id) {
        repository.deleteById(id);
    }
}