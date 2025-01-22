package com.FabricioS0.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FabricioS0.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
	
}
