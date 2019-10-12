package com.stackroute.services;

import com.stackroute.exception.MovieAlreadyExistException;
import com.stackroute.exception.MovieNotFoundException;
import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistException, MovieNotFoundException {
        if (movieRepository.existsById(movie.getId())) {
            throw new MovieAlreadyExistException("Movie Already Exist");
        }
        Movie savedMovie = movieRepository.save(movie);
        if (savedMovie == null) {
            throw new MovieNotFoundException("Movie Not Found");
        }
        return savedMovie;
    }

    @Override
    public List<Movie> getAllUsers() {
        return (List<Movie>) movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieWithId(int id) throws MovieNotFoundException {
        if (movieRepository.existsById(id)) {
            return movieRepository.findById(id);
        } else {
            throw new MovieNotFoundException("Movie Not Found");
        }
    }

    @Override
    public Movie deleteMovie(int id) throws MovieNotFoundException {
        if (movieRepository.existsById(id)) {
            Movie movie = movieRepository.findById(id).get();
            movieRepository.deleteById(id);
            return movie;
        } else {
            throw new MovieNotFoundException("Movie Not Found");
        }
    }

    @Override
    public Movie updateMovie(Movie movie) throws MovieNotFoundException {
        if (movieRepository.existsById(movie.getId())) {
            Movie movie1 = movieRepository.findById(movie.getId()).get();
            movie1.setBudget(movie.getBudget());
            movie1.setCatagory(movie.getCatagory());
            movie1.setCollection(movie.getCollection());
            movie1.setLanguage(movie.getLanguage());
            movie1.setMovieName(movie.getMovieName());
            movieRepository.save(movie1);
            return movie1;
        } else {
            throw new MovieNotFoundException("Movie Not Found");
        }
    }

}
