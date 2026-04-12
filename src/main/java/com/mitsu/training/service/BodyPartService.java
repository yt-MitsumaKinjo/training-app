package com.mitsu.training.service;

import com.mitsu.training.entity.BodyPart;
import com.mitsu.training.repository.BodyPartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// 部位ロジック
@Service
public class BodyPartService {

    private final BodyPartRepository repository;

    // コンストラクタインジェクション
    public BodyPartService(BodyPartRepository repository) {
        this.repository = repository;
    }

    // 全件取得
    public List<BodyPart> findAll() {
        return repository.findAll();
    }

    // IDで取得（存在しない場合はnullになる）
    public BodyPart findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // 保存
    public BodyPart save(BodyPart bodyPart) {
        return repository.save(bodyPart);
    }
}