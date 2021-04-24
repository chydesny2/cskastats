package eurostat.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoder {

	@Bean
	public BCryptPasswordEncoder getEncoder() {
		BCryptPasswordEncoder bEncoder = new BCryptPasswordEncoder();
		return bEncoder;
	}
}
