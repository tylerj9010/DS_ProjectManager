package com.tylerejohnson.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/*Project Model*/
@SuppressWarnings("serial")
@Entity
@Table(name = "project")
public class Project extends AuditModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_projectId")
	private long projectId;
	
	@NotNull
	@Size(max = 100)
	@Column(name = "projectName")
	private String name;
	
	@NotNull
	@Size(max = 600)
	@Column(name = "projectDescription")
	private String description;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dateTarget")
	private Date dateTarget;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dateFinished")
	private Date dateFinished;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "FK_teamManagerId", nullable = false)
	private TeamMember teamManager;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "projectmemberbridge",
			joinColumns = { @JoinColumn(name = "PK_projectId") },
			inverseJoinColumns = { @JoinColumn(name = "PK_teamMemberId")})
	private Set<TeamMember> teamMembers = new HashSet<>();
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Task> tasks = new ArrayList<>();

	public Project() {
		super();
	}

	public Project(@NotNull @Size(max = 100) String name, @NotNull @Size(max = 600) String description,
			 @NotNull Date dateTarget, @NotNull Date dateFinished, TeamMember teamManager,
			Set<TeamMember> teamMembers) {
		super();
		this.name = name;
		this.description = description;

		this.dateTarget = dateTarget;
		this.dateFinished = dateFinished;
		this.teamManager = teamManager;
		this.teamMembers = teamMembers;
	}

	public Project(long projectId, @NotNull @Size(max = 100) String name, @NotNull @Size(max = 600) String description,
			 @NotNull Date dateTarget, @NotNull Date dateFinished, TeamMember teamManager,
			Set<TeamMember> teamMembers) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.description = description;

		this.dateTarget = dateTarget;
		this.dateFinished = dateFinished;
		this.teamManager = teamManager;
		this.teamMembers = teamMembers;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
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


	public Date getDateTarget() {
		return dateTarget;
	}

	public void setDateTarget(Date dateTarget) {
		this.dateTarget = dateTarget;
	}

	public Date getDateFinished() {
		return dateFinished;
	}

	public void setDateFinished(Date dateFinished) {
		this.dateFinished = dateFinished;
	}

	public TeamMember getTeamManager() {
		return teamManager;
	}

	public void setTeamManager(TeamMember teamManager) {
		this.teamManager = teamManager;
	}

	public Set<TeamMember> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(Set<TeamMember> teamMembers) {
		this.teamMembers = teamMembers;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", description=" + description + ", dateCreated="
				+ ", dateTarget=" + dateTarget + ", dateFinished=" + dateFinished + ", teamManager="
				+ teamManager + ", teamMembers=" + teamMembers + "]";
	}
}
