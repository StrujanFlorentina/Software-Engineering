package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements RemoteInterface{

	public void runServer()
	{
		System.setProperty("java.rmi.server.host","192.168.56.1");
		
		 try { 
	         // Instantiating the implementation class 
	         AuxClass obj = new AuxClass(); 
	    
	         // Exporting the object of implementation class  
	         // (here we are exporting the remote object to the stub) 
	         RemoteInterface stub = (RemoteInterface) UnicastRemoteObject.exportObject((Remote) obj, 0);  
	         
	         // Binding the remote object (stub) in the registry 
	         Registry registry = LocateRegistry.getRegistry(); 
	         
	         registry.bind("Hello", stub);  
	         System.err.println("Server ready"); 
	      } catch (Exception e) { 
	         System.err.println("Server exception: " + e.toString()); 
	         e.printStackTrace(); 
	      } 
	}

	public static void main(String[] args)
	{
		Server s= new Server();
		s.runServer();

		/*
		System.setProperty("java.rmi.server.host","192.168.56.1");
		
		 try { 
	         // Instantiating the implementation class 
	         AuxClass obj = new AuxClass(); 
	    
	         // Exporting the object of implementation class  
	         // (here we are exporting the remote object to the stub) 
	         RemoteInterface stub = (RemoteInterface) UnicastRemoteObject.exportObject((Remote) obj, 0);  
	         
	         // Binding the remote object (stub) in the registry 
	         Registry registry = LocateRegistry.getRegistry(); 
	         
	         registry.bind("Hello", stub);  
	         System.err.println("Server ready"); 
	      } catch (Exception e) { 
	         System.err.println("Server exception: " + e.toString()); 
	         e.printStackTrace(); 
	      } */
	}

	@Override
	public void printMsg(String name) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
}
