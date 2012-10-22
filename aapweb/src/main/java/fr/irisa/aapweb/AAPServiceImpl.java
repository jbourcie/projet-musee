package fr.irisa.aapweb;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import javax.net.ServerSocketFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.jsonrpc4j.JsonRpcServer;
import com.googlecode.jsonrpc4j.StreamServer;


public class AAPServiceImpl implements IAPPService {

	

	public static void main(String[] args) throws IOException {
		IAPPService service = new AAPServiceImpl();
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonRpcServer jsonRpcServer = new JsonRpcServer( mapper,service, 		IAPPService.class);
		
		// create the stream server
		ServerSocket serverSocket = ServerSocketFactory.getDefault().createServerSocket(1420, 0, InetAddress.getByName("127.0.0.1"));
		
		// start it, this method doesn't block
		StreamServer streamServer = new StreamServer(jsonRpcServer, 50, serverSocket);
		streamServer.start();		
		
		
	}
	
	public boolean isCorrect(String message) {
		return message.equals("true");
	}
	List<String> melodies;

	public AAPServiceImpl() {
	
	       melodies = new ArrayList<String>();
	       melodies.add("*Derick*");
	       melodies.add("*Rick Hunter*");
	       melodies.add("*Mike Giver*");	// TODO Auto-generated constructor stub
	}	
	public String getMelodie() {
        int lower = 0;
        int higher = 2;
        int random = (int)(Math.random() * (higher-lower)) + lower;
        return melodies.get(random);
	}

}
