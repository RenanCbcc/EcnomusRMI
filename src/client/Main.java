package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import interfaces.ServerInterface;

public class Main {
	
		
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		String serverURL = "rmi://localhost/RMIServer";
		ServerInterface server = (ServerInterface) Naming.lookup(serverURL);
		new Thread(new Client(args[0], server)).start();
	}
	
	
}
