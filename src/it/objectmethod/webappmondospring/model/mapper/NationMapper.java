package it.objectmethod.webappmondospring.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.objectmethod.webappmondospring.model.Nazione;

public class NationMapper implements RowMapper<Nazione>{

	@Override
	public Nazione mapRow(ResultSet rs, int rowNum) throws SQLException {
		Nazione nazione = new Nazione();
		nazione.setCode(rs.getString("code"));
		nazione.setName(rs.getString("name"));
		nazione.setPopulation(rs.getInt("population"));
		return nazione;
	}
}
