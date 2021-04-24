package eurostat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import eurostat.dao.PlayerStatDate;
import eurostat.dto.PlayerStatDateRepository;

@Service
public class PlayerStatDateService {
	
	
	
	@Autowired
	public PlayerStatDateRepository pRepo;
	
	public List<PlayerStatDate> findByUserName(String userName)
	{
		return pRepo.findByUserName(userName);
	}
	
	
	public PlayerStatDate findByPlayerStatDateId(long playerStatDateId)
	{
		return pRepo.findByPlayerStatDateId(playerStatDateId);
	}
	
	public PlayerStatDate save(PlayerStatDate infoCommited)
	{
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		infoCommited.setUserName(loggedInUser.getName());
		if ((infoCommited.getPlayerStatDateName().length() > 0) && (!infoCommited.getUserName().equals("anonymousUser"))) {
			pRepo.save(infoCommited);
		}
		return infoCommited;
	}
	
}
