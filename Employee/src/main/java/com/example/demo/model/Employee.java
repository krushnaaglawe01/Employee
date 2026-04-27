package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	private Integer id;
	private String name;
	private Float salary;
	@NotNull
	@Pattern(regexp = "^[6-9][0-9]{9}",message="invlid")
	private String mob;
}
