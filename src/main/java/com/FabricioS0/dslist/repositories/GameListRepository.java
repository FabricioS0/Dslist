package com.FabricioS0.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FabricioS0.dslist.entities.Game;
import com.FabricioS0.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
	
}
