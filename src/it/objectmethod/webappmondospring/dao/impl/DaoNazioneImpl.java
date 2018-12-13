package it.objectmethod.webappmondospring.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

//import it.objectmethod.webappmondospring.config.ConnectionManager;
import it.objectmethod.webappmondospring.dao.IDaoNazione;
import it.objectmethod.webappmondospring.model.Nazione;
import it.objectmethod.webappmondospring.model.mapper.NationMapper;

public class DaoNazioneImpl implements IDaoNazione{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<String> getAllContinents() {
		List<String> list = new ArrayList<String>();
		String sql = "SELECT distinct continent FROM country";
		list = this.jdbcTemplateObject.queryForList(sql,String.class);	
		return list;
	}
	
	
	@Override
	public List<Nazione> getNationsByContinent(String continente) {
		List<Nazione> list = new ArrayList<Nazione>();
		String sql = "SELECT * from country where continent= ?";
		list = this.jdbcTemplateObject.query(sql, new Object[] {continente}, new NationMapper());
		return list;
	}
	
	
	@Override
	public List<Nazione> allNations() {
		List<Nazione> list = new ArrayList<Nazione>();
		String sql = "SELECT * from country";
		list = this.jdbcTemplateObject.query(sql, new NationMapper());
		return list;
	}


}
