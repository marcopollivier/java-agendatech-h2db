package agendatech.persistence.test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.After;
import org.junit.Test;

import agendatech.model.Conference;
import agendatech.persistence.ConferenceDAO;
import agendatech.utils.DateUtil;

public class ConferenceDAOTest {
	
	private ConferenceDAO dao;
	
	@After
	public void after() {
		
		try {
			dao = new ConferenceDAO();
		
			dao.create(new Conference(1, "Rio Info", "rio_info@gmail.com", "RJ", DateUtil.parse("19-05-1990"), DateUtil.parse("23-05-1990")));
			dao.create(new Conference(2, "Tech Info", "techinfo@gmail.com", "MG", DateUtil.parse("19-05-1990"), DateUtil.parse("23-05-1990")));
			dao.create(new Conference(3, "Sampa TI", "sampati@gmail.com", "SP", DateUtil.parse("19-05-1990"), DateUtil.parse("23-05-1990")));
			dao.create(new Conference(4, "DotNet Conf", "dotnet_conf@gmail.com", "RJ", DateUtil.parse("19-05-1990"), DateUtil.parse("23-05-1990")));
			dao.create(new Conference(5, "Java Conf", "javaconf@gmail.com", "SP", DateUtil.parse("19-05-1990"), DateUtil.parse("23-05-1990")));
			dao.create(new Conference(6, "Tests in Sampa", "testsinsampa@gmail.com", "SP", DateUtil.parse("19-05-1990"), DateUtil.parse("23-05-1990")));
			dao.create(new Conference(7, "SP Tech", "sptech@gmail.com", "SP", DateUtil.parse("19-05-1990"), DateUtil.parse("23-05-1990")));

		} catch (ClassNotFoundException | SQLException | ParseException e) {
			e.printStackTrace();
		}		
		
	}
	
	private static void list(ConferenceDAO dao) throws SQLException {
		for (Conference conference : dao.retrieveAll()) {
			System.out.println(conference.toString());
		}
		System.out.println("--------------------------------------------");
	}
	
	@Test
	public void createTest() {
		try {
			
			list(dao);
			//INCERT SECUNDARIO
			Conference conf = new Conference(8, "XXXXXX", "xxx@gmail.com", "RJ", DateUtil.parse("19-05-1990"), DateUtil.parse("23-05-1990"));
			dao.create(conf);
			list(dao);
			
			//UPDATE
			conf.setName("Nome Alterado");
			dao.update(conf);
			list(dao);
			
			//DELETE
			dao.delete(conf);
			list(dao);
			
			assertTrue(true);
			
		} catch (ParseException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
