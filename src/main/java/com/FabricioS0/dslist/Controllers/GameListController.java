package com.FabricioS0.dslist.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FabricioS0.dslist.dto.GameDTO;
import com.FabricioS0.dslist.dto.GameListDTO;
import com.FabricioS0.dslist.dto.GameMinDTO;
import com.FabricioS0.dslist.entities.Game;
import com.FabricioS0.dslist.services.GameListService;
import com.FabricioS0.dslist.services.GameService;


@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
}
