package com.mitsu.training.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    // デフォルトコンストラクタ
    public Training() {}

    // getter
    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    // setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
