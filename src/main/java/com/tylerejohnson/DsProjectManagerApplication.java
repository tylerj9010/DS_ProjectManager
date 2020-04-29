package com.tylerejohnson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*****************************************************
 * Name: Data Structures Final Project
 * Author: Tyler Johnson
 * Finished: 04/28/2020
 * Version: 1.0
 * OS: Windows 10
 * Copyright: This is my own original work based on
 *              specifications issued by our instructor
 * Description: A project manager that utilizes spring boot to allow users to add projects, tasks, and team members,
 * 				it also has two data structures implemented, a queue and a heap, as well as a sorting algorithm, heap sort.
 * Academic Honesty: I attest that this is my original work.
 *              I have not used unauthorized source code, either modified or
 *              unmodified. I have not given other fellow student(s) access to
 *              my program.
 *****************************************************/

@SpringBootApplication
@EnableJpaAuditing
public class DsProjectManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsProjectManagerApplication.class, args);
	}

	
}


