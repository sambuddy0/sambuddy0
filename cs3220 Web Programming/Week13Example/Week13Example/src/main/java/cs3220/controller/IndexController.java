package cs3220.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cs3220.model.Employee;
import cs3220.model.GuestBookEntry;
import cs3220.model.Project;
import cs3220.repository.GuestBookEntryRepository;
import cs3220.repository.ProjectRepository;
import jakarta.validation.Valid;

@Controller
public class IndexController {
	
	private final GuestBookEntryRepository guestBookEntryRepository;
	private final ProjectRepository projectRepository;
	
	public IndexController(GuestBookEntryRepository guestBookEntryRepository, ProjectRepository projectRepository) {
		this.guestBookEntryRepository = guestBookEntryRepository;
		this.projectRepository = projectRepository;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("guestBookEntries", this.guestBookEntryRepository.findAll());
//		model.addAttribute("guestBookEntries", this.guestBookEntryRepository.findByName("Tom"));
//		model.addAttribute("guestBookEntries", this.guestBookEntryRepository.getEntriesSince(LocalDate.now().minusDays(7)));
//		model.addAttribute("guestBookEntries", this.guestBookEntryRepository.getEntriesSinceNativeQuery(LocalDate.now().minusDays(7)));
		return "index";
	}
	
	@GetMapping("/add")
	public String add() {
		return "add";
	}
	
	@PostMapping("/add")
	public String add(@Valid @ModelAttribute("entry") GuestBookEntry entry, BindingResult result) {
		if (result.hasErrors()) {
			return "add";
		}
		
		this.guestBookEntryRepository.save(entry);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("entry", this.guestBookEntryRepository.findById(id));
		return "edit";
	}
	
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable int id, @Valid @ModelAttribute("entry") GuestBookEntry updatedEntry, BindingResult result) {
		if (result.hasErrors()) {
			return "edit";
		}
		GuestBookEntry entry = this.guestBookEntryRepository.findById(id).orElse(null);
		entry.setName(updatedEntry.getName());
		entry.setMessage(updatedEntry.getMessage());
		this.guestBookEntryRepository.save(entry);
		return "redirect:/";
	}
	
	@GetMapping("/project/{id}")
	public String project(@PathVariable int id, Model model) {
		model.addAttribute("project", this.projectRepository.findById(id).orElse(null));
		return "project";
	}
	
	@GetMapping("project/{id}/addmember")
	public String addMember(@PathVariable int id) {
		Employee employee = new Employee();
		employee.setFirstName("Tom");
		employee.setLastName("Smith");
		Project project = this.projectRepository.findById(id).orElse(null);
		project.getMembers().add(employee);
		this.projectRepository.save(project);
		return "redirect:/project/"+id;
	}
}
