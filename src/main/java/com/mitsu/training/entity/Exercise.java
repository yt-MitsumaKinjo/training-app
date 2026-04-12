package com.mitsu.training.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

// 種目マスタ
@Entity
@Table(name ="exercises")
public class Exercise {

    // 主キー
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 種目名
    @Column(nullable = false) //NOT NULL制約
    private String name;

    // 部位との紐付け（多対一）
    @ManyToOne
    @JoinColumn(name = "body_part_id")
    @JsonBackReference // JSON変換時の無限ループ防止（Exercise → BodyPart → Exercise…を防ぐ）
    private BodyPart bodyPart;

    // デフォルトコンストラクタ
    public Exercise() {}

    //getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    //setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }
}