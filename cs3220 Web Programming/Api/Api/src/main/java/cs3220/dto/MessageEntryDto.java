package cs3220.dto;

import java.time.LocalDate;

import cs3220.model.MessageEntry;
import cs3220.model.UserEntry;

public class MessageEntryDto {
	private Integer id;
	private String userName;
	private String message;
	private LocalDate date;
	private Integer userId;
	
	public MessageEntryDto() {}
	
	public MessageEntryDto(MessageEntry messageEntry) {
		id = messageEntry.getId();
		userName = messageEntry.getUserName();
		message = messageEntry.getMessage();
		date = messageEntry.getDate();
		userId = messageEntry.getUser().getId();
	}
	
	public MessageEntry newMessage() {
		MessageEntry newMessageEntry = new MessageEntry();
		newMessageEntry.setId(id);
		newMessageEntry.setMessage(message);
		newMessageEntry.setDate(LocalDate.now());
		newMessageEntry.setUser(new UserEntry());  // Why create a new object?
		newMessageEntry.getUser().setId(userId);
		newMessageEntry.setUserName(userName);
		return newMessageEntry;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
