package com.mitsu.training.controller;

import com.mitsu.training.entity.Exercise;
import com.mitsu.training.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 種目API
@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseService service;

    public ExerciseController(ExerciseService service) {
        this.service = service;
    }

    // 一覧取得
    @GetMapping
    public List<Exercise> getAll() {
        return service.findAll();
    }

    // 登録
    @PostMapping
    public Exercise create(@RequestBody Exercise exercise) {
        return service.save(exercise);
    }
}