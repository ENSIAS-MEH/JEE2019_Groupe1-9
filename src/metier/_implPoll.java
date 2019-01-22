package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.db_interaction;
import entities._poll;

public class _implPoll implements _interfacePoll {

	public void _create_poll(_poll p) {
		Connection connection=db_interaction._get_connection();
		try{
			PreparedStatement ps = connection.prepareStatement
					("insert into poll (Description, Category, UserId, pollDate,expires)  " +
							"values (?,?,?,?,?)");

			//ps.setInt(1,p.getPollId());
			ps.setString(1,p.get_description());
			ps.setString(2,p.get_category());
			ps.setInt(3,p.get_userId());
			ps.setTimestamp(4,p.get_date());
			ps.setDate(5,p.get_expires());
			ps.executeUpdate();
			System.out.println("poll created");
		}catch(SQLException e){
		e.printStackTrace();
		}
	}

	@Override
	public ArrayList<_poll> _search_vote_by_Type(String type) {
		return null;
	}

	@Override
	public  ArrayList<_poll>  _search_poll_by_category(String typ){
		Connection con =db_interaction._get_connection();
		ArrayList<_poll> listevote= new ArrayList<_poll>();
		try {
		PreparedStatement statement =
				con.prepareStatement("SELECT pollid, description," +
				" userid, type FROM POLL WHERE  category =? ");
		statement.setString(1,typ);
		ResultSet result = statement.executeQuery();
		
		while (result.next()) {
			_poll p  = null;
			p.set_pollId(result.getInt("pollId"));
			p.set_description(result.getString("description"));
			p.set_date(result.getTimestamp("pollDate"));
			p.set_category(result.getString("category"));
			p.set_userId(result.getInt("userId"));
			p.set_expires(result.getDate("expires"));
			listevote.add(p);
			
		}
		System.out.println("poll selected");
		}catch(SQLException e){
			e.printStackTrace();
			}
		return listevote;
	}

	public int _last_poll_for_user(int i){
		Connection con =db_interaction._get_connection();
		int poll_id = -1;

		try {
		PreparedStatement statement = con.prepareStatement("SELECT MAX(pollid) FROM POLL WHERE userid=?");
		statement.setInt(1,i);
		ResultSet result = statement.executeQuery();
			System.out.println(""+result);
		if  (result.next()) {
			poll_id=result.getInt("MAX(pollid)");
		}
		System.out.println("last poll selected");

		}catch(SQLException e){
			e.printStackTrace();
			}

		return poll_id;


	}
	
	
			
			
			
	
}

