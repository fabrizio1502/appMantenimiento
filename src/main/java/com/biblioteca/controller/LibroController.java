package com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biblioteca.model.Editorial;
import com.biblioteca.model.Libro;
import com.biblioteca.model.Prestamo;
import com.biblioteca.repository.ICategoriaRepository;
import com.biblioteca.repository.IEditorialRepository;
import com.biblioteca.repository.ILibroRepository;
import com.biblioteca.repository.IPrestamoRepository;
import com.biblioteca.repository.IUsuarioRepository;

@Controller
public class LibroController {
	
	@Autowired
	private ICategoriaRepository repoCat;
	
	@Autowired
	private IEditorialRepository repoEdit;
	

	//controlador para abrir principal
		@GetMapping("/")
		public String abriPagPrincipal() {
			return "inicio";
		}

	
		
		
		
		//------------------------------LIBRO
		
		//controlador para abrir la pag libro
		@GetMapping("/cargarLibro")
		public String abrirPagLibro(Model model) {
			model.addAttribute("lstCategorias", repoCat.findAll());
			model.addAttribute("lstEditoriales", repoEdit.findAll());
			model.addAttribute("libro", new Libro());
			model.addAttribute("boton", "Registrar");
			return "paglibro";
		}
		
		
		@Autowired
		private ILibroRepository repoLibro;
		
		//controlador para listar

		@GetMapping("/listadoLibro")
		public String muestraListado1(Model model) {
			model.addAttribute("lstLibros", repoLibro.findAll());
			model.addAttribute("lstCategorias", repoCat.findAll());
			model.addAttribute("lstEditoriales", repoEdit.findAll());
			model.addAttribute("libro", new Libro());
	        model.addAttribute("boton","Registrar");
			return "paglibro";
			}
		
		
		//controlador para grabar
		@PostMapping("/libros/guardarLibro")
		public String grabarLibros(@ModelAttribute Libro libro, Model model) {
			try {
				repoLibro.save(libro); 
				model.addAttribute("mensaje","Registro OK");
				model.addAttribute("clase","alert alert-success");
			}catch (Exception e) {
				model.addAttribute("mensaje","Error al registrar");
				model.addAttribute("clase","alert alert-danger");
			}
			return "paglibro";
		}
		
		//CONTROLADOR PARA buscar un libro a editar
		@PostMapping("/buscarLibro")
		public String buscarLibro(@RequestParam(name = "idlibro") int idlibro, Model model) {
			System.out.println(idlibro);
			
			model.addAttribute("libro", repoLibro.findById(idlibro));
			model.addAttribute("lstCategorias", repoCat.findAll()); 
			model.addAttribute("lstEditoriales", repoEdit.findAll()); 
			model.addAttribute("boton", "Actualizar");
			
			return "paglibro";
		}
		
		// Controlador para eliminar un libro
		@PostMapping("/eliminarLibro")
		public String eliminarLibro(@RequestParam(name = "idlibro") int idlibro, Model model) {
		    try {
		        repoLibro.deleteById(idlibro);
		        model.addAttribute("mensaje", "Libro eliminado correctamente");
		        model.addAttribute("clase", "alert alert-success");
		    } catch (Exception e) {
		        model.addAttribute("mensaje", "Error al eliminar el libro");
		        model.addAttribute("clase", "alert alert-danger");
		    }
		    return "redirect:/listadoLibro";
		}
		


		
		//------------------------------PRESTAMO

		@Autowired
		private IUsuarioRepository repoUsu;
		//controlador para abrir la pag prestamo
		@GetMapping("/cargarPrestamo")
		public String abrirPagPrestamo(Model model) {
			model.addAttribute("lstLibros", repoLibro.findAll());
			model.addAttribute("lstUsuarios", repoUsu.findAll());
			model.addAttribute("prestamo", new Prestamo());
			model.addAttribute("boton", "Registrar");
			return "pagprestamo";
		}
		
		
		

		@Autowired
		private IPrestamoRepository repoPrest;
		
		//controlador para listar

