package cs3220.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="projects")
public class Project {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@ManyToOne
	private Employee leader;
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="project_members", inverseJoinColumns=@JoinColumn(name="member_id"))
	private List<Employee> members;
	
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
	public Employee getLeader() {
		return leader;
	}
	public void setLeader(Employee leader) {
		this.leader = leader;
	}
	public List<Employee> getMembers() {
		return members;
	}
	public void setMembers(List<Employee> members) {
		this.members = members;
	}
}
