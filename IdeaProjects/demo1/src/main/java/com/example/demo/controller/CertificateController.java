package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.model.Topic;
import com.example.demo.repository.JpaTestCommands;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/certificates")
@AllArgsConstructor
@Validated
public class CertificateController {
@Autowired
private final JpaTestCommands topicRepository;

    @GetMapping(value = "/{id}")
    public void findById() {
        Topic topic = new Topic("Topic1");
        Comment comment1 = new Comment("comment1");
        Comment comment2 = new Comment("comment2");
        topic.addComment(comment1);
        topic.addComment(comment2);
        topicRepository.save(topic);

        System.out.println("lolz");
    }
}
