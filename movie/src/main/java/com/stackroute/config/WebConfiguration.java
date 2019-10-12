package com.stackroute.config;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.math.BigDecimal;

@Configuration
@EnableMongoRepositories(basePackageClasses = MovieRepository.class)
public class WebConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository movieRepository) {
        return strings -> {
            movieRepository.save(new Movie(1,new BigDecimal(20000),"baaghi","action",2018200,"en"));
            movieRepository.save(new Movie(2,new BigDecimal(20000),"war","action",2018200,"en"));
        };
    }
}
