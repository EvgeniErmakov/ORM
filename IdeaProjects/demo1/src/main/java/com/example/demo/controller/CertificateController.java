package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.model.Topic;
import com.example.demo.repository.JpaCommentCommands;
import com.example.demo.repository.JpaTopicCommands;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/topic")
@AllArgsConstructor
@Validated
public class CertificateController {
@Autowired
private final JpaTopicCommands topicRepository;

@Autowired
private final JpaCommentCommands commentRepository;

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

    @GetMapping(value = "/merge/{id}")
    public void findById(@PathVariable Long id) {
        Topic topic = topicRepository.getOne(id);
        topic.setTitle("Updated Title");

        Comment comment = commentRepository.getOne(14L);
        comment.setText("Updated Text");
        topicRepository.save(topic);

        System.out.println("lolz2");
    }

}
