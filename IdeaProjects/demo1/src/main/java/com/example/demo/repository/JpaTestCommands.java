package com.example.demo.repository;

import com.example.demo.model.Comment;
import com.example.demo.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTestCommands extends JpaRepository<Topic, Integer> {

}
