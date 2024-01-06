package com.example.ritikkumar.watchlist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.ritikkumar.watchlist.entity.Movies;
import com.example.ritikkumar.watchlist.service.DatabaseService;

import jakarta.validation.Valid;

@RestController
public class MoviesController {
	
	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchListForm(@RequestParam(required = false) Integer id)
	{
		String viewModel = "watchlistItemForm";
		Map<String, Object> model = new HashMap<>();
		System.out.println(id);
		
		if(id == null) {
			model.put("watchlistItem", new Movies());
		}else {
			model.put("watchlistItem", databaseService.getMovieById(id));
		}
		
//		Movies dummymovie = new Movies();
//		dummymovie.setTitle("Dummy");
//		dummymovie.setPriority("High");
//		dummymovie.setRating(5.2);
//		dummymovie.setComments("Jhon Deo");
//		model.put("watchlistItem", dummymovie);
		
		
		return new ModelAndView(viewModel, model);
	}
	
	@PostMapping("/watchlistItemForm")
	public ModelAndView submitWatchListForm(@Valid @ModelAttribute("watchlistItem") Movies movie, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.hasErrors());
			//if error are there , redisplay the form and let user enter again
			return new ModelAndView("watchlistItemForm");
		}
		
		Integer id = movie.getId();
		if(id == null) {
			databaseService.create(movie);
		}else {
			databaseService.update(movie, id);
		}
		
		
		RedirectView rd = new RedirectView();
		rd.setUrl("/watchlist");
		
		return new ModelAndView(rd);
	}
	
	@GetMapping("/watchlist")
	public ModelAndView getWathList() {
		// TODO Auto-generated method stub
		String viewName = "watchlist";
		Map<String, Object> model = new HashMap<>();
		List<Movies> movieList = databaseService.getAllMovies();
		model.put("watchlistrows", movieList);
		model.put("noofmovies", movieList.size());
		return new ModelAndView(viewName, model);
		
	}
}
