package agendatech.persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.tools.DeleteDbFiles;

public class ConnectionFactory {

	private static Connection conn;
	
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
    	DeleteDbFiles.execute("~", "test", true);

        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:~/test");
        
        createDataStructure();
        
        return conn;
    }
    
    /**
     * Método temporário para criar a tabela baseado na classe
     * @throws SQLException
     */
    private static void createDataStructure() throws SQLException { 
    	Statement stat = conn.createStatement();
        
        String sql = "create table conference (id integer auto_increment not null, "
        									+ "contact_email varchar(255), "
        									+ "state varchar(2), "
        									+ "description text, "
        									+ "name varchar(255), "
        									+ "start_date datetime, "
        									+ "end_date datetime, "
        									+ "constraint pk_conference primary key (id));";
        
        stat.execute(sql);
        stat.close();
    }
    
    public static void close() throws SQLException {
    	conn.close();
    }

}
