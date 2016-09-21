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

public class ConferenceJdbcDao {

	private Connection conn;
	
	public ConferenceJdbcDao() throws ClassNotFoundException, SQLException {
		conn = ConnectionFactory.getConnection();
	}
	
	public List<Conference> retrieve() throws SQLException {
		Statement stat = conn.createStatement();
        ResultSet rs;
        rs = stat.executeQuery("select * from conference");
        
        List<Conference> conferences = new ArrayList<>();
        while (rs.next()) {
            Conference conf = new Conference();
            conf.setId(rs.getInt("id"));
            conf.setName(rs.getString("name"));
            conf.setContactEmail(rs.getString("contact_email"));
            conferences.add(conf);
        }
        stat.close();
        
        return conferences;
	}
	
	public void create(Conference conference) throws ClassNotFoundException, SQLException, ParseException {
		String sql = "insert into conference (name, contact_email) "
				   + "values(?, ?);";

		PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setString(1, conference.getName());
        ps.setString(2, conference.getContactEmail());
        
        ps.execute();
        ps.close();
	}
	
	public void update(Conference conference) throws SQLException {
		String sql = "update conference "
				   + "set name = ?, contact_email = ?"
				   + "where id = ?;";

		PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setString(1, conference.getName());
        ps.setString(2, conference.getContactEmail());
        ps.setInt(7, conference.getId());
        
        ps.execute();
        ps.close();		
	}
	
}