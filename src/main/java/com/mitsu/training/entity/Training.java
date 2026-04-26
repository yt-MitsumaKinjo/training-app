package com.mitsu.training.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

// トレーニング（1日の記録）
@Entity
@Table(name = "trainings")
public class Training {

    // 主キー
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // トレーニング日
    @Column(nullable = false) // NOT NULL制約
    private LocalDate date;

    // 種目一覧（一対多）
    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    @JsonManagedReference
    @OrderBy("id ASC")  //Set でも順序を保証
    private Set<TrainingExercise> trainingExercises;

    // デフォルトコンストラクタ
    public Training() {}

    // getter
    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Set<TrainingExercise> getTrainingExercises() {
        return trainingExercises;
    }

    // setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTrainingExercises(Set<TrainingExercise> trainingExercises) {
        this.trainingExercises = trainingExercises;
    }
}
