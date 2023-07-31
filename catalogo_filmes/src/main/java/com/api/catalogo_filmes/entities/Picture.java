package com.api.catalogo_filmes.entities;

import java.io.Serializable;
import java.util.Arrays;

import jakarta.persistence.*;

@Entity
@Table(name = "picture_poster")
public class Picture implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String poster_name;
    @Lob
    private byte[] image;

    public Picture(){};
    public Picture(String poster_name, byte[] image) {
        this.poster_name = poster_name;
        this.image = image;
    }

     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoster_name() {
        return poster_name;
    }

    public void setPoster_name(String poster_name) {
        this.poster_name = poster_name;
    }

    public byte[] getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", poster_name='" + poster_name + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
}
