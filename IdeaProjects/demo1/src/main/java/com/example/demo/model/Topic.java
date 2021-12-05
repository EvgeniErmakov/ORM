package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String title;

    public Topic(String title) {
        this.title = title;
    }

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval  = false)
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment) {
        this.comments.add(comment);
        comment.setTopic(this);
    }

    public void removeComment(Comment comment) {
        System.out.println(comments.get(0).getId());
        System.out.println(comments.size());
        this.comments.remove(comment);

        comment.setTopic(null);
    }
}