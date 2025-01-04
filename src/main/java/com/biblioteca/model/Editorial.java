package com.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_editoriales")
@Data
public class Editorial {
	@Id
	private int ideditorial;
	private String  nombre_ed;
}
