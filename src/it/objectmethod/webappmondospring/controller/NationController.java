package it.objectmethod.webappmondospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.webappmondospring.dao.impl.DaoNazioneImpl;
import it.objectmethod.webappmondospring.dao.IDaoNazione;
import it.objectmethod.webappmondospring.model.Citta;
import it.objectmethod.webappmondospring.model.Nazione;

@Controller
public class NationController {

//	@Autowired
//	private IDaoNazione daoNazione;
	
	IDaoNazione daoNazione= new DaoNazioneImpl();
	
	@GetMapping("/runContinenti")
	public String allcontinents(ModelMap model) {
		List<String> allcontinents = daoNazione.getAllContinents();
		model.addAttribute("allcontinents", allcontinents);
		return "continenti";
	}
	
	@GetMapping("/runNazioni")
	public String login(@RequestParam("continente") String continente, ModelMap model) {
		List<Nazione> nationsbycontinent= daoNazione.getNationsByContinent(continente);
		model.addAttribute("nationsbycontinent", nationsbycontinent);
		return "listanazioni";
	}
	
//	@GetMapping("/runAggiornamentoForm")
//	public String aggiornamentoForm(ModelMap model) {
//		List<Nazione> list = daoNazione.allNations();
//		model.addAttribute("allNations", list);
//		return "modificaSalvaCitta";
//	}
	
}
