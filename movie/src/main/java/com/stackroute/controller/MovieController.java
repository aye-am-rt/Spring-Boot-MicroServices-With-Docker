package com.stackroute.controller;

import com.stackroute.domain.Movie;
import com.stackroute.services.MovieService;
import com.stackroute.services.MovieServiceImpl;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping(value = "api/v1")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
        ResponseEntity responseEntity;
        try {
            movieService.saveMovie(movie);
            responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("movies")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<List<Movie>>(movieService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("movie/{id}")
    public ResponseEntity<?> getMovieWithId(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<Movie>(movieService.getMovieWithId(id).get(), HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping(value = "movie/{id}")
    public ResponseEntity<?> deleteMovieWithId(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<Movie>(movieService.getMovieWithId(id).get(), HttpStatus.OK);
            movieService.deleteMovie(id);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping(value = "movie")
    public ResponseEntity<?> updateMovieWithId(@RequestBody Movie movie) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<Movie>(movieService.getMovieWithId(movie.getId()).get(), HttpStatus.OK);
            movieService.updateMovie(movie);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
