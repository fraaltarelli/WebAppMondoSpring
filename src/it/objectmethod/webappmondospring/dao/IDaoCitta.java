package it.objectmethod.webappmondospring.dao;

import java.util.List;

import it.objectmethod.webappmondospring.model.Citta;

public interface IDaoCitta {

	public List<Citta> getCitiesByNation(String countrycode);
	public void eliminaCitta(int idCitta);
	public Citta cittaDaModificare(int id);
	public void aggiornaCitta(Citta cittaDaAggiornare);
	public void inserisciCitta(Citta cittaDaInserire);
	public List<Citta> cercaCitta(String cittaCercata);
	
}
