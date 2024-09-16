package com.example.CRUD_2.repository;

import com.example.CRUD_2.Entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<ContentEntity, Integer> {
}
