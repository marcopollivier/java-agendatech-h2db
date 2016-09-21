package agendatech.persistence.test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import agendatech.model.Conference;
import agendatech.persistence.ConferenceJdbcDao;

public class ConferenceDAOTest {
	
	private ConferenceJdbcDao dao;
	
	public ConferenceDAOTest() throws ClassNotFoundException, SQLException {
		dao = new ConferenceJdbcDao();
	}
	
	@Before
	public void after() throws ClassNotFoundException, SQLException, ParseException {
		dao.create(new Conference("Rio Info", "rio_info@gmail.com"));
		dao.create(new Conference("Tech Info", "techinfo@gmail.com"));
		dao.create(new Conference("Sampa TI", "sampati@gmail.com"));
		dao.create(new Conference("DotNet Conf", "dotnet_conf@gmail.com"));
		dao.create(new Conference("Java Conf", "javaconf@gmail.com"));
		dao.create(new Conference("Tests in Sampa", "testsinsampa@gmail.com"));
		dao.create(new Conference("SP Tech", "sptech@gmail.com"));
	}
	
	@Test
	public void createTest() throws ClassNotFoundException, SQLException, ParseException {
		assertTrue(dao.retrieve().size() > 0);
	}
	
	

}
