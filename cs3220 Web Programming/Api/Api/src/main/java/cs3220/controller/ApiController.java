package cs3220.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import cs3220.dto.MessageEntryDto;
import cs3220.dto.UserEntryDto;
import cs3220.model.MessageEntry;
import cs3220.model.UserEntry;
import cs3220.repository.MessageEntryRepository;
import cs3220.repository.UserEntryRepository;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	private final UserEntryRepository userRepo;
	private final MessageEntryRepository messageRepo;
	
	public ApiController(UserEntryRepository userRepo ,MessageEntryRepository messageRepo) {
		this.userRepo = userRepo;
		this.messageRepo = messageRepo;
	}
	
	@GetMapping("/usersDto")
	public Iterable<UserEntryDto> getEmployeeDto() {
		List<UserEntryDto> users = new ArrayList<UserEntryDto>();
		for (UserEntry user : userRepo.findAll()) {
			users.add(new UserEntryDto(user));
		}
		return users;
	}
	
	@GetMapping("/messagesDto")
	public Iterable<MessageEntryDto> getMessageDto(){
		List<MessageEntryDto> messages = new ArrayList<MessageEntryDto>();
		for(MessageEntry message : messageRepo.findAll()) {
			messages.add(new MessageEntryDto(message));
		}
		if(messages.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Please fill out all fields");			
		}
		return messages;
	}
	
	@GetMapping("/getUserById/{id}")
	public UserEntryDto getUserById(@PathVariable int id) {
		UserEntry tempUser = userRepo.findById(id).orElse(null);
		UserEntryDto user = new UserEntryDto(tempUser);
		return user;
	}
	
	@GetMapping("/getMessageById/{id}")
	public MessageEntry getMessageById(@PathVariable int id) {
		MessageEntry message = messageRepo.findById(id).orElse(null);
		return message;
	}
	
	@PostMapping("/validateUser")
	public Integer loginValidation(@RequestBody UserEntryDto userEntry) {
		if(userEntry.getEmail().isBlank() || userEntry.getPassword().isBlank()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Please fill out all fields");
		}
		Integer userId = null;
		List<UserEntry> users = userRepo.findByEmail(userEntry.getEmail());
		if(!users.isEmpty()) {
			UserEntry user = users.get(0);
			if(user.getPassword().equals(userEntry.getPassword())) {
				userId = user.getId();
			}else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Incorrect Email or Password");
			}
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Incorrect Email or Password");
		}
		return userId;	
	}
	
	@PostMapping("/registerUser")
	@ResponseStatus(HttpStatus.CREATED)
	public Integer registerUser(@RequestBody UserEntryDto newUser) {
		Integer userId = null;
		if(!newUser.getEmail().isBlank() && !newUser.getName().isBlank() && !newUser.getPassword().isBlank()) {
			List<UserEntry> users = userRepo.findByEmail(newUser.getEmail());
			if(users.isEmpty()) {
				UserEntry user = userRepo.save(newUser.newUser());
				userId = user.getId();
			}else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User already exists!");
			}
		}else {			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Please fill out all fields!");
		}
		return userId;
	}
	
	@PostMapping("/addMessage")
	@ResponseStatus(HttpStatus.CREATED)
	public Integer addMessage(@RequestBody MessageEntryDto newMessage) {
		MessageEntry message = messageRepo.save(newMessage.newMessage());
		return message.getUser().getId();
	}
	
	@PatchMapping("/editMessage/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editMessage(@PathVariable int id, @RequestBody Map<String, Object> updateMessage) {
		MessageEntry message = messageRepo.findById(id).orElse(null);
		if(message == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found");
		}else{
			String newMessage = (String) updateMessage.get("message");
			message.setMessage(newMessage);
			message.setDate(LocalDate.now());
			messageRepo.save(message);
		}
	}
	
	@DeleteMapping("/deleteMessage/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMessage(@PathVariable int id) {
		//if(updateMessage.get("userId") == message.getUser().getId()) {
		MessageEntry message = messageRepo.findById(id).orElse(null);
		messageRepo.delete(message);
	}
}
