package com.FabricioS0.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.FabricioS0.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
	
	@Modifying
	@Query(nativeQuery = true,
	value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listid AND game_id = :gameId")
	void updateBelongingPosition(Long listid, Long gameId, Integer newPosition);
}
