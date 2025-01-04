package com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.biblioteca.model.Usuario;
import com.biblioteca.repository.IUsuarioRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProyectoController {
	
	@GetMapping("/logout")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@Autowired
	private IUsuarioRepository repoUsu;
	
	@PostMapping("/login")
	public String acceso(@ModelAttribute Usuario usuario, Model model, HttpSession session) {
	    Usuario u = repoUsu.findByCorreoAndContraseña(usuario.getCorreo(), usuario.getContraseña());
	    if (u != null) {
	        session.setAttribute("usuario", u); // Almacenar el usuario en la sesión
	        return "inicio";
	    } else {
	        model.addAttribute("mensaje", "Usuario o contraseña incorrecto");
	        model.addAttribute("clase", "alert alert-danger");
	        return "login";
	    }
	}

	/*@PostMapping("/login")
	public String acceso(@ModelAttribute Usuario usuario, Model model) {
		System.out.println(usuario);
        Usuario u = repoUsu.findByCorreoAndContraseña(usuario.getCorreo(), usuario.getContraseña());
        if (u != null) {
			return "inicio";
		} else {
			model.addAttribute("mensaje","Usuario o contraseña incorrecto");
			model.addAttribute("clase","alert alert-danger");
			return "login";
	}*/
	
     // Controlador para abrir la página de registro
        @GetMapping("/registro")
        public String abrirPagRegistro(Model model) {
            model.addAttribute("usuario", new Usuario());
            return "pagregistro";
        }
        
        // Controlador para procesar el registro de usuarios
        @PostMapping("/guardarUsuario")
        public String guardarUsuario(@ModelAttribute Usuario usuario, Model model) {
            try {
                repoUsu.save(usuario);
                model.addAttribute("mensajeRegistro", "Registro exitoso");
            } catch (Exception e) {
                model.addAttribute("mensajeRegistro", "Error al registrar el usuario");
            }
            return "inicio";

	}
}
