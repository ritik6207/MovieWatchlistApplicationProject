package com.example.ritikkumar.watchlist.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingService {
	
	String apiURL = "https://www.omdbapi.com/?apikey=9a178a05&t=";
	
	public String getMovieRating(String title) {
		// TODO Auto-generated method stub
		try {
			//try to fetch the rating by calling omdb api
			RestTemplate templete = new RestTemplate();
			
			ResponseEntity<ObjectNode> response = templete.getForEntity(apiURL+title, ObjectNode.class);
			
			ObjectNode jsonObject = response.getBody();
			System.out.println(jsonObject.path("imdbRating").asText());
			return jsonObject.path("imdbRating").asText();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Either movie name not available or api is down" + e.getMessage());
			return null;
		}
	}
}
