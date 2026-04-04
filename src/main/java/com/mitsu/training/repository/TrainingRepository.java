package com.mitsu.training.repository;

import com.mitsu.training.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

// DB操作を行うインターフェース
public interface TrainingRepository extends JpaRepository<Training, Long> {

    // JpaRepositoryを継承するだけで基本的なCRUDが使える
    // save() → 保存
    // findAll() → 全件取得
    // findById() → 1件取得
    // deleteById() → 削除

}