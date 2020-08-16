package com.codeup.springblog.models;

import com.codeup.springblog.repositories.PostRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false, unique = true)
    private String title;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String body;

    @Column(length = 150, unique = true)
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User author;

//    public Post(String title, String body) {
//        this.title = title;
//        this.body = body;
//    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post() {}

//    public Post(long id, String title, String body) {
//        this.id = id;
//        this.title = title;
//        this.body = body;
//    }
//
//    public Post(String title, String body, User author) {
//        this.title = title;
//        this.body = body;
//        this.author = author;
//    }

    public Post(long id, String title, String body, String imagePath, User author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
