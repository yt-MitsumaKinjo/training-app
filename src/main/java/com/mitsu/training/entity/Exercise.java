package com.mitsu.training.entity;

import jakarta.persistence.*;

// 種目マスタ
@Entity
public class Exercise {

    // 主キー
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 種目名
    private String name;

    // 部位との紐付け（多対一）
    @ManyToOne
    @JoinColumn(name = "body_part_id")
    private BodyPart bodyPart;

    // デフォルトコンストラクタ
    public Exercise() {}

    // ID取得
    public Long getId() {
        return id;
    }

    // ID設定
    public void setId(Long id) {
        this.id = id;
    }

    // 名前取得
    public String getName() {
        return name;
    }

    // 名前設定
    public void setName(String name) {
        this.name = name;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }


}