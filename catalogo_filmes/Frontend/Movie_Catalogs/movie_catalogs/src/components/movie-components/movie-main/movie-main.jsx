import './movie-main.css';
import StarWars_img from '../../../assets/img-StarWars-test.webp';
import React, { useState, useEffect } from 'react';
import axios from 'axios';

function  Movie_main(){

  const [posts, setPosts] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/characters")
      .then((response) => {
        setPosts(response.data);
      })
      .catch(() => {
        console.log("error in axios request");
      });
  }, []);

  return(
    <div>
      {posts.map((post, key) => (
      <div key={key} className="card-achievement">
      <img src={StarWars_img} alt="IMG STAR WARS" />
        <h2>TITLE: {post.title}</h2>
        <h2>SYNOPSIS: {post.synopsis}</h2>
        <h2>DURATION: {post.duration}</h2>
        <h2>RATING SYSTEM: {post.ratingSystem}</h2>
        <h2>CRITICS RATING: {post.criticsRating}</h2>
        <h2>STUDIO: {post.studio}</h2>
        <h2>ORIGINNAL LANGUAGE: {post.originalLanguage}</h2>
        <h2>COUNTRY OF ORIGIN: {post.countryOfOrigin}</h2>
        <h2>CAAST: {post.caast}</h2>
      </div>
      ))}
    </div>
  );
}  

export default Movie_main;