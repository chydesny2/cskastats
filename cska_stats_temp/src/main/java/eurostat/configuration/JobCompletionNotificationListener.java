package eurostat.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import eurostat.entities.GameConverted;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

  private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void afterJob(JobExecution jobExecution) {
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("!!! JOB FINISHED! Time to verify the results");

      jdbcTemplate.query("SELECT player_name, time_played, score, shots2, scored2, shots3, scored3, shots1, scored1, rebounds_defensive, "
      		+ "rebounds_offensive, rebounds, passes, interceptions, turnovers, blocks, blocked, fouls, fouled, index, "
      		+ "game_date, team, rival, home FROM GameConverted",
        (rs, row) -> new GameConverted(
          rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), 
          rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16), rs.getInt(17),
          rs.getInt(18), rs.getInt(19), rs.getInt(20), rs.getDate(21), rs.getString(22), rs.getString(23), rs.getString(24))
      ).forEach(convertedGame -> log.info("Found <" + convertedGame + "> in the database."));
    }
  }
}
