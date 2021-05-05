package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote{
	
	public void printMsg(String name) throws RemoteException;  

}
