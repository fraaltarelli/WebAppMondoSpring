package it.objectmethod.webappmondospring.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import it.objectmethod.webappmondospring.model.Citta;

public class CitiesByNationMapper  implements RowMapper<List<Citta>>{

	
	@Override
	public List<Citta> mapRow(ResultSet rs, int rowNum) throws SQLException {
		List<Citta> list = new ArrayList<Citta>();
		while(rs.next()){
			Citta citta = new Citta();
			citta.setId(rs.getInt("id"));
			citta.setName(rs.getString("name"));
			citta.setDistrict(rs.getString("district"));
			citta.setPopulation(rs.getInt("population"));
			citta.setCountryCode(rs.getString("countrycode"));
			list.add(citta);
		}
		return list;
	}
}
