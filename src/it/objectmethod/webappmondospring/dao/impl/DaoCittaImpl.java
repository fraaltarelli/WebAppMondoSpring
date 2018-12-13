package it.objectmethod.webappmondospring.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import it.objectmethod.webappmondospring.model.mapper.CityMapper;
//import it.objectmethod.webappmondospring.config.ConnectionManager;
import it.objectmethod.webappmondospring.dao.IDaoCitta;
import it.objectmethod.webappmondospring.model.Citta;

public class DaoCittaImpl implements IDaoCitta{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Citta> getCitiesByNation(String countrycode) {
		List<Citta> list = new ArrayList<Citta>();
		String sql = "SELECT * from city where countrycode= ?";
		list = this.jdbcTemplateObject.query(sql, new Object[]{countrycode}, new CityMapper());	
		return list;
	}

	@Override
	public List<Citta> cercaCitta(String cittaCercata) {
		List<Citta> list = new ArrayList<Citta>();
		String sql = "SELECT * from city where name like ?";
		list = this.jdbcTemplateObject.query(sql, new Object[]{cittaCercata+"%"}, new CityMapper());
		return list;
	}
	
	@Override
	public void eliminaCitta(int idCitta) {
		String sql = "DELETE from city WHERE id=?";
		this.jdbcTemplateObject.update(sql, idCitta);
		return;
	}
	
	@Override
	public void aggiornaCitta(Citta cittaDaAggiornare) {
		String sql = "UPDATE city " + 
				" SET name=?, countrycode=?, district=?, population= ?" + 
				" WHERE id=?";
		this.jdbcTemplateObject.update(sql, new Object[] {cittaDaAggiornare.getName(), 
				cittaDaAggiornare.getCountryCode(), cittaDaAggiornare.getDistrict(), 
				cittaDaAggiornare.getPopulation(), cittaDaAggiornare.getId() } );
	}
	
	@Override
	public Citta cittaDaModificare(int id) {
		Citta city= new Citta();
		String sql = "SELECT * from city where id = ?";
		city = this.jdbcTemplateObject.queryForObject(sql, new Object[]{id}, new CityMapper());
	    return city;
	}
	
	@Override
	public void inserisciCitta(Citta cittaDaInserire) {
		String sql = "INSERT INTO city (id, Name, CountryCode, District, Population)" + 
				" values (?, ?, ?, ?, ?)";
		this.jdbcTemplateObject.update(sql, new Object[] {cittaDaInserire.getId(), 
				cittaDaInserire.getName(), cittaDaInserire.getCountryCode(), 
				cittaDaInserire.getDistrict(), cittaDaInserire.getPopulation() } );
	}

}
