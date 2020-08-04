/**
 * 
 */
package com.inad.reclutamiento.app.controllers.login;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@GetMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes flash) {
		model.addAttribute("titulo","Login");
		
		if(logout != null) {
			logger.info("logout");
			model.addAttribute("success", "Ha cerrado sesión con éxito!");
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	       if (auth != null){
	           new SecurityContextLogoutHandler().logout(request, response, auth);
	       }
	       return "redirect:/";	       
		} else if (principal != null) {
			logger.info("principal");
			flash.addFlashAttribute("info", "Ya ha iniciado Sesión");
			return "redirect:/";
		} else if (error != null) {
			logger.info("Error");
			model.addAttribute("error", "Usuario o Contraseña incorrecta!");
		}
		
		return "/login";
	}
	
}
