package com.api.catalogo_filmes.dto;

import com.api.catalogo_filmes.entities.Comment;
import com.api.catalogo_filmes.entities.Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovieDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Set<String> caast=new HashSet<>();
    private String synopsis;
    private String duration;
    private String ratingSystem;
    private String criticsRating;
    private String studio;
    private String originalLanguage;
    private String countryOfOrigin;
    private String poster;

    //@OneToMany(mappedBy = "movie")
    private Set<Comment> comment=new HashSet<>();

    @JsonIgnore
    private List<Integer> userRating=new ArrayList<>();


    public MovieDTO(){}

    public MovieDTO(Movie obj){
        id=obj.getId();
        title=obj.getTitle();
        caast=obj.getCast();
        synopsis=obj.getSynopsis();
        duration=obj.getDuration();
        ratingSystem=obj.getRatingSystem();
        criticsRating=obj.getCriticsRating();
        studio=obj.getStudio();
        originalLanguage=obj.getOriginalLanguage();
        countryOfOrigin=obj.getCountryOfOrigin();
        comment=obj.getComment();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getCaast() {
        return caast;
    }

    public void setCaast(Set<String> caast) {
        this.caast = caast;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRatingSystem() {
        return ratingSystem;
    }

    public void setRatingSystem(String ratingSystem) {
        this.ratingSystem = ratingSystem;
    }

    public String getCriticsRating() {
        return criticsRating;
    }

    public void setCriticsRating(String criticsRating) {
        this.criticsRating = criticsRating;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Set<Comment> getComment() {
        return comment;
    }

    public void setComment(Set<Comment> comment) {
        this.comment = comment;
    }

    public List<Integer> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<Integer> userRating) {
        this.userRating = userRating;
    }
}
