package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Main {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		Naming.rebind("RMIServer", new Server());
	}
}
