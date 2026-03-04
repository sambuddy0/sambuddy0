package cs3220.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class GuestBookEntry {
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank(message = "Name is required")
	private String name;
	@NotBlank
	private String message;
	private LocalDate date;
	
	public GuestBookEntry() {
		this.date = LocalDate.now();
	}
	
	public GuestBookEntry(String name, String message) {
		this.name = name;
		this.message = message;
		this.date = LocalDate.now();
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
