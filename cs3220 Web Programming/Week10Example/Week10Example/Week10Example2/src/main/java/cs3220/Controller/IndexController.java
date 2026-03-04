package cs3220.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cs3220.DataComponent;
import cs3220.model.GuestBookEntry;

@Controller
public class IndexController {
	
	private DataComponent dataComponent;
	
	public IndexController(DataComponent dataComponent) {
		this.dataComponent = dataComponent;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("dataComponent", dataComponent.getEntries());
		return "index";
	}
	
	@GetMapping("/add")
	public String add() {
		return "add";
	}
	
	@PostMapping("/add")
	public String add(String name, String message) {
		dataComponent.getEntries().add(new GuestBookEntry(name, message));
		return "redirect:/";
	}
	
	@GetMapping("/add2")
	public String add2() {
		return "add";
	}
	
	@PostMapping("/add2")
	public String add2(GuestBookEntry entry) {
		dataComponent.getEntries().add(entry);
		return "redirect:/";
	}
	
	@GetMapping("/edit")
	public String edit(int id, Model model) {
		model.addAttribute("entry", dataComponent.getEntryById(id));
		return "edit";
	}
	
	@PostMapping("/edit")
	public String edit(int id, GuestBookEntry updatedEntry) {
		GuestBookEntry entry = dataComponent.getEntryById(id);
		entry.setName(updatedEntry.getName());
		entry.setMessage(updatedEntry.getMessage());
		return "redirect:/";
	}
	
	@GetMapping("/edit2/{id}")
	public String edit2(@PathVariable int id, Model model) {
		model.addAttribute("entry", dataComponent.getEntryById(id));
		return "edit";
	}
	
	@PostMapping("/edit2/{id}")
	public String edit2(@PathVariable int id, GuestBookEntry updatedEntry) {
		GuestBookEntry entry = dataComponent.getEntryById(id);
		entry.setName(updatedEntry.getName());
		entry.setMessage(updatedEntry.getMessage());
		return "redirect:/";
	}
	
	@GetMapping("/edit3/{id}")
	public String edit3(@PathVariable int id, Model model) {
		model.addAttribute("entry", dataComponent.getEntryById(id));
		return "edit3";
	}
	
	@PostMapping("/edit3/{id}")
	public String edit3(@PathVariable int id, GuestBookEntry updatedEntry) {
		GuestBookEntry entry = dataComponent.getEntryById(id);
		entry.setName(updatedEntry.getName());
		entry.setMessage(updatedEntry.getMessage());
		return "redirect:/";
	}
}
