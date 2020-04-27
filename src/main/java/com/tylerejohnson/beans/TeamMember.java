package com.tylerejohnson.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*TeamMember Model*/
@Entity
@Table(name = "teammember")
public class TeamMember {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_teamMemberId")
	private long id;
	
	@NotNull
	@Size(max = 100)
	@Column(name = "firstName")
	private String firstName;

	@NotNull
	@Size(max = 100)
	@Column(name = "lastName")
	private String lastName;
	
	@NotNull
	@Email
	@Column(name = "email")
	private String email;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE},
			mappedBy = "teamMembers")
	private Set<Project> projects = new HashSet<>();

	public TeamMember() {
		super();
	}

	public TeamMember(@NotNull @Size(max = 100) String firstName, @NotNull @Size(max = 100) String lastName,
			@NotNull @Email String email, Set<Project> projects) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.projects = projects;
	}

	public TeamMember(long id, @NotNull @Size(max = 100) String firstName,
			@NotNull @Size(max = 100) String lastName, @NotNull @Email String email, Set<Project> projects) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.projects = projects;
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "TeamMember [teamMemberId=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", projects=" + projects + "]";
	}
}
