package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import interfaces.ServerInterface;

public class Main {
	
		
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

		String chatServerURL = "rmi://localhost/RMIServer";
		ServerInterface chatServer = (ServerInterface) Naming.lookup(chatServerURL);
		new Thread(new Client(args[0], chatServer)).start();
	}
	
	
}
