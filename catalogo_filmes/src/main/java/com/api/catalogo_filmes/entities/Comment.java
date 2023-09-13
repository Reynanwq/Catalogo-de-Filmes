package com.api.catalogo_filmes.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment implements Serializable {
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
    public Comment(){}

    public Comment(Long id, User author, Movie movie, String date, String text, String time) {
        this.id = id;
        this.author = author;
        this.movie=movie;
        this.date = date;
        this.text = text;
        this.time = time;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @JsonIgnore
    public User getAuthor() {
        return author;
    }
    public String getNameAuthor() {
    	return author.getName();
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

    @JsonIgnore
    public Movie getMovie() {
		return movie;
	}
    public String getNameMovie() {
    	return movie.getTitle();
    }

	@Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", text='" + text + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(id, other.id);
	}
}
