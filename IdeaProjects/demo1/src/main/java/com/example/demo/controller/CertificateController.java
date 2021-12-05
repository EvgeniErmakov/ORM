package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.model.Topic;
import com.example.demo.repository.JpaCommentCommands;
import com.example.demo.repository.JpaTopicCommands;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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

        System.out.println("save");
    }

    @GetMapping(value = "/merge/{id}")
    public void findById(@PathVariable Long id) {
        Topic topic = topicRepository.getOne(id);
        topic.setTitle("Updated Title");

        Comment comment = commentRepository.getOne(14L);
        comment.setText("Updated Text");
        topicRepository.save(topic);

        System.out.println("merge");
    }

    @GetMapping(value = "/delete/{id}")
    public void whenDeleteTopic_commentsShouldBeDeleted(@PathVariable Long id) {
        Topic topic = topicRepository.getOne(id);
        topicRepository.delete(topic);
        System.out.println("delete");
    }


    @Autowired
    private EntityManagerFactory emf;

    @GetMapping(value = "/orphanRemoval/{id}")
    public void orphanRemovalTrue_DeleteComment (@PathVariable Long id) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Optional<Topic> topic = Optional.ofNullable(entityManager.find(Topic.class, id));
        topic.get().removeComment(topic.get().getComments().get(0));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
