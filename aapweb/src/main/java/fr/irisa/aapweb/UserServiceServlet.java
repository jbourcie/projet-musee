package fr.irisa.aapweb;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.jsonrpc4j.JsonRpcServer;

public class UserServiceServlet 
    extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7761537674133167249L;
	private IAPPService userService;
    private JsonRpcServer jsonRpcServer;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
			jsonRpcServer.handle(req, resp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void init(ServletConfig config) {
        
       this.userService= new AAPServiceImpl();
		
        this.jsonRpcServer = new JsonRpcServer(this.userService, IAPPService.class);
    }

}