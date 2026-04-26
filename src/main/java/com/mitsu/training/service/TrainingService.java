package com.mitsu.training.service;

import com.mitsu.training.entity.Training;
import com.mitsu.training.entity.TrainingExercise;
import com.mitsu.training.entity.TrainingSet;
import com.mitsu.training.repository.TrainingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    // IDで取得
    public Training findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // 1件保存
    public Training save(Training training) {
        return repository.save(training);
    }

    // 一括保存
    @Transactional
    public Training saveWithRelations(Training training) {

        // 子がない場合はそのまま保存
        if (training.getTrainingExercises() == null) {
            Training saved = repository.save(training); // 一旦保存
            return repository.findByIdWithRelations(saved.getId()); //DBから再取得（nameなども取得）
        }

        // 子に親をセット
        for (TrainingExercise te : training.getTrainingExercises()) {
            te.setTraining(training);

            if (te.getTrainingSets() != null) {
                for (TrainingSet ts : te.getTrainingSets()) {
                    ts.setTrainingExercise(te);
                }
            }
        }

        //保存
        Training saved = repository.save(training); //保存結果を変数に入れる(SQL:INSERT)

        // DBから再取得して完全な状態で返す（SQL:JOIN FECH ※exercise.nameが入る）
        return repository.findByIdWithRelations(saved.getId());
    }

    // 削除処理
    public void delete(Long id) {
        repository.deleteById(id);
    }
}