package eurostat.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eurostat.dto.GameConvertedRepository;
import eurostat.entities.GameConverted;

@RestController
@RequestMapping("/api")
public class PlayerApiController {
	
	@Autowired
	GameConvertedRepository GRepo;
	
	@GetMapping("/all")
	public List<GameConverted> getEverything() {
		return GRepo.findAll();
	}
}
