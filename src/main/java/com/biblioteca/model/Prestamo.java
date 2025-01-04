package com.biblioteca.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_prestamos")
@Data
public class Prestamo {
	@Id
	  private int idprestamo;
	  private int idlibro;
	  private int idusuario;
	  private String fecha_prestamo;
	  private String fecha_devolucion;
	  
	  @ManyToOne
		@JoinColumn(name = "idlibro", insertable = false, updatable = false)
		private Libro objLibro;

	  @ManyToOne
		@JoinColumn(name = "idusuario", insertable = false, updatable = false)
		private Usuario objUsuario;
}
