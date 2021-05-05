package rmi;

public class AuxClass implements RemoteInterface{
	
	 // Implementing the interface method 
	   public void printMsg(String name) {  
	      System.out.println("This is an example RMI program with client: " + name);  
	   }  
}
