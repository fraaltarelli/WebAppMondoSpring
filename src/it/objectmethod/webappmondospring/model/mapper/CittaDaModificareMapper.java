package it.objectmethod.webappmondospring.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import it.objectmethod.webappmondospring.model.Citta;

public class CittaDaModificareMapper  implements RowMapper<Citta>{

	
	@Override
	public Citta mapRow(ResultSet rs, int rowNum) throws SQLException {
		Citta citta = new Citta();
		while(rs.next()){
			citta.setName(rs.getString("name"));
			citta.setDistrict(rs.getString("district"));
			citta.setPopulation(rs.getInt("population"));
			citta.setCountryCode(rs.getString("countrycode"));
		}
		return citta;
	}
}
