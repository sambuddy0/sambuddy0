package cs3220.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cs3220.model.UserEntry;
import cs3220.repository.MessageEntryRepository;
import cs3220.repository.UserEntryRepository;

@Controller
public class IndexController {
	public final UserEntryRepository userRepo;
	public final MessageEntryRepository messageRepo;
	
	
	public IndexController(UserEntryRepository userRepo, MessageEntryRepository messageRepo) {
		this.userRepo = userRepo;
		this.messageRepo = messageRepo;
	}
	
	@RequestMapping("/")
	public String index(Model model, @ModelAttribute("users") UserEntry user) {
		return "index";
	}
}
