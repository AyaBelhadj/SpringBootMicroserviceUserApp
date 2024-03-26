package com.example.userApp.userAPI;

import com.example.userApp.userAPI.model.User;
import com.example.userApp.userAPI.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            try {
                User User1 = new User("001", "aya", "aya@gamil.com", "123");
                User User2 = new User("002", "imem", "imem@gmail.com", "1234");
                User User3 = new User("003", "Mohamed", "Mohamed@gamil.com", "123");
                User User4 = new User("004", "Ahmed", "Ahmed@gmail.com", "1234");
                repository.save(User1);
                repository.save(User2);
                repository.save(User3);
                repository.save(User4);
            } catch (Exception e) {
                System.err.println("Une exception s'est produite : " + e.getMessage());

            }

        };
    }
}