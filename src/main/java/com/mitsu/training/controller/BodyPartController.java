package com.mitsu.training.controller;

import com.mitsu.training.entity.BodyPart;
import com.mitsu.training.service.BodyPartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 部位API
@RestController
@RequestMapping("/bodyparts")
public class BodyPartController {

    private final BodyPartService service;

    public BodyPartController(BodyPartService service) {
        this.service = service;
    }

    // 一覧取得
    @GetMapping
    public List<BodyPart> getAll() {
        return service.findAll();
    }

    // IDで取得
    @GetMapping("/{id}")
    public BodyPart getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // 登録
    @PostMapping
    public BodyPart create(@RequestBody BodyPart bodyPart) {
        return service.save(bodyPart);
    }
}
