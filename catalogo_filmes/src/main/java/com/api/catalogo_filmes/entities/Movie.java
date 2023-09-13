package com.api.catalogo_filmes.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="movies")
public class Movie  implements Serializable {
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

	private String gender;
    private String poster;

	@OneToMany(mappedBy = "movie")
	private Set<Comment> comment=new HashSet<>();
	
	@JsonIgnore
	private List<Integer> userRating=new ArrayList<>();
	
	public Movie(){}

	public Movie(Long id, String title, String synopsis, String duration, String ratingSystem, String criticsRating,
			String studio, String originalLanguage, String countryOfOrigin, String gender, Set<String> caast) {
		this.id = id;
		this.title = title;
		this.synopsis = synopsis;
		this.duration = duration;
		this.ratingSystem = ratingSystem;
		this.criticsRating = criticsRating;
		this.studio = studio;
		this.originalLanguage = originalLanguage;
		this.countryOfOrigin = countryOfOrigin;
		this.gender = gender;
		this.caast=caast;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Integer> getUserRating() {
		return userRating;
	}
	public void toassess(Integer assessment) {
		userRating.add(assessment);
	}
	public int averageRating() {
		int average=0;
		for(int i=0; i<userRating.size(); i++) {
			average=average+userRating.get(i);
		}
		return average/userRating.size();
	}
	public Set<String> getCast() {
		return caast;
	}
	public Set<Comment> getComment() {
		return comment;
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
		Movie other = (Movie) obj;
		return Objects.equals(id, other.id);
	}
	
	



	

}
