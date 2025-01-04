package com.biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_usuarios")
@Data
public class Usuario {
	@Id
	 private int idusuario;
	 private String nombre;
	 private String direccion; 
	 private String  telefono;
	 @Column(name="corr_usu")
	 private String  correo;
	 @Column(name="contra_usu")
	 private String  contraseña;

}
