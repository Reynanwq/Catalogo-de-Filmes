package com.api.catalogo_filmes.arm;

import jakarta.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String director;
    @Column(nullable = false)
    private String cast;
    @Column(nullable = false)
    private String synopsis;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false)
    private Integer release_year;
    @Column(nullable = false)
    private String duration;
    @Column(nullable = false)
    private String indicative_rating;
    private String rating_from_critics;
    @Column(nullable = false)
    private String studio;
    @Column(nullable = false)
    private String country_origin;
    @Column(nullable = false)
    private String user_rating;

    @Deprecated
    public Movie(){};

    public Movie(Integer id, String title, String director, String cast, String synopsis, String genre, Integer release_year, String duration, String indicative_rating, String rating_from_critics, String studio, String country_origin, String user_rating) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.synopsis = synopsis;
        this.genre = genre;
        this.release_year = release_year;
        this.duration = duration;
        this.indicative_rating = indicative_rating;
        this.rating_from_critics = rating_from_critics;
        this.studio = studio;
        this.country_origin = country_origin;
        this.user_rating = user_rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getIndicative_rating() {
        return indicative_rating;
    }

    public void setIndicative_rating(String indicative_rating) {
        this.indicative_rating = indicative_rating;
    }

    public String getRating_from_critics() {
        return rating_from_critics;
    }

    public void setRating_from_critics(String rating_from_critics) {
        this.rating_from_critics = rating_from_critics;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getCountry_origin() {
        return country_origin;
    }

    public void setCountry_origin(String country_origin) {
        this.country_origin = country_origin;
    }

    public String getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(String user_rating) {
        this.user_rating = user_rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", Title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", cast='" + cast + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", genre='" + genre + '\'' +
                ", release_year=" + release_year +
                ", duration='" + duration + '\'' +
                ", indicative_rating='" + indicative_rating + '\'' +
                ", rating_from_critics='" + rating_from_critics + '\'' +
                ", studio='" + studio + '\'' +
                ", country_origin='" + country_origin + '\'' +
                ", user_rating='" + user_rating + '\'' +
                '}';
    }
}
