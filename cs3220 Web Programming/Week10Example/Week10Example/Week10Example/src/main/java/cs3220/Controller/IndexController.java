package cs3220.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cs3220.DataComponent;
import cs3220.model.GuestBookEntry;

@Controller
public class IndexController {
	
	@Autowired // Injecting the Data Component @Bean
	private DataComponent dataComponent;
	@Autowired // Injecting the Data Configuration @Bean
	private List<GuestBookEntry> dataConfiguration;
	
	// Example of using Constructor Injection
	private List<GuestBookEntry> constructorInjection;
	
	public IndexController(List<GuestBookEntry> entries) {
		this.constructorInjection = entries;
	}

	// public IndexController(List<GuestBookEntry> entries2) {
	// 	this.constructorInjection = entries2;
	// }
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("dataComponent", dataComponent.getEntries());
		model.addAttribute("dataConfiguration", dataConfiguration);
		model.addAttribute("constructorInjection", constructorInjection);
		return "index";
	}
}
