package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.db_interaction;
import entities.Poll;

public class implPoll implements interfacePoll {

	public void _create_poll(Poll p) {
		// TODO Auto-generated method stub
		Connection connection=db_interaction.getConnection();
		try{
		PreparedStatement ps = connection.prepareStatement
				("insert into poll( DESCRIPTION, DURATION, CATEGORY, USERID, TYPE) values (?,?,?,?,?)");
		//ps.setInt(1,p.getPollId());
		ps.setString(1,p.getDescription());
		ps.setInt(2,p.getDuration());
		ps.setString(3,p.getCategory());
		ps.setInt(4,p.getUserId());
		ps.setString(5,p.getType());

		ps.executeUpdate();
		}catch(SQLException e){
		e.printStackTrace();
		}
	}

	@Override
	public  ArrayList<Poll>  _search_vote_by_Type(String typ){
		Connection con =db_interaction.getConnection();
		ArrayList<Poll> listevote= new ArrayList<Poll>();
		try {
		PreparedStatement statement = con.prepareStatement("SELECT pollid, description, duration, category, userid, type FROM POLL WHERE type=? ");
		statement.setString(1,typ);
		ResultSet result = statement.executeQuery();
		
		while (result.next()) {
			
			
			Poll p  = new Poll(result.getInt("pollid"), result.getString("description"), result.getInt("duration"), result.getString("category"), result.getInt("userid"),result.getString("type"));
			listevote.add(p);
			
		}
		
		System.out.println("poll selected");
		
		}catch(SQLException e){
			e.printStackTrace();
			}
		
		
		return listevote;
		
	
	}
	
}

