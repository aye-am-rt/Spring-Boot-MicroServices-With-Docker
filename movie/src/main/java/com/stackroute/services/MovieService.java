package com.stackroute.services;

import com.stackroute.exception.MovieAlreadyExistException;
import com.stackroute.exception.MovieNotFoundException;
import com.stackroute.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistException, MovieNotFoundException;
    public List<Movie> getAllUsers();
    public Optional<Movie> getMovieWithId(int id) throws MovieNotFoundException;
    public Movie deleteMovie(int id) throws MovieNotFoundException;
    public Movie updateMovie(Movie movie) throws MovieNotFoundException;

}
