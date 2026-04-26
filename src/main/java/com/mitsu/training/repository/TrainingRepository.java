package com.mitsu.training.repository;

import com.mitsu.training.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//Training用DB操作
public interface TrainingRepository extends JpaRepository<Training, Long> {

    // JpaRepositoryを継承するだけで基本的なCRUDが使える
    // save() → 保存
    // findAll() → 全件取得
    // findById() → 1件取得
    // deleteById() → 削除
    @Query("SELECT t FROM Training t " +
            "LEFT JOIN FETCH t.trainingExercises te " +
            "LEFT JOIN FETCH te.exercise e " +
            "LEFT JOIN FETCH e.bodyPart " +
            "LEFT JOIN FETCH te.trainingSets " +
            "WHERE t.id = :id")
    Training findByIdWithRelations(Long id);
}