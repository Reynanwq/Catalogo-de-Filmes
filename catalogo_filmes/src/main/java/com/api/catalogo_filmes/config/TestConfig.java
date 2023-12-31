package com.api.catalogo_filmes.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.api.catalogo_filmes.entities.Comment;
import com.api.catalogo_filmes.entities.Movie;
import com.api.catalogo_filmes.entities.User;
import com.api.catalogo_filmes.repository.CommentRepository;
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
	private CommentRepository commentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		/* ----------------------------- INSERT USERS ----------------------------- */

		User user = new User(null,"Reynan", "reynan@gmail.com", "minhasenha", "14/12/1914", "Masculino");
		User reynan_paiva = new User(null,"Reynan Paiva", "reynan@gmail.com", "123", "15/03/1944", "Masculino");
		User paulo_paulo = new User(null,"Paulo", "paulo@gmail.com", "azul", "10/02/1970", "Masculino");
		User Freddy_Krueger = new User(null,"Freddy_Krueger", "Freddy_Krueger@gmail.com", "alo123", "11/11/1930", "Masculino");
		User Jason_Voorhees = new User(null,"Jason_Voorhees", "Jason_Voorhees@gmail.com", "naotemsenha", "30/03/1999", "Masculino");
		User Leatherface = new User(null,"Leatherface", "Leatherface@gmail.com", "minhaqueria", "09/09/1997", "Masculino");
		User Pennywise = new User(null,"Pennywise", "Pennywise@gmail.com", "java", "28/02/1956", "Masculino");
		User Chucky = new User(null,"Chucky", "Chucky@gmail.com", "rubyblood", "27/01/2000", "Masculino");
		User Hannibal_Lecter = new User(null,"Hannibal_Lecter", "Hannibal_Lecter@gmail.com", "ponto", "03/10/2010", "Masculino");
		User Ghostface = new User(null,"Ghostface", "Ghostface@gmail.com", "virgulo", "04/04/1901", "Masculino");
		User Annabelle = new User(null,"Annabelle", "Annabelle@gmail.com", "mietetnha", "05/02/2002", "Feminino");
		User Dracula = new User(null,"Dracula", "Dracula@gmail.com", "minhfafaffha", "12/12/2004", "Masculino");
		User Frankenstein = new User(null,"Frankenstein", "Frankenstein@gmail.com", "m31312senha", "31/03/1874", "Masculino");
		User lionel_Messi = new User(null,"lionel_Messi", "lionel_Messi@gmail.com", "mi31324!@@!enha", "05/08/2023", "Masculino");
		User cristiano_ronaldo = new User(null,"cristiano_ronaldo", "cristiano_ronaldo@gmail.com", "!@#$@$!$", "11/11/2007", "Masculino");
		User abel_ferreira = new User(null,"abel_ferreira", "abel_ferreira@gmail.com", "123456879", "24/07/1969", "Masculino");
		User jorge_jesus = new User(null,"jorge_jesus", "jorge_jesus@gmail.com", "40028922", "25/05/1945", "Masculino");
		User rogerio_ceni = new User(null,"rogerio_ceni", "rogerio_ceni@gmail.com", "313131313133", "17/09/1917", "Masculino");

		/*----------------------------- SEND USERS FROM DATABASE -----------------------------*/
		userRepository.saveAll(Arrays.asList(user));
		userRepository.saveAll(Arrays.asList(reynan_paiva));
		userRepository.saveAll(Arrays.asList(paulo_paulo));
		userRepository.saveAll(Arrays.asList(rogerio_ceni));
		userRepository.saveAll(Arrays.asList(Freddy_Krueger));
		userRepository.saveAll(Arrays.asList(Jason_Voorhees));
		userRepository.saveAll(Arrays.asList(Leatherface));
		userRepository.saveAll(Arrays.asList(Pennywise));
		userRepository.saveAll(Arrays.asList(Chucky));
		userRepository.saveAll(Arrays.asList(Hannibal_Lecter));
		userRepository.saveAll(Arrays.asList(Ghostface));
		userRepository.saveAll(Arrays.asList(Annabelle));
		userRepository.saveAll(Arrays.asList(Dracula));
		userRepository.saveAll(Arrays.asList(Frankenstein));
		userRepository.saveAll(Arrays.asList(lionel_Messi));
		userRepository.saveAll(Arrays.asList(cristiano_ronaldo));
		userRepository.saveAll(Arrays.asList(abel_ferreira));
		userRepository.saveAll(Arrays.asList(jorge_jesus));

		/* ----------------------------- INSERT MOVIES ----------------------------- */

		Set<String> caast_talk_to_me = new HashSet<>();
		caast_talk_to_me.add("Sophie Wilde");
		caast_talk_to_me.add("Miranda Otto");
		caast_talk_to_me.add("Otis Dhanji");
		caast_talk_to_me.add("Alexandra Jensen");
		caast_talk_to_me.add("Joe Bird");
		caast_talk_to_me.add("Marcus Johnson");
		Movie movieTalkToMe = new Movie(null, "Talk to Me", "When a group of friends discover how to conjure spirits using an embalmed hand, they become hooked on the new thrill, until one of them goes too far and unleashes terrifying supernatural forces. ", "1h 35m", "94%", "With a gripping story and impressive practical effects, Talk to Me spins a terrifically creepy 21st-century horror yarn built on classic foundations", "Causeway Films", " English", "United States of America","Horro, Mystrery & Thriller", caast_talk_to_me);

		Set<String> casstTheNun2 = new HashSet<>();
		casstTheNun2.add("Taissa Farmiga");
		casstTheNun2.add("Jonas Bloquet");
		casstTheNun2.add("Storm Reid");
		casstTheNun2.add("Anna Popplewell");
		casstTheNun2.add("Bonie Aarons");
		casstTheNun2.add("Katelyn Rose Downey");
		Movie movietheNun2 = new Movie(null, "The Nun II", "1956 -- France. A priest is murdered. An evil is spreading. The sequel to the worldwide smash hit follows Sister Irene as she once again comes face-to-face with Valak, the demon nun. ", "1h 50m", "48%", "Scarier than its predecessor, The Nun II makes for an entertaining addition to the Conjuring franchise despite not being the most original horror sequel.", "Warner Bros. Pictures", "English", "United States of America","Horror, Mystery & Thriller", casstTheNun2);

		/*----------------------------- SEND MOVIE FROM DATABASE -----------------------------*/

		movieRepository.saveAll(Arrays.asList(movieTalkToMe));
		movieRepository.saveAll(Arrays.asList(movietheNun2));
		//movieRepository.saveAll(Arrays.asList(SEND SOMETHING HERE!));

		/* ----------------------------- INSERT COMMENTS ----------------------------- */

		Comment comment_reynan_paiva_talk_to_me = new Comment(null, reynan_paiva, movieTalkToMe, "06/09/2003", "Talk to Me is a sleek, frightening, and unique construction that digs into teen loneliness and dispossession through actual possession. It is literally bone crunching and ferocious with gore aplenty but is also empathetic.", "20:36");
		Comment commentReynanPaivaTheNun2 = new Comment(null, reynan_paiva, movietheNun2, "15/09/2023", "Branagh's Poirot is more internal and less outwardly flashy than he has been in the past, and it's an effective performance lost in a drab, dusty production.", "12:33");
		//Comment commentRogerio_ceni = new Comment(null, user, movie, "31/10/2003", "Esse filme é um desastre!", "20:36");

		/*----------------------------- SEND comments FROM DATABASE -----------------------------*/
		commentRepository.saveAll(Arrays.asList(comment_reynan_paiva_talk_to_me));
		commentRepository.saveAll(Arrays.asList(commentReynanPaivaTheNun2));
	//	commentRepository.saveAll(Arrays.asList(commentRogerio_ceni));
		
	}
}
