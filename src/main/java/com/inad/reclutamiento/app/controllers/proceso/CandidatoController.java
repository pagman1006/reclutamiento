/**
 * 
 */
package com.inad.reclutamiento.app.controllers.proceso;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inad.reclutamiento.app.api.service.CandidatoService;
import com.inad.reclutamiento.app.api.util.paginador.PageRender;
import com.inad.reclutamiento.app.models.candidato.Candidato;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
@Controller
@RequestMapping(value = "candidato")
public class CandidatoController {
	
	protected static final Logger logger = LoggerFactory.getLogger(CandidatoController.class);
	
	@Autowired
	private CandidatoService candidatoService;
	
	@GetMapping(value = "nuevo-candidato")
	public String crearCandidato(HttpServletRequest request, Model model) {
		Candidato candidato = new Candidato();
		model.addAttribute("candidato", candidato);
		model.addAttribute("titulo", "Nuevo Candidato");
		return "candidatos/crearCandidato";
	}
	
	@PostMapping(value = "crear")
	public String guardarCandidato(HttpServletRequest request, Model model, Candidato candidato, RedirectAttributes flash) {
		logger.info("Guardar candidato: " + candidato.toString());
		candidatoService.saveCandidato(candidato);
		flash.addFlashAttribute("success","Se registro el candidato con éxito!");
		return "redirect:/candidato/nuevo-candidato";
	}
	
	@GetMapping(value = "listar-candidatos")
	public String listarCandidatos(HttpServletRequest request, Model model
			,@RequestParam(name = "page", defaultValue = "0") int page) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Candidato> candidatos = candidatoService.findAll(pageRequest);
		PageRender<Candidato> pageRender = new PageRender<>("/candidato/listar-candidatos", candidatos);
		
		logger.info("Listar Candidatos: " + candidatos.getSize());
		model.addAttribute("titulo","Lista de Candidatos");
		model.addAttribute("candidatos", candidatos);
		model.addAttribute("page", pageRender);
		return "candidatos/listarCandidatos";
	}
	
	@GetMapping(value = "buscar-candidato")
	public String buscarCandidato(HttpServletRequest request, Model model) {
		Candidato candidato = new Candidato();
		model.addAttribute("candidato", candidato);
		model.addAttribute("titulo", "Nuevo Candidato");
		return "candidatos/buscarCandidato";
	}
	
	@GetMapping(value = "eliminar/{id}")
	public String eliminarCandidato(HttpServletRequest request, RedirectAttributes flash
			,@PathVariable(name = "id", required = true) long id) {
		candidatoService.deleteCandidatoById(id);
		logger.info("Eliminar candidato id: " + id);
		flash.addFlashAttribute("success", "El candidato se eliminó correctamente!");
		return "redirect:/candidato/listar-candidatos";
	}
}
