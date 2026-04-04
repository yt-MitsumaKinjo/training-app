package com.mitsu.training.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

// DBのテーブルと紐づくクラス
@Entity
public class Training {

    // 主キー
    @Id
    // 自動採番
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // トレーニング名
    private String name;

    // 日付
    private LocalDate date;

    // デフォルトコンストラクタ（必須）
    public Training(){}

    // ID設定（PUTで必要）
    public void setId(Long id) {
        this.id = id;
    }

    // ID取得
    public Long getId() {
        return id;
    }

    // 名前取得
    public String getName(){
        return name;
    }

    // 名前設定
    public void setName(String name){
        this.name = name;
    }

    // 日付取得
    public LocalDate getDate() {
        return date;
    }

    // 日付設定
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
