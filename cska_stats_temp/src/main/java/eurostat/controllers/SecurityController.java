package eurostat.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import eurostat.dto.AuthorityRepository;
import eurostat.dto.UserAccountRepository;
import eurostat.entities.Authority;
import eurostat.entities.UserAccount;
import eurostat.services.AuthService;
import eurostat.services.UserAccountService;

@Controller
public class SecurityController {

	@Autowired
	BCryptPasswordEncoder BEncoder;
	
	@Autowired
	AuthService authService;
	
	@Autowired
	UserAccountService uService;
	
	@GetMapping("/register")
	public String registerUser(Model model) {
		model.addAttribute("newUser", new UserAccount());
		return "register";
	}
	
	@PostMapping("/register/save") 
	public String saveUser(Model model, @Valid UserAccount newUser, Errors errors) {
		if (errors.hasErrors()) {
			return "redirect:/register";
		}
		newUser.setPassword(BEncoder.encode(newUser.getPassword()));
		uService.save(newUser);
		authService.save(new Authority(newUser.getUserName(), "USER"));
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
}
