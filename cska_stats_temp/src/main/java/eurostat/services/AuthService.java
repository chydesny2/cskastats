package eurostat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eurostat.dto.AuthorityRepository;
import eurostat.entities.Authority;


@Service
public class AuthService {
	@Autowired
	AuthorityRepository AuthRepo;
	
	public void save(Authority authority) {
		AuthRepo.save(authority);
	}
}
