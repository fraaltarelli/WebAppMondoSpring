package it.objectmethod.webappmondospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.webappmondospring.dao.IDaoCitta;
import it.objectmethod.webappmondospring.dao.impl.DaoCittaImpl;
import it.objectmethod.webappmondospring.model.Citta;

@Controller
public class CityController {

//	@Autowired
//	private IDaoCitta daoCitta;
	
	IDaoCitta daoCitta= new DaoCittaImpl();
	
	@GetMapping("/runCitta")
	public String listaCitta(@RequestParam("codiceNazioneSelezionata") String countrycode, ModelMap model) {
		List<Citta> listaCitta = daoCitta.getCitiesByNation(countrycode);
		model.addAttribute("listaCitta", listaCitta);
		return "listaCitta";
	}
	
	@GetMapping("/runEliminaCitta")
	public String eliminaCitta(@RequestParam("idCitta") Integer idCitta, @RequestParam("countryCode") String countryCode, ModelMap model) {
		daoCitta.eliminaCitta(idCitta);
		List<Citta> listaCitta = daoCitta.getCitiesByNation(countryCode);
		model.addAttribute("listaCitta", listaCitta);
		return "listaCitta";
	}
	
	@GetMapping("/runAggiornamentoForm")
	public String aggiornamentoForm(@RequestParam("idCitta") Integer idCitta, @RequestParam("countryCode") String countryCode, ModelMap model) {
		Citta cittaDaModificare = daoCitta.cittaDaModificare(idCitta);
//		List<Citta> listaCitta = daoCitta.getCitiesByNation(countryCode);
//		model.addAttribute("listaCitta", listaCitta);
		model.addAttribute("cittaDaModificare", cittaDaModificare);
		return "formModificaSalvaCitta";
	}
	
	
}

