package com.api.catalogo_filmes.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.api.catalogo_filmes.entities.Commentt;
import com.api.catalogo_filmes.entities.Movie;
import com.api.catalogo_filmes.entities.User;
import com.api.catalogo_filmes.repository.CommenttRepository;
import com.api.catalogo_filmes.repository.MovieRepository;
import com.api.catalogo_filmes.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private CommenttRepository commenttRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User(null,"Paulo", "paulo@gmail.com", "123", "28/07/1988", "Masculono");
		Set<String> caast = new HashSet<>();
		caast.add("Fernando Filmes");
		caast.add( "Aghata Filmes");
		
		Movie movie = new Movie(null, "Filme teste", "Filme teste", "Filme teste", "Filme teste", "Filme teste", "Filme teste", "Filme teste", "Filme teste",caast);
		userRepository.saveAll(Arrays.asList(user));
		movieRepository.saveAll(Arrays.asList(movie));
		
		Commentt commentt = new Commentt(null, user, movie, "30/07/2023", "Esse filme é muito bom!", "20:36");
		commenttRepository.saveAll(Arrays.asList(commentt));
		
		
	}
		
		
	
}
