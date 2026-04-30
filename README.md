# トレーニング記録アプリ

## はじめに

日々のトレーニング記録は重要ですが、
「記録する手間」や「データの管理」が負担になることがあります。

本アプリは、トレーニングデータを構造的に管理し、
効率的に記録・取得できるようにすることを目的に開発しました。

---

## コンセプト

**「トレーニングデータを正しく構造化し、管理する」**

単なる記録ではなく、データとして扱える設計を重視しています。

---

## 概要

本アプリは、トレーニングの記録（種目・セット）を日付単位で管理する Web アプリです。

バックエンドではリレーションを活用し、複雑なデータ構造をシンプルに扱えるように設計しています。  
また、フロントエンドは最小構成で構築し、**誰でも直感的に操作できるシンプルな UI** を実現しています。

「正しく構造化されたデータ」と「使いやすい操作性」の両立を目指したアプリケーションです。

---

## 主な機能

### トレーニング管理

- **「トレーニング記録」ボタン**  
  - 日付、種目、セット・重量の登録

- **「詳細」ボタン**  
  - 指定した日付のトレーニング取得

- **「削除」ボタン**  
  - トレーニング削除（ID単位）

---


## プレビュー

https://github.com/user-attachments/assets/4fa63eb5-e518-461c-a82e-d8fe14c55816




---

## 使用技術

### バックエンド

* Java（Spring Boot）
* Spring Data JPA（Hibernate）

### フロントエンド

* HTML / CSS / JavaScript

### データベース

* MySQL

### 環境

* Docker / Docker Compose

---

## データ構造（ERイメージ）

### トランザクションデータ

* **Training**

  * トレーニング日を管理  
  <img width="205" height="75" alt="image" src="https://github.com/user-attachments/assets/25ea9abf-0eb7-47f8-b824-d7aba9b38040" />

* **TrainingExercise**

  * TrainingとExerciseの中間テーブル  
  <img width="262" height="90" alt="image" src="https://github.com/user-attachments/assets/a8741e71-6473-46f3-b7ed-587a72d9cab3" />

* **TrainingSet**

  * セット情報（重量・回数）  
  <img width="374" height="175" alt="image" src="https://github.com/user-attachments/assets/c8b8e697-ca70-4327-80d3-5b5b48c4c667" />


### マスタデータ

* **BodyPart**

  * 部位（胸・背中・脚など）  
  <img width="209" height="127" alt="image" src="https://github.com/user-attachments/assets/6e26a17a-0e54-46b9-971e-42c679093bd4" />

* **Exercise**
  * 種目（ベンチプレスなど）
  * BodyPartとリレーション  
  <img width="386" height="365" alt="image" src="https://github.com/user-attachments/assets/b0d0de86-f9fc-464c-b8ee-569412f3120b" />

### リレーション概要

* Training 1 : N TrainingExercise
* TrainingExercise 1 : N TrainingSet
* Exercise N : 1 BodyPart

---

## 工夫した点

* 親子関係を持つデータの一括保存処理を実装
* 日付検索やID削除など、実用的なAPI設計

---

## 苦労した点

* リレーション構造の設計とデータの整合性維持
* Lazyロードによるデータ取得問題への対応

---

## 起動方法

### 1. リポジトリをクローン

```bash
git clone （https://github.com/yt-MitsumaKinjo/training-app.git）
```

### 2. Docker起動

```bash
docker-compose up -d
```

### 3. アプリ起動

```bash
./mvnw spring-boot:run
```

### 4. アクセス

```
http://localhost:8080/index.html
```

---

## 開発を通して得たこと
  
- リレーショナルデータベース設計の重要性  
  データ同士の関係を正しく定義することで、取得・更新が一貫性を保ちながら行えることを理解した。
  
- Postman を使った段階的な API 検証  
  API を一つずつテストしながら進めることで問題を早期に発見でき、確実に課題を解決しながらスムーズに開発を進められることを学んだ。

- JPA によるデータ操作の抽象化  
  SQL を意識せずにエンティティ操作で開発を進められ、生産性と保守性が向上することを学んだ。



## おわりに

本アプリでは、トレーニング記録を題材に
「リレーショナルデータ設計」と「API設計」の理解を深めることを目的としました。

今後はログイン機能（User）の実装、種目やセットの更新・分析機能などを追加し、より実用的なアプリへと拡張していく予定です。
