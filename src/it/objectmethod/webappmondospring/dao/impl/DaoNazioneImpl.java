package it.objectmethod.webappmondospring.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import it.objectmethod.webappmondospring.config.ConnectionManager;
import it.objectmethod.webappmondospring.dao.IDaoNazione;
import it.objectmethod.webappmondospring.model.Nazione;

public class DaoNazioneImpl implements IDaoNazione{

	@Override
	public List<String> getAllContinents() {
		Statement stmt = null;
		List<String> list = null;
		Connection conn = ConnectionManager.getConnection();
		try{
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT distinct continent FROM country";
			ResultSet rs = stmt.executeQuery(sql);
			list = new ArrayList<>();
			while(rs.next()){
				String cont = rs.getString("Continent");

				list.add(cont);
			}

			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){

			se.printStackTrace();
		}catch(Exception e){

			e.printStackTrace();
		}finally{

			try{
				if(stmt!=null)
					stmt.close();
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

	@Override
	public List<Nazione> getNationsByContinent(String continente) {
		List<Nazione> list = null;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement prepStat = null;
		try{

			String sql = "SELECT code,name,population from country where continent= ?";
			prepStat= conn.prepareStatement(sql);
			prepStat.setString(1, continente);
			ResultSet rs = prepStat.executeQuery();
			list = new ArrayList<>();

			while(rs.next()){
				Nazione nation= new Nazione();

				String name = rs.getString("name");
				String code = rs.getString("code");
				int population = rs.getInt("population");
				nation.setName(name);
				nation.setCode(code);
				nation.setPopulation(population);
				list.add(nation);
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

	@Override
	public List<Nazione> allNations() {

		List<Nazione> list = null;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement prepStat = null;
		try{

			String sql = "SELECT name, code, population from country";
			prepStat= conn.prepareStatement(sql);
			ResultSet rs = prepStat.executeQuery();
			list = new ArrayList<>();

			while(rs.next()){
				Nazione nation= new Nazione();
				String name = rs.getString("name");
				String code= rs.getString("code");
				int population = rs.getInt("population");
				nation.setName(name);
				nation.setCode(code);
				nation.setPopulation(population);
				list.add(nation);
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

}
