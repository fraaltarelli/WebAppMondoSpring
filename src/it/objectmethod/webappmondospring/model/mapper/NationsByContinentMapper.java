//package it.objectmethod.webappmondospring.model.mapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.jdbc.core.RowMapper;
//
//import it.objectmethod.webappmondospring.model.Nazione;
//
//public class NationsByContinentMapper implements RowMapper<List<Nazione>>{
//
//	@Override
//	public List<Nazione> mapRow(ResultSet rs, int rowNum) throws SQLException {
//		List<Nazione> nationsbycontinent = new ArrayList<Nazione>();
//		while(rs.next()){
//			Nazione nazione = new Nazione();
//			nazione.setNomeNazione(rs.getString("name"));
//			nazione.setCode(rs.getString("code"));
//			nazione.setPopolazione(rs.getInt("population"));
//			nationsbycontinent.add(nazione);
//		}
//		return nationsbycontinent;
//	}
//	
//}