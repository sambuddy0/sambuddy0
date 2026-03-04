package cs3220.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cs3220.DataComponent;
import cs3220.model.GuestBookEntry;
import jakarta.validation.Valid;

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
	public String add(GuestBookEntry entry) {
		dataComponent.getEntries().add(entry);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("entry", dataComponent.getEntryById(id));
		return "edit";
	}
	
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable int id, @Valid @ModelAttribute("entry") GuestBookEntry updatedEntry, BindingResult result) {
		if (result.hasErrors()) {
			return "edit";
		}
		GuestBookEntry entry = dataComponent.getEntryById(id);
		entry.setName(updatedEntry.getName());
		entry.setMessage(updatedEntry.getMessage());
		return "redirect:/";
	}
}
