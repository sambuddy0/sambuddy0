package cs3220.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cs3220.model.GuestBookEntry;

@Controller
public class IndexController {
	private List<GuestBookEntry> entries;
	private List<String> users;
	
	public IndexController() {
		entries = new ArrayList<GuestBookEntry>();
		entries.add(new GuestBookEntry("John", "Hello"));
		entries.add(new GuestBookEntry("Jane", "Hello Again"));
		
		users = new ArrayList<String>();
		users.add("John");
		users.add("Jane");
		users.add("Tom");
		users.add("Steve");
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("firstName", "John");
		model.addAttribute("lastName", "Smith");
		model.addAttribute("entries", entries);
		model.addAttribute("users", users);
		return "index";
	}
	
	@GetMapping("/add")
	public String add() {
		return "add";
	}
	
	@PostMapping("/add")
	public String result(int a, int b, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("sum", a+b);
		return "result";
	}
}
