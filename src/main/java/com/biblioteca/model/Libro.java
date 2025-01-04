package com.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_libros")
@Data
public class Libro {
	@Id
	  private int idlibro;
	  private String titulo;
	  private String autor; 
	  private int idcategoria; 
	  private int ideditorial; 
	  private int disponibilidad;
	    
	  @ManyToOne
		@JoinColumn(name = "idcategoria", insertable = false, updatable = false)
		private Categoria objCategoria;
	  
	  @ManyToOne
		@JoinColumn(name = "ideditorial", insertable = false, updatable = false)
		private Editorial objEditorial;
	  

}
