package com.mitsu.training.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;


//テーブル名を指定
@Entity
@Table(name = "training_exercises")
public class TrainingExercise {

    //主キー
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // トレーニングとの紐付け（多対1）
    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    @JsonBackReference
    private Training training;

    // 種目との紐付け（多対1）
    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    // セットとの紐付け（一対多）
    @OneToMany(mappedBy = "trainingExercise", cascade = CascadeType.ALL)
    @JsonManagedReference
    @OrderBy("setNumber ASC")  //セット番号順に並べる
    private Set<TrainingSet> trainingSets;


    //コンストラクタ(空)
    public TrainingExercise(){}

    //コンストラクタ（値あり）
    public TrainingExercise(Training training, Exercise exercise, Integer orderIndex){
        this.training = training;
        this.exercise = exercise;
    }

    // getter
    public Long getId() {
        return id;
    }

    public Training getTraining() {
        return training;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public Set<TrainingSet> getTrainingSets() {
        return trainingSets;
    }

    // setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public void setTrainingSets(Set<TrainingSet> trainingSets) {
        this.trainingSets = trainingSets;
    }
}