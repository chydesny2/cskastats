package eurostat.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.core.annotation.Order;

public class Game {
	private String playerName;	
	private String timePlayed;	
	private String score;	
	private String shots2;
	private String shots3;
	private String shots1;
	private String reboundsOffensive;	
	private String reboundsDefensive;	
	private String rebounds;	
	private String passes;	
	private String interceptions;	
	private String turnovers;	
	private String blocks;	
	private String blocked;	
	private String fouls;	
	private String fouled;	
	private String index;	
	private String gameDate;	
	private String team;	
	private String rival;	
	private String home;
	public Game(String playerName, String timePlayed, String score, String shots2, String shots3,
			String shots1, String reboundsOffensive, String reboundsDefensive, String rebounds, String passes,
			String interceptions, String turnovers, String blocks, String blocked, String fouls, String fouled,
			String index, String gameDate, String team, String rival, String home) {
		super();
		this.playerName = playerName;
		this.timePlayed = timePlayed;
		this.score = score;
		this.shots2 = shots2;
		this.shots3 = shots3;
		this.shots1 = shots1;
		this.reboundsDefensive = reboundsDefensive;
		this.reboundsOffensive = reboundsOffensive;
		this.rebounds = rebounds;
		this.passes = passes;
		this.interceptions = interceptions;
		this.turnovers = turnovers;
		this.blocks = blocks;
		this.blocked = blocked;
		this.fouls = fouls;
		this.fouled = fouled;
		this.index = index;
		this.gameDate = gameDate;
		this.team = team;
		this.rival = rival;
		this.home = home;
	}
	public Game() {
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getTimePlayed() {
		return timePlayed;
	}
	public void setTimePlayed(String timePlayed) {
		this.timePlayed = timePlayed;
	}

	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getShots2() {
		return shots2;
	}
	public void setShots2(String shots2) {
		this.shots2 = shots2;
	}
	public String getShots3() {
		return shots3;
	}
	public void setShots3(String shots3) {
		this.shots3 = shots3;
	}
	public String getShots1() {
		return shots1;
	}
	public void setShots1(String shots1) {
		this.shots1 = shots1;
	}
	public String getReboundsDefensive() {
		return reboundsDefensive;
	}
	public void setReboundsDefensive(String reboundsDefensive) {
		this.reboundsDefensive = reboundsDefensive;
	}
	public String getReboundsOffensive() {
		return reboundsOffensive;
	}
	public void setReboundsOffensive(String reboundsOffensive) {
		this.reboundsOffensive = reboundsOffensive;
	}
	public String getRebounds() {
		return rebounds;
	}
	public void setRebounds(String rebounds) {
		this.rebounds = rebounds;
	}
	public String getPasses() {
		return passes;
	}
	public void setPasses(String passes) {
		this.passes = passes;
	}
	public String getInterceptions() {
		return interceptions;
	}
	public void setInterceptions(String interceptions) {
		this.interceptions = interceptions;
	}
	public String getTurnovers() {
		return turnovers;
	}
	public void setTurnovers(String turnovers) {
		this.turnovers = turnovers;
	}
	public String getBlocks() {
		return blocks;
	}
	public void setBlocks(String blocks) {
		this.blocks = blocks;
	}
	public String getBlocked() {
		return blocked;
	}
	public void setBlocked(String blocked) {
		this.blocked = blocked;
	}
	public String getFouls() {
		return fouls;
	}
	public void setFouls(String fouls) {
		this.fouls = fouls;
	}
	public String getFouled() {
		return fouled;
	}
	public void setFouled(String fouled) {
		this.fouled = fouled;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getGameDate() {
		return gameDate;
	}
	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getRival() {
		return rival;
	}
	public void setRival(String rival) {
		this.rival = rival;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}

	
	
}
