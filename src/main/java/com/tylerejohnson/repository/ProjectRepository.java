package com.tylerejohnson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tylerejohnson.beans.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