		@GetMapping("/listadoPrestamo")
		public String muestraListado2(Model model) {
			model.addAttribute("lstPrestamos", repoPrest.findAll());
			model.addAttribute("lstLibros", repoLibro.findAll());
			model.addAttribute("lstUsuarios", repoUsu.findAll());
			model.addAttribute("prestamo", new Prestamo());
	        model.addAttribute("boton","Registrar");
			return "pagprestamo";
			}

		//controlador para grabar
		@PostMapping("/prestamos/guardarPrestamo")
		public String grabarPrestamo(@ModelAttribute Prestamo prestamo, Model model) {
			try {
				repoPrest.save(prestamo); 
				model.addAttribute("mensaje","Registro OK");
				model.addAttribute("clase","alert alert-success");
			}catch (Exception e) {
				model.addAttribute("mensaje","Error al registrar");
				model.addAttribute("clase","alert alert-danger");
			}
			return "pagprestamo";
		}
		
		//CONTROLADOR PARA buscar un prestamo a editar
		@PostMapping("/buscarPrestamo")
		public String buscarPrestamo(@RequestParam(name = "idprestamo") int idprestamo, Model model) {
			System.out.println(idprestamo);
			
			model.addAttribute("prestamo", repoPrest.findById(idprestamo));
			model.addAttribute("lstLibros", repoLibro.findAll()); 
			model.addAttribute("lstUsuarios", repoUsu.findAll()); 
			model.addAttribute("boton", "Actualizar");				
			return "pagprestamo";
		}		
		
		// Controlador para eliminar un libro
		@PostMapping("/eliminarPrestamo")
		public String eliminarPrestamo(@RequestParam(name = "idprestamo") int idprestamo, Model model) {
			try {
		        repoPrest.deleteById(idprestamo);
		        model.addAttribute("mensaje", "Prestamo eliminado correctamente");
		        model.addAttribute("clase", "alert alert-success");
		    } catch (Exception e) {
		        model.addAttribute("mensaje", "Error al eliminar el Prestamo");
		        model.addAttribute("clase", "alert alert-danger");
		    }
		    return "redirect:/listadoPrestamo";
		}

	

		
		//------------------------------EDITORIAL
		//controlador para abrir la pag editorial
				@GetMapping("/cargarEditorial")
				public String abrirPagEditorial(Model model) {
					model.addAttribute("lstEditoriales", repoEdit.findAll());
					model.addAttribute("editorial", new Editorial());
					model.addAttribute("boton", "Registrar");
					return "pageditorial";
				}
				

				@GetMapping("/listadoEditorial")
				public String muestraListado3(Model model) {
					model.addAttribute("lstEditoriales", repoEdit.findAll());
					model.addAttribute("editorial", new Editorial());
			        model.addAttribute("boton","Registrar");
					return "pageditorial";
					}
				
				@PostMapping("/editoriales/guardarEditorial")
				public String grabarEditorial(@ModelAttribute Editorial editorial, Model model) {
					try {
						repoEdit.save(editorial); 
						model.addAttribute("mensaje","Registro OK");
						model.addAttribute("clase","alert alert-success");
					}catch (Exception e) {
						model.addAttribute("mensaje","Error al registrar");
						model.addAttribute("clase","alert alert-danger");
					}
					return "pageditorial";
				}
				
				//CONTROLADOR PARA buscar una editorial a editar
				@PostMapping("/buscarEditorial")
				public String buscarEditorial(@RequestParam(name = "ideditorial") int ideditorial, Model model) {
					System.out.println(ideditorial);				
					model.addAttribute("editorial", repoEdit.findById(ideditorial));		
					model.addAttribute("boton", "Actualizar");				
					return "pageditorial";
				}	
				
		//--------------------------DISPONIBILIDAD
				@GetMapping("/reporteDispo")
				public String abrirPagDispo(Model model) {
					// enviar un "listado" para el combo
					// model.addAttribute("mensaje", "Éxito");
					model.addAttribute("lstCategorias", repoCat.findAll());
					model.addAttribute("lstEditoriales", repoEdit.findAll()); 
					// obj de tipo Producto para guardar los datos
					model.addAttribute("libro", new Libro());
					model.addAttribute("boton", "Reporte");
					return "disponibilidad";
				}
				
				
				
				
			
}
