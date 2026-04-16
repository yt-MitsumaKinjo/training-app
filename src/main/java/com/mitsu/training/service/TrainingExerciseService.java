package com.mitsu.training.service;

import com.mitsu.training.entity.Exercise;
import com.mitsu.training.entity.Training;
import com.mitsu.training.entity.TrainingExercise;
import com.mitsu.training.repository.ExerciseRepository;
import com.mitsu.training.repository.TrainingExerciseRepository;
import com.mitsu.training.repository.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingExerciseService {

    // TrainingExercise用のRepository（DB操作）
    private final TrainingExerciseRepository repository;

    // Training取得用Repository（親エンティティ）
    private final TrainingRepository trainingRepository;

    // Exercise取得用Repository（種目マスタ）
    private final ExerciseRepository exerciseRepository;

    // コンストラクタインジェクション
    public TrainingExerciseService(TrainingExerciseRepository repository,
                                   TrainingRepository trainingRepository,
                                   ExerciseRepository exerciseRepository) {
        this.repository = repository;
        this.trainingRepository = trainingRepository;
        this.exerciseRepository = exerciseRepository;
    }

    // 全件取得
    public List<TrainingExercise> findAll() {
        return repository.findAll();
    }

    // IDで取得（存在しない場合はnull）
    public TrainingExercise findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // 特定のTrainingに紐づく種目一覧を取得
    public List<TrainingExercise> findByTrainingId(Long trainingId) {
        return repository.findByTrainingId(trainingId);
    }

    // 保存処理（TrainingとExerciseの紐付けを考慮）
    public TrainingExercise save(TrainingExercise trainingExercise) {

        // Trainingの紐付け
        // リクエストにtrainingが含まれている場合
        if (trainingExercise.getTraining() != null) {

            // リクエストからtrainingのIDを取得
            Long trainingId = trainingExercise.getTraining().getId();

            // DBから正しいTrainingを取得（存在しない場合はnull）
            Training training = trainingRepository.findById(trainingId)
                    .orElse(null);

            // TrainingExerciseにセット（正しいエンティティに置き換え）
            trainingExercise.setTraining(training);
        }

        // Exerciseの紐付け
        // リクエストにexerciseが含まれている場合
        if (trainingExercise.getExercise() != null) {

            // リクエストからexerciseのIDを取得
            Long exerciseId = trainingExercise.getExercise().getId();

            // DBから正しいExerciseを取得
            Exercise exercise = exerciseRepository.findById(exerciseId)
                    .orElse(null);

            // TrainingExerciseにセット（紐付け）
            trainingExercise.setExercise(exercise);
        }

        // DBに保存
        return repository.save(trainingExercise);
    }

    // 削除
    public void delete(Long id) {
        repository.deleteById(id);
    }
}