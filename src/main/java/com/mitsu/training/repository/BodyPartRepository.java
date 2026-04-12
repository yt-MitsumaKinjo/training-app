package com.mitsu.training.repository;

import com.mitsu.training.entity.BodyPart;
import org.springframework.data.jpa.repository.JpaRepository;

//BodyPart用DB操作
public interface BodyPartRepository extends JpaRepository<BodyPart, Long>{
}
