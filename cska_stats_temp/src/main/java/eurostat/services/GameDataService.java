package eurostat.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eurostat.dao.PlayerStatDate;
import eurostat.dto.GameConvertedRepository;
import eurostat.entities.GameConverted;

@Service
public class GameDataService {

	@Autowired
	private GameConvertedRepository gRepo;
	
	public List<GameConverted> findAll(){
		return gRepo.findAll();
	}
	
	public List<GameConverted> findAllAscDate(){
		return gRepo.findAll(Sort.by(Sort.Direction.ASC, "gameDate"));
	}

	public Model prepareData(Model model, PlayerStatDate playerStatDate) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<GameConverted> allDB = this.findAllAscDate();
		
		//declaring Lists that contain a list of scores or a number of records for each player:
		List<List<String>> datesList = new ArrayList<>();
		List<List<Integer>> statsList = new ArrayList<>();
		List<List<Integer>> countList = new ArrayList<>();
		
		//setting the date format that is gonna be delivered to the js code
	    SimpleDateFormat targetDateFormat = new SimpleDateFormat("yyyy-MM-dd");		
	    
	    //adds the list of players to the model (gonna be delivered to the js code)
		model.addAttribute("playersCommited", playerStatDate.getPlayers());
		
		
		//searching through all the records that contain a specific name 
		for (String name : playerStatDate.getNames()) {
			//declaring a list of values for the player
			List<Integer> singleIntegerList = new ArrayList<>();
			List<String> singleDateList = new ArrayList<>();
			List<Integer> singleCountList = new ArrayList<>();
			//declaring the count of records for the player to count the average later
			int count = 0;
			for (GameConverted gc : allDB) {
				//if the record has the name of the player and falls in the selected timeframe
				if (gc.getPlayerName().equals(name) && (gc.isInTheTimeframe(playerStatDate))) {								
							//incrementing the number of records using the method that takes in the name of the column we count the records for
							count += gc.getCount(playerStatDate.getColumn());
							singleCountList.add(count);
							//taking the name of the column and searching for the respective method returning its value....
							Method method = GameConverted.class.getMethod(playerStatDate.getColumn());
							//...and invoking this method, adding the result to the respective list of values for the player
							singleIntegerList.add((int)method.invoke(gc));
							//also adding to the player's gameDate list
							singleDateList.add(targetDateFormat.format(gc.getGameDate()));
				}
			}
			
			//adding the count list of the player to the List of lists of counts of all the players selected
			countList.add(singleCountList);
			
			//adding the list to the list of lists of all the players selected
			statsList.add(singleIntegerList);
			datesList.add(singleDateList);
		}
		model.addAttribute("datesList", toJsFormat(datesList.toString()));
		model.addAttribute("statsList", toJsFormat(statsList.toString()));
		model.addAttribute("showAverage", playerStatDate.isShowAverage());
		model.addAttribute("countList", toJsFormat(countList.toString()));					
		
		//adding to the wrap-up container so the user could input another values
		
		//sends to the model the interpreted selected column name so to show it on the js plot
		model.addAttribute("statsName", playerStatDate.interpretSelectedColumn());
		return model;
	}
	
	//transforms the string into the right format to be delivered to js
	public static String toJsFormat(String input) {
		return input.replaceAll("], ", "*").replaceAll("\\[\\[", "").replaceAll("\\]\\]", "").replaceAll("\\[", "");
	}
	


}
