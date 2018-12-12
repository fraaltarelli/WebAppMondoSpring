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
//public class AllContinentsMapper implements RowMapper<List<String>>{
//
//	@Override
//	public List<String> mapRow(ResultSet rs, int rowNum) throws SQLException {
//		List<String> allcontinents = new ArrayList<String>();
//		while(rs.next()){
//			allcontinents.add(rs.getString("continent"));
//		}
//		return allcontinents;
//	}
//	
//}