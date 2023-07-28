package com.api.catalogo_filmes.service;

import com.api.catalogo_filmes.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CrudUserService {
    private UserRepository userRepository;
    public CrudUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void insertData(){
        //User user01 = new User(1, "Cesar", "cesar@gmail.com", "12345678", "01/04/1987", "Male");

       // this.movieRepository.save(user01);
        System.out.println("Movie add success");
    }
}
