package com.tylerejohnson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tylerejohnson.beans.TeamMember;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long>{

}
