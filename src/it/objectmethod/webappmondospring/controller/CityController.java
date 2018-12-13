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
import it.objectmethod.webappmondospring.dao.IDaoNazione;
import it.objectmethod.webappmondospring.model.Citta;
import it.objectmethod.webappmondospring.model.Nazione;

@Controller
public class CityController {

	@Autowired
	private IDaoCitta daoCitta;
	
	@Autowired
	private IDaoNazione daoNazione;
	
	
	@GetMapping("/runCitta")
	public String listaCitta(@RequestParam("codiceNazioneSelezionata") String countrycode, ModelMap model) {
		List<Citta> listaCitta = daoCitta.getCitiesByNation(countrycode);
		model.addAttribute("listaCitta", listaCitta);
		return "listaCitta";
	}
	
	@GetMapping("/listaCittaCercate")
	public String cittaCercate(@RequestParam("cittacercata") String cittaCercata, ModelMap model) {
		List<Citta> listaCitta = daoCitta.cercaCitta(cittaCercata);
		model.addAttribute("listaCitta", listaCitta);
		return "listaCitta";
	}
	
	
	@GetMapping("/runEliminaCitta")
	public String eliminaCitta(@RequestParam("idCitta") Integer idCitta, @RequestParam("countryCode") String countryCode, ModelMap model) {
		daoCitta.eliminaCitta(idCitta);
		List<Citta> listaCitta = daoCitta.getCitiesByNation(countryCode);
		model.addAttribute("messaggio", "Eliminazione riuscita");
		model.addAttribute("listaCitta", listaCitta);
		return "listaCitta";
	}
	
	@GetMapping("/runAggiornamentoForm")
	public String aggiornamentoForm(@RequestParam("idCitta") Integer idCitta, @RequestParam("countryCode") String countryCode, ModelMap model) {
		Citta cittaDaModificare = new Citta();
		if (idCitta != 0) {
		cittaDaModificare = daoCitta.cittaDaModificare(idCitta);
		}
		List<Nazione> list = daoNazione.allNations();
		model.addAttribute("allNations", list);
		model.addAttribute("cittaDaModificare", cittaDaModificare);
		return "modificaSalvaCitta";
	}
	
	@GetMapping("/runSalvaCitta")
	public String aggiornamentoForm(@RequestParam("countrycode") String countrycode, @RequestParam("nomecittainserito") String nome, @RequestParam("nomedistrettoinserito") String distretto, @RequestParam("popolazioneinserita") Integer popolazione, @RequestParam("id") Integer id, ModelMap model) {
		Citta cittaDaSalvare= new Citta();
		cittaDaSalvare.setId(id);
		cittaDaSalvare.setName(nome);
		cittaDaSalvare.setDistrict(distretto);
		cittaDaSalvare.setPopulation(popolazione);
		cittaDaSalvare.setCountryCode(countrycode);
		if(id!= 0) {
			daoCitta.aggiornaCitta(cittaDaSalvare);
		}
		else {
			daoCitta.inserisciCitta(cittaDaSalvare);
		}
		List<Citta> listaCitta = daoCitta.getCitiesByNation(countrycode);
		model.addAttribute("messaggio", "Salvataggio riuscito");
		model.addAttribute("listaCitta", listaCitta);
		return "listaCitta";
	}
	
	
}

