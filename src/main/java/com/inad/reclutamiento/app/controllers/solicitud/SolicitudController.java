/**
 * 
 */
package com.inad.reclutamiento.app.controllers.solicitud;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inad.reclutamiento.app.api.service.CandidatoService;
import com.inad.reclutamiento.app.api.service.RfcService;
import com.inad.reclutamiento.app.models.candidato.Candidato;
import com.inad.reclutamiento.app.models.candidato.Rfc;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
@Controller
@RequestMapping(value = "solicitud")
public class SolicitudController {

	protected static final Logger logger = LoggerFactory.getLogger(SolicitudController.class);
	
	@Autowired
	private CandidatoService candidatoService;
	
	@Autowired
	private RfcService rfcService;
	
	@GetMapping(value = "inicio")
	public String inicioSolicitud(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		Rfc rfc = new Rfc();
		
		model.addAttribute("rfc", rfc);
		model.addAttribute("titulo", "Captura de Solicitud");
		return "solicitud/solicitud";
	}
	
	@PostMapping(value = "buscarRfc")
	public String buscarSolicitud(HttpServletRequest request, 
			Model model, Rfc rfc) {
		
		Rfc nuevoRfc = new Rfc();
		
		logger.info("Metodo post de buscar rfc");
		logger.info("RFC: "  + rfc.getClave());
		logger.info("Homo Clave: " + rfc.getHomoclave());
		
		List<Rfc> listaRfc = rfcService.findAll();
		
		if ( listaRfc.size() > 0 ) {
			for ( Rfc r : listaRfc ) {
				if ( rfc.getClave().equals( r.getClave() ) ) {
					nuevoRfc = rfc;
					logger.info("Se encontró rfc");
				}
			}
		}
		
		if ( nuevoRfc.getClave() == null || nuevoRfc.getClave().isEmpty() ) {
			rfcService.saveRfc(rfc);
			logger.info("Se guarda rfc");
		}
		
		Candidato candidato = new Candidato();
		
		model.addAttribute("rfc", nuevoRfc);
		model.addAttribute("candidato", candidato);
		model.addAttribute("titulo", "Captura de Solicitud");
		return "solicitud/solicitud";
	}
	
}
