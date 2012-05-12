package jee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.location.pojo.Client;
import fr.epsi.location.pojo.Video;
import fr.epsi.location.remote.ILocation;

public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_JNDI_NAME = "LocationBean/remote";
    private HttpSession session;
	private ILocation location;
    
    public Login() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email.isEmpty() || password.isEmpty()) {
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			request.setAttribute("erreur", "Vous devez remplir les deux champs");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else {
			try {  		
				System.setProperty("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
	    	    System.setProperty(" java.naming.factory.url.pkgs"," org.jboss.naming.org.jnp.interfaces");
	    	    System.setProperty("java.naming.provider.url", "localhost:1099");
	    	    				   	    
				Context context= new InitialContext();
	    		Object obj= context.lookup(DEFAULT_JNDI_NAME);
	    		location = (ILocation)PortableRemoteObject.narrow(obj, ILocation.class);
			    
	    		//Client client = location.getClientParIdentifiants(email,password); 
	    		
	    		//if(client != null) {
	    		if(1 == 1) {
					//session.setAttribute("liste", liste.size());
					//location.ajouterClient(client);
					List<Video> listeVideos = location.getListeVideos();
					
					//session.setAttribute("client", client.getNom());
					request.setAttribute("listeVideos", listeVideos);
					getServletContext().getRequestDispatcher("/listeVideos.jsp").forward(request, response);
				}
				else {
					request.setAttribute("email", email);
					request.setAttribute("password", password);
					request.setAttribute("erreur", "Login et/ou mot de passe incorrect");
					getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				}
			}catch(ClassCastException cce){
				cce.printStackTrace();
			}catch(NamingException ne){
				ne.printStackTrace();
			}
		}
	}

}
