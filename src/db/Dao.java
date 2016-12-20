package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import bean.Fermata;

public class Dao {
	
	public List<Fermata> getAllFermate(){                    //prendo tutte le fermate x le combo
		Connection conn = DBConnect.getConnection();
		String query = "select * from fermata order by nome ASC;";
		List<Fermata > fermate = new LinkedList<Fermata>();
		try{
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet res = st.executeQuery();
			while(res.next()){
				Fermata f = new Fermata(res.getInt("idFermata"), res.getString("nome"), res.getDouble("coordX"), res.getDouble("coordY"));
				fermate.add(f);
			}
			conn.close();
			return fermate;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
		}
	}

	public List<Integer> getAllStazioni(){
		Connection conn = DBConnect.getConnection();
		List<Integer> staz = new LinkedList<Integer>();
		String query = "select id_stazP, id_stazA from connessione ";
		try{
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet res = st.executeQuery();
			while(res.next()){
				staz.add(res.getInt("id_stazp"), res.getInt("id_stazA"));
				
			}
			conn.close();
			return staz;
			
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
		}
	}
	
}
