package rmi;

public class MainRMI {
	
	public void runRMI()
	{
		Server s= new Server();
		s.runServer();
		
		Client c=new Client();
		c.runClient();
	}
	
	public static void main(String[] args)
	{
		MainRMI main= new MainRMI();
		main.runRMI();
	}
	
}
