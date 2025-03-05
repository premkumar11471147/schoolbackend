package com.psr.springrestsample.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "class", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"class_name", "class_section"})
})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClassModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "class_id", nullable = false)
	private Long classId;  // Primary Key

	@Column(name = "class_name", nullable = false)
	private String className;

	@Column(name = "class_section", nullable = false)
	private String classSection;


}
