package com.mitsu.training.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "training_sets")
public class TrainingSet {

    // 主キー
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TrainingExerciseとの紐付け（多対1）
    @ManyToOne
    @JoinColumn(name = "training_exercise_id", nullable = false)
    @JsonBackReference
    private TrainingExercise trainingExercise;

    // セット数（1セット目、2セット目など）
    @Column(name = "set_number")
    private Integer setNumber;

    // 重量
    private Double weight;

    // 回数
    private Integer reps;

    // コンストラクタ（空）
    public TrainingSet() {}

    // コンストラクタ（値あり）
    public TrainingSet(TrainingExercise trainingExercise, Integer setNumber, Double weight, Integer reps) {
        this.trainingExercise = trainingExercise;
        this.setNumber = setNumber;
        this.weight = weight;
        this.reps = reps;
    }

    // getter
    public Long getId() {
        return id;
    }

    public TrainingExercise getTrainingExercise() {
        return trainingExercise;
    }

    public Integer getSetNumber() {
        return setNumber;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getReps() {
        return reps;
    }

    // setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setTrainingExercise(TrainingExercise trainingExercise) {
        this.trainingExercise = trainingExercise;
    }

    public void setSetNumber(Integer setNumber) {
        this.setNumber = setNumber;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }
}