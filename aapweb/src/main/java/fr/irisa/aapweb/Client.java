package fr.irisa.aapweb;

import java.net.URL;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;


public class Client {

	
	public static void main(String[] args) throws Throwable {
		
		JsonRpcHttpClient client = new JsonRpcHttpClient(
			    new URL("http://127.0.0.1:8080/aapweb-0.0.1-SNAPSHOT/IAPPService.json"));

			IAPPService userService = ProxyUtil.createClientProxy(
					Thread.currentThread().getContextClassLoader(),
			    IAPPService.class,
			    client);

		
		System.err.println(userService.isCorrect("true"));
		System.err.println(userService.getMelodie());

		
	}
}
