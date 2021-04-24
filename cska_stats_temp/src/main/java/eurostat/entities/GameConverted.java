package eurostat.entities;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.core.annotation.Order;

@Entity
@Table(name="gameconverted")
public class GameConverted {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="games_generator")
	@SequenceGenerator(name="games_generator", sequenceName = "GameConverted_seq", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="games_generator")
//	@Order(value = 0)
	
	@Column(name="gameid")
	private int gameId;
	@Order(value = 1)
	private String playerName; //1
	@Order(value = 2)
	private int timePlayed; //2
	
	@Order(value = 4)
	private int score;//3
	
	
	@Order(value = 5)
	private int shots2;//4
	@Order(value = 6)
	private int scored2;//5
	@Order(value = 7)
	private int shots3;//6
	@Order(value = 8)
	private int scored3;//7
	@Order(value = 9)
	private int shots1;//8
	@Order(value = 10)
	private int scored1;//9
	@Order(value = 11)
	private int reboundsOffensive;//10
	@Order(value = 12)
	private int reboundsDefensive;//11
	@Order(value = 13)
	private int rebounds;//12
	@Order(value = 14)
	private int passes;		//13
	@Order(value = 15)
	private int interceptions;//14
	@Order(value = 16)
	private int turnovers;//15
	@Order(value = 17)
	private int blocks;//16
	@Order(value = 18)
	private int blocked;//17
	@Order(value = 19)
	private int fouls;//18
	@Order(value = 20)
	private int fouled;//19
	@Order(value = 21)
	private int index;//20
	@Order(value = 22)
	private Date gameDate;//21
	@Order(value = 23)
	private String team;//22
	@Order(value = 24)
	private String rival;//23
	@Order(value = 25)
	private String home;//24
	
	//Constructor, gameId isn't included as it's generated automatically
	public GameConverted(String playerName, int timePlayed,	int score, int shots2, int scored2,
			int shots3, int scored3, int shots1, int scored1, int reboundsOffensive, int reboundsDefensive,
			int rebounds, int passes, int interceptions, int turnovers, int blocks, int blocked, int fouls, int fouled,
			int index, Date gameDate, String team, String rival, String home) {
		super();
		this.playerName = playerName;
		this.timePlayed = timePlayed;
		this.score = score;
		this.shots2 = shots2;
		this.scored2 = scored2;
		this.shots3 = shots3;
		this.scored3 = scored3;
		this.shots1 = shots1;
		this.scored1 = scored1;
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
	
	
	//Null constructor
	public GameConverted() {
	}
	
	//Getters and setters
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getTimePlayed() {
		return timePlayed;
	}
	public void setTimePlayed(int timePlayed) {
		this.timePlayed = timePlayed;
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getShots2() {
		return shots2;
	}
	public void setShots2(int shots2) {
		this.shots2 = shots2;
	}
	public int getScored2() {
		return scored2;
	}
	public void setScored2(int scored2) {
		this.scored2 = scored2;
	}
	public int getShots3() {
		return shots3;
	}
	public void setShots3(int shots3) {
		this.shots3 = shots3;
	}
	public int getScored3() {
		return scored3;
	}
	public void setScored3(int scored3) {
		this.scored3 = scored3;
	}
	public int getShots1() {
		return shots1;
	}
	public void setShots1(int shots1) {
		this.shots1 = shots1;
	}
	public int getScored1() {
		return scored1;
	}
	public void setScored1(int scored1) {
		this.scored1 = scored1;
	}
	public int getReboundsDefensive() {
		return reboundsDefensive;
	}
	public void setReboundsDefensive(int reboundsDefensive) {
		this.reboundsDefensive = reboundsDefensive;
	}
	public int getReboundsOffensive() {
		return reboundsOffensive;
	}
	public void setReboundsOffensive(int reboundsOffensive) {
		this.reboundsOffensive = reboundsOffensive;
	}
	public int getRebounds() {
		return rebounds;
	}
	public void setRebounds(int rebounds) {
		this.rebounds = rebounds;
	}
	public int getPasses() {
		return passes;
	}
	public void setPasses(int passes) {
		this.passes = passes;
	}
	public int getInterceptions() {
		return interceptions;
	}
	public void setInterceptions(int interceptions) {
		this.interceptions = interceptions;
	}
	public int getTurnovers() {
		return turnovers;
	}
	public void setTurnovers(int turnovers) {
		this.turnovers = turnovers;
	}
	public int getBlocks() {
		return blocks;
	}
	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}
	public int getBlocked() {
		return blocked;
	}
	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}
	public int getFouls() {
		return fouls;
	}
	
	public void setFouls(int fouls) {
		this.fouls = fouls;
	}
	public int getFouled() {
		return fouled;
	}
	public void setFouled(int fouled) {
		this.fouled = fouled;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Date getGameDate() {
		return gameDate;
	}
	public void setGameDate(Date gameDate) {
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
	
	public int getShots2Accuracy(){
		Double scored = Double.valueOf(scored2);
		Double shot = Double.valueOf(shots2);
		return (int)(scored/shot*100);
	}
	
	public int getShots3Accuracy(){
		Double scored = Double.valueOf(scored3);
		Double shot = Double.valueOf(shots3);
		return (int)(scored/shot*100);
	}
	
	public int getShots1Accuracy(){
		Double scored = Double.valueOf(scored1);
		Double shot = Double.valueOf(shots1);
		return (int)(scored/shot*100);
	}
	
	@SuppressWarnings("null")
	public List<String> hui() {
		Field[] fields = this.getClass().getFields();
		List<String> fieldList = null;
		for (Field f : fields) {
			fieldList.add(f.getName());
		}
		return fieldList;
	}
	//counts the records to count the average later; the parameters contain the "column" variable representing the stat we are counting
	//if the stat is about shots (1,2,3 pointers) and the number of throws is equal to 0, then we return 0
	//because there's no need to count the game with no throws
	public int getCount(String column) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//if column contains the word "shots"
		if (column.toLowerCase().contains("shots1accuracy")) {
			if (this.getShots1() == 0) {
				return 0;
			}
		}
		if (column.toLowerCase().contains("shots2accuracy")) {
			if (this.getShots2() == 0) {
				return 0;
			}
		}
		if (column.toLowerCase().contains("shots3accuracy")) {
			if (this.getShots3() == 0) {
				return 0;
			}
		}		
		
		return 1;
	}
	
	//checks the gameDate of this object falls into the time frame of the object passed as the parameter
	@SuppressWarnings("deprecation")
	public boolean isInTheTimeframe(TimeFramed timeframe) {
		int tempDate = 0;
		switch (this.getGameDate().getMonth()) {
		case 0: tempDate = 5;
		break;
		case 1: tempDate = 6;
		break;
		case 2: tempDate = 7;
		break;
		case 3: tempDate = 8;
		break;
		case 4: tempDate = 9;
		break;
		case 8: tempDate = 1;
		break;
		case 9: tempDate = 2;
		break;
		case 10: tempDate = 3;
		break;
		case 11: tempDate = 4;
		break;
		}
		if ((tempDate > timeframe.getFromDate()) &&(tempDate < timeframe.getToDate()))
			return true;
		else return false;

	}
}
