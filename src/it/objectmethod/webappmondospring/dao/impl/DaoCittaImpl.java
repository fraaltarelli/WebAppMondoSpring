package it.objectmethod.webappmondospring.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.webappmondospring.config.ConnectionManager;
import it.objectmethod.webappmondospring.dao.IDaoCitta;
import it.objectmethod.webappmondospring.model.Citta;

public class DaoCittaImpl implements IDaoCitta{

	@Override
	public List<Citta> getCitiesByNation(String countrycode) {
		List<Citta> list = null;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement prepStat = null;
		try{

			String sql = "SELECT id,name, district, population, countrycode from city where countrycode= ?";
			prepStat= conn.prepareStatement(sql);
			prepStat.setString(1, countrycode);
			ResultSet rs = prepStat.executeQuery();
			list = new ArrayList<>();
			while(rs.next()){
				Citta city= new Citta();
				int id= rs.getInt("id");
				String name = rs.getString("name");
				String district = rs.getString("district");
				int population = rs.getInt("population");
				String countryCode = rs.getString("countrycode");
				city.setId(id);
				city.setName(name);
				city.setDistrict(district);
				city.setPopulation(population);
				city.setCountryCode(countryCode);
				list.add(city);
			}

			rs.close();
			prepStat.close();
			conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(prepStat!=null)
					prepStat.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
		return list;
	}

//	@Override
//	public List<Citta> cercaCitta(String cittaCercata) {
//
//		List<Citta> list = null;
//		Connection conn = ConnectionManager.getConnection();
//		PreparedStatement prepStat = null;
//		try{
//
//			String sql = "SELECT id, name, district, population, countrycode from city where name like ?";
//			prepStat= conn.prepareStatement(sql);
//			prepStat.setString(1, cittaCercata+ "%");
//			ResultSet rs =prepStat.executeQuery();
//			list = new ArrayList<>();
//
//			while(rs.next()){
//				Citta city= new Citta();
//
//				int id= rs.getInt("id");
//				String name = rs.getString("name");
//				String district = rs.getString("district");
//				int population = rs.getInt("population");
//				String countryCode = rs.getString("countrycode");
//				city.setId(id);
//				city.setNomeCitta(name);
//				city.setDistretto(district);
//				city.setPopolazione(population);
//				city.setCountryCode(countryCode);
//				list.add(city);
//			}
//
//
//			rs.close();
//			prepStat.close();
//			conn.close();
//		}catch(SQLException se){
//
//			se.printStackTrace();
//		}catch(Exception e){
//
//			e.printStackTrace();
//		}finally{
//
//			try{
//				if(prepStat!=null)
//					prepStat.close();
//			}catch(SQLException se2){
//			}
//			try{
//				if(conn!=null)
//					conn.close();
//			}catch(SQLException se){
//				se.printStackTrace();
//			}
//		}
//		System.out.println("Goodbye!");
//		return list;
//	}

	@Override
	public void eliminaCitta(int idCitta) {

		Connection conn = ConnectionManager.getConnection();
		PreparedStatement prepStat = null;

		try{

			String sql = "DELETE from city WHERE id=?";
			prepStat= conn.prepareStatement(sql);
			prepStat.setInt(1, idCitta);
			prepStat.executeUpdate();	

		}catch(SQLException se){

			se.printStackTrace();
		}catch(Exception e){

			e.printStackTrace();
		}finally{

			try{
				if(prepStat!=null)
					prepStat.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		return;

	}

//	@Override
//	public void aggiornaCitta(Citta cittaDaAggiornare) {
//
//		Connection conn = ConnectionManager.getConnection();
//		PreparedStatement prepStat = null;
//
//		try{
//
//			String sql = "UPDATE city " + 
//					" SET name=?, countrycode=?, district=?, population= ?" + 
//					" WHERE id=?";
//			prepStat= conn.prepareStatement(sql);
//			prepStat.setString(1, cittaDaAggiornare.getNomeCitta());
//			prepStat.setString(2, cittaDaAggiornare.getCountryCode());
//			prepStat.setString(3, cittaDaAggiornare.getDistretto());
//			prepStat.setInt(4, cittaDaAggiornare.getPopolazione());
//			prepStat.setInt(5, cittaDaAggiornare.getId());
//			prepStat.executeUpdate();	
//			prepStat.close();
//			conn.close();
//		}catch(SQLException se){
//
//			se.printStackTrace();
//		}catch(Exception e){
//
//			e.printStackTrace();
//		}finally{
//
//			try{
//				if(prepStat!=null)
//					prepStat.close();
//			}catch(SQLException se2){
//			}
//			try{
//				if(conn!=null)
//					conn.close();
//			}catch(SQLException se){
//				se.printStackTrace();
//			}
//		}
//		System.out.println("Goodbye!");
//		return;
//
//	}

	@Override
	public Citta cittaDaModificare(int id) {
		Citta city= new Citta();
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement prepStat = null;
		try{

			String sql = "SELECT name, district, population, countrycode from city " + 
					"where id = ?";
			prepStat= conn.prepareStatement(sql);
			prepStat.setInt(1, id);
			ResultSet rs =prepStat.executeQuery();

			while(rs.next()){

				String name = rs.getString("Name");
				String district = rs.getString("district");
				int population = rs.getInt("population");
				String countryCode= rs.getString("countrycode");
				city.setName(name);
				city.setDistrict(district);
				city.setPopulation(population);
				city.setId(id);
				city.setCountryCode(countryCode);
			}

			rs.close();
			prepStat.close();
			conn.close();
		}catch(SQLException se){

			se.printStackTrace();
		}catch(Exception e){

			e.printStackTrace();
		}finally{

			try{
				if(prepStat!=null)
					prepStat.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}

		System.out.println("Goodbye!");
		return city;
	}

//	@Override
//	public void inserisciCitta(Citta cittaDaInserire) {
//		Connection conn = ConnectionManager.getConnection();
//		PreparedStatement prepStat = null;
//
//		try{
//
//			String sql = "INSERT INTO city (id, Name, CountryCode, District, Population)" + 
//					" values (?, ?, ?, ?, ?)";
//			prepStat= conn.prepareStatement(sql);
//			prepStat.setInt(1, cittaDaInserire.getId());
//			prepStat.setString(2, cittaDaInserire.getNomeCitta());
//			prepStat.setString(3, cittaDaInserire.getCountryCode());
//			prepStat.setString(4, cittaDaInserire.getDistretto());
//			prepStat.setInt(5, cittaDaInserire.getPopolazione());
//			prepStat.executeUpdate();	
//
//			prepStat.close();
//			conn.close();
//		}catch(SQLException se){
//
//			se.printStackTrace();
//		}catch(Exception e){
//
//			e.printStackTrace();
//		}finally{
//
//			try{
//				if(prepStat!=null)
//					prepStat.close();
//			}catch(SQLException se2){
//			}
//			try{
//				if(conn!=null)
//					conn.close();
//			}catch(SQLException se){
//				se.printStackTrace();
//			}
//		}
//		System.out.println("Goodbye!");
//		return;
//
//	}

}
