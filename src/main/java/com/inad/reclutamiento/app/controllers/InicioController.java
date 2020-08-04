/**
 * 
 */
package com.inad.reclutamiento.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
@Controller
public class InicioController {
	
	protected static final Logger logger = LoggerFactory.getLogger(InicioController.class);
	
	@GetMapping(value = {"/", "/index.html"})
	public String inicio(HttpServletRequest request, Model model) {
		model.addAttribute("titulo", "Inicio");
		logger.info("Inicio");
		return "inicio";
	}
}
