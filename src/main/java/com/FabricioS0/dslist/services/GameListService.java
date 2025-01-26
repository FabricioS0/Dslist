package com.FabricioS0.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FabricioS0.dslist.dto.GameListDTO;
import com.FabricioS0.dslist.entities.GameList;
import com.FabricioS0.dslist.projections.GameMinProjection;
import com.FabricioS0.dslist.repositories.GameListRepository;
import com.FabricioS0.dslist.repositories.GameRepository;


@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	

		@Transactional(readOnly = true)
		public List<GameListDTO> findAll(){
			List<GameList> result = gameListRepository.findAll();
			return result.stream().map(x -> new GameListDTO(x)).toList();
		}
		
		@Transactional
		public void move(long listid, int sourceIndex, int destinationIndex) {
			
			List<GameMinProjection> list = gameRepository.searchByList(listid);
			
			GameMinProjection obj = list.remove(sourceIndex);
			list.add(destinationIndex, obj);
		
			int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
			
			int max = sourceIndex > destinationIndex ?  destinationIndex : sourceIndex;
			
			for(int i=min; i<= max; i++) {
				gameListRepository.updateBelongingPosition(listid, list.get(i).getId(), i);
			}
		}
}
