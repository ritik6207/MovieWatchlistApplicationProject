package com.example.ritikkumar.watchlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ritikkumar.watchlist.entity.Movies;
import com.example.ritikkumar.watchlist.repository.MovieRepository;

@Service
public class DatabaseService {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	RatingService ratingService;
	
	public void create(Movies movie) {
		// TODO Auto-generated method stub
		
		String rating = ratingService.getMovieRating(movie.getTitle());
		if(rating != null) {
			movie.setRating(Double.parseDouble(rating));
		}
		
		movieRepository.save(movie);
	}
	
	public List<Movies> getAllMovies() {
		// TODO Auto-generated method stub
		return movieRepository.findAll();
	}
	
	public Movies getMovieById(Integer id) {
		
		return movieRepository.findById(id).get();
	}

	public void update(Movies movie, Integer id) {
		// TODO Auto-generated method stub
		Movies toUpdated = getMovieById(id);
		toUpdated.setTitle(movie.getTitle());
		toUpdated.setRating(movie.getRating());
		toUpdated.setPriority(movie.getPriority());
		toUpdated.setComments(movie.getComments());
		movieRepository.save(toUpdated);
	}
}
