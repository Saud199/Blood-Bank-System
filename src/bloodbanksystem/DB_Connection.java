
package bloodbanksystem;

import java.sql.Connection;
import java.sql.DriverManager;
public class DB_Connection {
    
     /*public static void main(String[] args) {
	DB_Connection obj_DB_Connection=new DB_Connection();
	Connection connection=null;
	connection=obj_DB_Connection.get_connection();
	System.out.println(connection);
     }*/
     public Connection get_connection() {
	Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12258493","sql12258493","kjPsaMLfEH");
	}
        catch (Exception e) {
            System.out.println(e);
	}
	return connection;
     }
}
