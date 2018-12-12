package it.objectmethod.webappmondospring.dao;

import java.util.List;

import it.objectmethod.webappmondospring.model.Nazione;

public interface IDaoNazione {

	public List<String> getAllContinents();
	public List<Nazione> getNationsByContinent(String continent);
	public List<Nazione> allNations();
}
