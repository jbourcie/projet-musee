package fr.irisa.aapweb;

import com.googlecode.jsonrpc4j.JsonRpcService;


//curl -i -X POST -d '{"jsonrpc": "2.0", "method": "getMelodie", "params": {}, "id": 1}' http://localhost:8080//aapweb-0.0.1-SNAPSHOT/IAPPService.json
//curl -i -X POST -d '{"jsonrpc": "2.0", "method": "isCorrect", "params": ["true"], "id": 1}' http://localhost:8080//aapweb-0.0.1-SNAPSHOT/IAPPService.json
//curl -i -X POST -d '{"jsonrpc": "2.0", "method": "getMelodie", "params": {}, "id": 1}' http://sd-35000.dedibox.fr:8888//aapweb/IAPPService.json
	//curl -i -X POST -d '{"jsonrpc": "2.0", "method": "isCorrect", "params": ["true"], "id": 1}' http://sd-35000.dedibox.fr:8888/aapweb/IAPPService.json


@JsonRpcService("IAPPService")
public interface IAPPService {

	
    boolean isCorrect(String message);
    

    
    String getMelodie();
}

