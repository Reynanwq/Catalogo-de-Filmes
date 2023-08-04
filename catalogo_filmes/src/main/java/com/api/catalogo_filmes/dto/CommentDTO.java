package com.api.catalogo_filmes.dto;

import com.api.catalogo_filmes.entities.Comment;
import com.api.catalogo_filmes.entities.Movie;
import com.api.catalogo_filmes.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

public class CommentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    private String date;
    private String text;
    private String time;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;
    public CommentDTO(){};
    public CommentDTO(Comment obj){
        id = obj.getId();
        author = obj.getAuthor();
        date = obj.getDate();
        text = obj.getText();
        time = obj.getText();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
