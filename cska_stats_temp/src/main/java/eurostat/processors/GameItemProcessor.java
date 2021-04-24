package eurostat.processors;

import java.util.Date;
import java.text.SimpleDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import eurostat.entities.Game;
import eurostat.entities.GameConverted;

public class GameItemProcessor implements ItemProcessor<Game, GameConverted>{
	  private static final Logger log = LoggerFactory.getLogger(GameItemProcessor.class);

	  @Override
	  public GameConverted process(final Game game) throws Exception {
		  
			final String playerName = game.getPlayerName().replaceAll(", ", " ");
			final int timePlayed = Integer.parseInt(game.getTimePlayed().substring(0, game.getTimePlayed().indexOf(":")))*60 + 
					Integer.parseInt(game.getTimePlayed().substring(game.getTimePlayed().indexOf(":")+1));
			final int score = Integer.parseInt(game.getScore().replaceAll("-", "0"));
			final int shots2;
			final int scored2;
			final int shots1;
			final int scored1;	
			final int shots3;
			final int scored3;
			if (game.getShots2().contains("/")) {
				shots2 = Integer.parseInt(game.getShots2().substring(game.getShots2().indexOf("/")+1).replaceAll("-", "0"));
				scored2 = Integer.parseInt(game.getShots2().substring(0, game.getShots2().indexOf("/")).replace("-", "0"));
			}
			else {
				shots2 = Integer.parseInt(game.getShots2().replaceAll("-", "0"));
				scored2 = Integer.parseInt(game.getShots2().replaceAll("-", "0"));
			};
			
			if (game.getShots3().contains("/")) {
				shots3 = Integer.parseInt(game.getShots3().substring(game.getShots3().indexOf("/")+1).replaceAll("-", "0"));
				scored3 = Integer.parseInt(game.getShots3().substring(0, game.getShots3().indexOf("/")).replace("-", "0"));
			}
			else {
				shots3 = Integer.parseInt(game.getShots3().replaceAll("-", "0"));
				scored3 = Integer.parseInt(game.getShots3().replaceAll("-", "0"));
			};
			
			if (game.getShots1().contains("/")) {
				shots1 = Integer.parseInt(game.getShots1().substring(game.getShots1().indexOf("/")+1).replaceAll("-", "0"));
				scored1 = Integer.parseInt(game.getShots1().substring(0, game.getShots1().indexOf("/")).replace("-", "0"));
			}
			else {
				shots1 = Integer.parseInt(game.getShots1().replaceAll("-", "0"));
				scored1 = Integer.parseInt(game.getShots1().replaceAll("-", "0"));
			};
			
			final int reboundsDefensive = Integer.parseInt(game.getReboundsDefensive().replaceAll("-", "0"));
			final int reboundsOffensive = Integer.parseInt(game.getReboundsOffensive().replaceAll("-", "0"));
			final int rebounds = Integer.parseInt(game.getRebounds().replaceAll("-", "0"));
			final int passes = Integer.parseInt(game.getPasses().replaceAll("-", "0"));		
			final int interceptions = Integer.parseInt(game.getInterceptions().replaceAll("-", "0"));
			final int turnovers = Integer.parseInt(game.getTurnovers().replaceAll("-", "0"));
			final int blocks = Integer.parseInt(game.getBlocks().replaceAll("-", "0"));
			final int blocked = Integer.parseInt(game.getBlocked().replaceAll("-", "0"));
			final int fouls = Integer.parseInt(game.getFouls().replaceAll("-", "0"));
			final int fouled = Integer.parseInt(game.getFouled().replaceAll("-", "0"));
			final int index = Integer.parseInt(game.getIndex().replaceAll("-", "0"));
			final Date gameDate = new SimpleDateFormat("MM.dd.yyyy").parse(game.getGameDate());
			final String team = game.getTeam();
			final String rival = game.getRival();
			final String home = game.getHome();

	    

	    final GameConverted convertedGame = new GameConverted(playerName, timePlayed, score,
	    		shots2, scored2, shots3, 
	    		scored3, shots1, scored1, 
	    		reboundsDefensive, reboundsOffensive, rebounds, 
	    		passes, interceptions, turnovers,
	    		blocks, blocked, fouls, fouled, 
	    		index, gameDate, team, rival, home);

	    log.info("Converting (" + game + ") into (" + convertedGame + ")");

	    return convertedGame;
	  }
}
