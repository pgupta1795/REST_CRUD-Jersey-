package com.main.demorest;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AlienDAO {

//	List<Alien> aliens = new ArrayList<>();

//	public AlienDAO() {
//		Alien a1 = new Alien();
//		a1.setId(1);
//		a1.setName("Pallav");
//		a1.setPoints(60);
//		a1.setHobby("Learning");
//		
//		Alien a2 = new Alien();
//		a2.setId(2);
//		a2.setName("Sangam");
//		a2.setPoints(50);
//		a2.setHobby("Cooking");
//		
//		aliens.add(a1);
//		aliens.add(a2);
//	}
	
	Connection  con = null;
	
	public AlienDAO() {
		try {
			String url = "jdbc:mysql://localhost:3306/restdb";
			String user = "root";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, "Pallu!234");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<Alien> getAliens() {
		List<Alien> aliens = new ArrayList<>();
		try {
			String  sql = "select * from alien";
			Statement  st = con.createStatement();
			ResultSet result = st.executeQuery(sql);
			while(result.next()) {
				Alien a = new Alien();
				a.setId(result.getInt(1));
				a.setName(result.getString(2));
				a.setPoints(result.getInt(3));
				a.setHobby(result.getString(4));
				
				aliens.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aliens;
	}
	
//	public Alien getAlienById(int id) {
//		for(Alien alien : aliens) {
//			if(alien.getId()==id) {
//				System.out.println("ID : "+id);
//				return alien;
//			}
//		}
//		return null;
//	}
	
//	public void createAlien(Alien alien) {
//		aliens.add(alien);
//	}
	
	public Alien getAlienById(int id) {
		Alien a = new Alien();
		try {
			String  sql = "select * from alien where id="+id;
			Statement  st = con.createStatement();
			ResultSet result = st.executeQuery(sql);
			if(result.next()) {
				a.setId(result.getInt(1));
				a.setName(result.getString(2));
				a.setPoints(result.getInt(3));
				a.setHobby(result.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public void createAlien(Alien alien) {
		try {
			String  sql = "insert into alien values (?,?,?,?)";
			PreparedStatement  st = con.prepareStatement(sql);
			st.setInt(1, alien.getId());
			st.setString(2, alien.getName());
			st.setInt(3, alien.getPoints());
			st.setString(4, alien.getHobby());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateAlien(Alien alien) {
		try {
			String  sql = "update alien set name=?, points=? where id=?";
			PreparedStatement  st = con.prepareStatement(sql);
			st.setString(1, alien.getName());
			st.setInt(2, alien.getPoints());
			st.setInt(3, alien.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAlien(int id) {
		try {
			String  sql = "delete from alien where id=?";
			PreparedStatement  st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
