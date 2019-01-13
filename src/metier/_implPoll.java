package metier;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.db_interaction;
import entities._poll;

public class _implPoll implements _interfacePoll {

	public void _create_poll(_poll p) {
		// TODO Auto-generated method stub
		Connection connection=db_interaction.getConnection();
		try{
		PreparedStatement ps = connection.prepareStatement
				("insert into poll( DESCRIPTION, DURATION, CATEGORY, USERID, TYPE) values (?,?,?,?,?)");
		//ps.setInt(1,p.getPollId());
		ps.setString(1,p.get_description());
		ps.setInt(2,p.get_duration());
		ps.setString(3,p.get_category());
		ps.setInt(4,p.get_user_id());
		ps.setString(5,p.get_type());

		ps.executeUpdate();
		}catch(SQLException e){
		e.printStackTrace();
		}
	}

	@Override
	public  ArrayList<_poll>  _search_vote_by_Type(String typ){
		Connection con =db_interaction.getConnection();
		ArrayList<_poll> listevote= new ArrayList<_poll>();
		try {
		PreparedStatement statement = con.prepareStatement("SELECT pollid, description, duration, category, userid, type FROM POLL WHERE type=? ");
		statement.setString(1,typ);
		ResultSet result = statement.executeQuery();
		
		while (result.next()) {
			
			
			_poll p  = new _poll(result.getInt("pollid"), result.getString("description"), result.getInt("duration"), result.getString("category"), result.getInt("userid"),result.getString("type"));
			listevote.add(p);
			
		}
		
		System.out.println("poll selected");
		
		}catch(SQLException e){
			e.printStackTrace();
			}
		
		
		return listevote;
		
	
	}
	
	
	
	
	
	
	
	
			
			public  _poll  _last_poll_for_user(int i){
		Connection con =db_interaction.getConnection();
		_poll p = null;
		
		try {
		PreparedStatement statement = con.prepareStatement("SELECT pollid, description, duration, category, userid, type FROM POLL WHERE   pollid = (SELECT MAX(pollid) FROM POLL WHERE userid=?) ");
		statement.setInt(1,i);
		ResultSet result = statement.executeQuery();
		
		while (result.next()) {
			
			
			 p  = new _poll(result.getInt("pollid"), result.getString("description"), result.getInt("duration"), result.getString("category"), result.getInt("userid"),result.getString("type"));
			
			
		}
		
		System.out.println("last poll selected");
		
		}catch(SQLException e){
			e.printStackTrace();
			}
		
		
		return p;
		
	
	}
	
	
			
			
			
	
}

