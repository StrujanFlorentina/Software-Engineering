package rmi;

import com.example.demo.model.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.jboss.logging.Logger;



public class Client{
	
	public void runClient()
	{
		try {  
	         // Getting the registry 
	         Registry registry = LocateRegistry.getRegistry(null); 
	    
	         // Looking up the registry for the remote object 
	         RemoteInterface stub = (RemoteInterface) registry.lookup("Hello"); 
	    
	         List<User> aux= Client.createConnection();
	         // Calling the remote method using the obtained object 
	         stub.printMsg(aux.toString()); 
	         
	        
	         // System.out.println("Remote method invoked"); 
	      } catch (Exception e) {
	         System.err.println("Client exception: " + e.toString()); 
	         e.printStackTrace(); 
	      }
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {  
		
		Client c= new Client();
		c.runClient();
   
    }
	
	
	public static List<User> createConnection()
	{
		List<User> users=new ArrayList<User>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","flori098");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from users_table");
			
			
						
			while(rs.next())
			{
				String name = rs.getString(2);
				String location= rs.getString(5);
				
				users.add(new User(location,name));
								
				
			}
		
			System.out.println("Database Connection Succesful");
			
			return users;
			
		}catch(ClassNotFoundException ex)
		{
			Logger.getLogger(Client.class.getName()).log(null, Level.SEVERE,ex);
		}catch(SQLException ex)
		{
			Logger.getLogger(Client.class.getName()).log(null, Level.SEVERE,ex);
		}
		return users;
	}
}
