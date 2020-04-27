package com.tylerejohnson.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/*Task model*/
@Entity
@Table(name = "task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_taskId")
	private long id;
	
	@NotNull
	@Size(max = 100)
	@Column(name = "taskName")
	private String name;
	
	@NotNull
	@Size(max = 600)
	@Column(name = "taskDescription")
	private String description;

	@NotNull
	@Size(max = 100)
	@Column(name = "taskPriority")
	private String priority;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "targetDate")
	private Date targetDate;
	
	@ManyToOne
	@JoinColumn(name = "FK_projectId", nullable = false)
	private Project project;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "FK_teamMemberId", nullable = false)
	private TeamMember teamMember;
	
	public Task() {
	}
	
	public Task(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Task(@NotNull @Size(max = 100) String name, @NotNull @Size(max = 600) String description,
			@NotNull @Size(max = 100) String priority, @NotNull Date dateTarget, Project project,
			TeamMember teamMember) {
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.targetDate = dateTarget;
		this.project = project;
		this.teamMember = teamMember;
	}

	public Task(long id, @NotNull @Size(max = 100) String name, @NotNull @Size(max = 600) String description,
			@NotNull @Size(max = 100) String priority, @NotNull Date dateTarget, Project project,
			TeamMember teamMember) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.targetDate = dateTarget;
		this.project = project;
		this.teamMember = teamMember;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date dateTarget) {
		this.targetDate = dateTarget;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public TeamMember getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(TeamMember teamMember) {
		this.teamMember = teamMember;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", priority=" + priority
				+ ", dateTarget=" + targetDate + ", project=" + project + ", teamMember=" + teamMember + "]";
	}
}
