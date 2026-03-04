package cs3220.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
@Entity
public class UserEntry {
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank (message = "Email is required")
	private String email;
	private String name;
	@NotBlank (message = "Password is required")
	private String password;
	@OneToMany(mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<MessageEntry> messages;
	
	public UserEntry(){}
	
	public UserEntry(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<MessageEntry> getMessages() {
		return messages;
	}
	
	public void setMessages(List<MessageEntry> messages) {
        this.messages = messages;
    }
}
