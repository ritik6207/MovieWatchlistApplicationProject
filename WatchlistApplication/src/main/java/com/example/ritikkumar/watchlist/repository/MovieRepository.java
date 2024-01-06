package com.example.ritikkumar.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ritikkumar.watchlist.entity.Movies;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer>{

}
