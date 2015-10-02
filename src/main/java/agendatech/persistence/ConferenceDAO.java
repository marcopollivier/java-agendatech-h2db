package agendatech.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import agendatech.model.Conference;
import agendatech.persist.ConnectionFactory;

public class ConferenceDAO {

	private Connection conn;
	
	public ConferenceDAO() throws ClassNotFoundException, SQLException {
		conn = ConnectionFactory.getConnection();
	}
	
	public List<Conference> retrieveAll() throws SQLException {
		Statement stat = conn.createStatement();
        ResultSet rs;
        rs = stat.executeQuery("select * from conference");
        
        List<Conference> conferences = new ArrayList<>();
        while (rs.next()) {
            Conference conf = new Conference();
            conf.setId(rs.getInt("id"));
            conf.setName(rs.getString("name"));
            conf.setContactEmail(rs.getString("contact_email"));
            conf.setState(rs.getString("state"));
            conf.setDescription(rs.getString("description"));
            conf.setStartDate(rs.getDate("start_date"));
            conf.setEndDate(rs.getDate("end_date"));
            conferences.add(conf);
        }
        stat.close();
        
        return conferences;
	}
	
	public void create(Conference conference) throws ClassNotFoundException, SQLException, ParseException {
		String sql = "insert into conference (name, contact_email, state, description, start_date, end_date) values(?, ?, ?, ?, ?, ?);";

		PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setString(1, conference.getName());
        ps.setString(2, conference.getContactEmail());
        ps.setString(3, conference.getState());
        ps.setString(4, conference.getDescription());
        ps.setDate(5, new java.sql.Date(conference.getStartDate().getTime()));
        ps.setDate(6, new java.sql.Date(conference.getEndDate().getTime()));
        
        ps.execute();
        ps.close();
	}
	
	public void update(Conference conference) throws SQLException {
		String sql = "update conference "
				   + "set name = ?, contact_email = ?, state = ?, description = ?, start_date = ?, end_date = ? "
				   + "where id = ?;";

		PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setString(1, conference.getName());
        ps.setString(2, conference.getContactEmail());
        ps.setString(3, conference.getState());
        ps.setString(4, conference.getDescription());
        ps.setDate(5, new java.sql.Date(conference.getStartDate().getTime()));
        ps.setDate(6, new java.sql.Date(conference.getEndDate().getTime()));
        ps.setInt(7, conference.getId());
        
        ps.execute();
        ps.close();		
	}
	
	public void delete(Conference conference) {
		//TODO 
	}
	
}