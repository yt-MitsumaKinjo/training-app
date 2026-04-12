package com.mitsu.training.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


//テーブル名を指定
@Entity
@Table(name = "body_parts")
public class BodyPart {

    //主キー
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY = MySQLのAUTO_INCREMENT(自動採番)
    private Long id;

    //部位名（胸・背中等）
    @Column(
            nullable = false, //NOT NULL制約
            unique = true   // 重複禁止（胸が2つは不要）
    )
    private String name;

    // 種目との紐付け（一対多）
    @OneToMany(mappedBy = "bodyPart")
    @JsonManagedReference
    private List<Exercise> exercises;

    //コンストラクタ(空)
    public BodyPart(){}

    //コンストラクタ（値あり）
    public BodyPart (String name){
        this.name = name;
    }

    // getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Exercise> getExercises(){
        return exercises;
    }

    // setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExercises(List<Exercise> exercises){
        this.exercises = exercises;
    }

}
