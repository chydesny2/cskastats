package eurostat.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import eurostat.entities.Game;
import eurostat.entities.GameConverted;
import eurostat.processors.GameItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
		
	@Autowired
	public DataSource dataSource;
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	  
	@Bean
	public FlatFileItemReader<Game> reader() {
		return new FlatFileItemReaderBuilder<Game>()
	      .name("gameItemReader")
	      .resource(new ClassPathResource("cska.csv"))
	      .delimited()
	      .names(new String[]{"playerName", "timePlayed", "score",
		    		"shots2", "shots3", "shots1",
		    		"reboundsOffensive", "reboundsDefensive", "rebounds", 
		    		"passes", "interceptions", "turnovers",
		    		"blocks", "blocked", "fouls", "fouled", 
		    		"index", "gameDate", "team", "rival", "home"})
	      .fieldSetMapper(new BeanWrapperFieldSetMapper<Game>() {{
	        setTargetType(Game.class);
	      }})
	      .build();
	  }
	  
	  @Bean
	  public GameItemProcessor processor() {
	    return new GameItemProcessor();
	  }
	  
	  @Bean
	  public JdbcBatchItemWriter<GameConverted> writer(DataSource dataSource) {
	    return new JdbcBatchItemWriterBuilder<GameConverted>()
	      .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	      .sql("INSERT INTO GameConverted (player_name, time_played, score, " + 
	      		"shots2, scored2, shots3, " + 
	      		"scored3, shots1, scored1, " + 
	      		"rebounds_offensive, rebounds_defensive, rebounds, " + 
	      		"passes, interceptions, turnovers, " + 
	      		"blocks, blocked, fouls, fouled, " + 
	      		"index, game_date, team, rival, home) SELECT :playerName, :timePlayed, :score, :shots2, :scored2, :shots3, :scored3, :shots1, :scored1, "
	      		+ ":reboundsOffensive, :reboundsDefensive, :rebounds, :passes, :interceptions, :turnovers, :blocks, :blocked, :fouls, :fouled, :index, :gameDate, :team, :rival, :home "
	      		+ "WHERE NOT EXISTS (SELECT 1 FROM GameConverted WHERE ((player_name = :playerName) AND (game_date = :gameDate))) ")
	      .dataSource(dataSource)
	      .build();
	  }
	  
	  @Bean
	  public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
	    return jobBuilderFactory.get("importUserJob")
	      .incrementer(new RunIdIncrementer())
	      .listener(listener)
	      .flow(step1)
	      .end()
	      .build();
	  }
	  
	  @Bean
	  public Step step1(JdbcBatchItemWriter<GameConverted> writer) {
		final JdbcBatchItemWriter<GameConverted> writer_temp = writer;
		writer_temp.setAssertUpdates(false);
	    return stepBuilderFactory.get("step1")
	      .<Game, GameConverted> chunk(100)
	      .reader(reader())
	      .processor(processor())
	      .writer(writer_temp)
	      .build();
	  }
	  
	  @Bean
	  public String func() {
		  return "time_played";
	  }
}
