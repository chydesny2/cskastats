package eurostat.controllers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.core.JsonProcessingException;

import eurostat.dao.PlayerStatDate;
import eurostat.dto.GameConvertedRepository;
import eurostat.dto.PlayerStatDateRepository;
import eurostat.entities.GameConverted;
import eurostat.services.GameDataService;
import eurostat.services.PlayerStatDateService;

@Controller
@RequestMapping("")
public class PlayersController {	
	
	public PlayerStatDate infoCommited = new PlayerStatDate();
	public GameConverted gc = new GameConverted();
	
	@Autowired
	public GameDataService gameDataService;
	
	@Autowired
	public PlayerStatDateService playerStatDateService;
	
	//username
	String userName = null;
	
	//the main page 
	@GetMapping("")
	public String showPlayers(Model model) {
		addFormContainer(model);
		return "dashboard/index";
	}
	
	//gets the selected settings from the view
	@PostMapping("/playercommit")
	public String commitPlayers(@Valid PlayerStatDate playerStatDate, Errors errors) {
		if (errors.hasErrors()) {
			return "redirect:/";
		}
		//"remember" the user's settings
		infoCommited = playerStatDate;
		infoCommited.setPlayers();		
		playerStatDateService.save(infoCommited);
		return "redirect:/getscore";
	}
	

	//
	@SuppressWarnings("deprecation")
	@GetMapping("/getscore")
	public String score(Model model) throws JsonProcessingException, NoSuchMethodException, SecurityException, 
	IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{						
					//adding the requested data to the view model
					gameDataService.prepareData(model, infoCommited);					
					//adding the wrap-up container to the model so the user could proceed using the interface and set another parameters
					addFormContainer(model);					
					//converting the selected column into the readable format
					//and adding it to the model to use as the plot's headline
					model.addAttribute("statsName", infoCommited.interpretSelectedColumn());	
					return "dashboard/index2";
	}
	
	
	//loads the pre-saved data set from the database
	@PostMapping("/statsfromdbcommit")
	public String commitStatsFromDb(PlayerStatDate playerStatDate) {
		//searching for the user's settings through the database
		infoCommited = playerStatDateService.findByPlayerStatDateId(playerStatDate.getPlayerStatDateId());
		//
		infoCommited.setNames();
		return "redirect:/getscore";
	}
	

	//adds the season's game data, the wrap-up object and the list of pre-saved settings to the view
	public void addFormContainer(Model model) {
		model.addAttribute("glist", gameDataService.findAllAscDate());
		model.addAttribute("PlayerStatDate", infoCommited);
		List<PlayerStatDate> usslist = playerStatDateService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("usslist", usslist);
	}

}
