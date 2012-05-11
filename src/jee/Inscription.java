package jee;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.RTCORBA.maxPriority;

import fr.epsi.location.pojo.Client;
import fr.epsi.location.remote.ILocation;

public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_JNDI_NAME="LocationBean/remote";
	private ILocation location;
	
    public Inscription() {
        super();
    }

    public void init() {
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom	 			= (String) request.getParameter("nom");
		String prenom 			= (String) request.getParameter("prenom");
		String sDatedenaissance = (String) request.getParameter("datedenaissance");
		Date datedenaissance 	= convertStringToDate(sDatedenaissance);
		String adresse			= (String) request.getParameter("adresse");
		String ville			= (String) request.getParameter("ville");
		String codepostal 		= (String) request.getParameter("codepostal");
		String pays				= (String) request.getParameter("pays");
		String telephone		= (String) request.getParameter("telephone");
		String password			= (String) request.getParameter("password");
		String password2		= (String) request.getParameter("password2");
		String email			= (String) request.getParameter("email");
		
		try{
			System.setProperty("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
    	    System.setProperty(" java.naming.factory.url.pkgs"," org.jboss.naming.org.jnp.interfaces");
    	    System.setProperty("java.naming.provider.url", "localhost:1099");
    	    
			Context context= new InitialContext();
    		Object obj= context.lookup(DEFAULT_JNDI_NAME);
    		location = (ILocation)PortableRemoteObject.narrow(obj, ILocation.class);
    		Client client = new Client(nom, prenom, datedenaissance, adresse, ville, codepostal, pays, telephone, email, password, null);
    		location.ajouterClient(client);
    		request.setAttribute("etatInsertion", "ok");
    		request.setAttribute("message", "Inscription effectuée.");
		}
		catch(Exception e) {
			request.setAttribute("nom", nom);
			request.setAttribute("prenom", prenom);
			//request.setAttribute("datedenaissance", datedenaissance);
			request.setAttribute("adresse", adresse);
			request.setAttribute("ville", ville);
			request.setAttribute("codepostal", codepostal);
			request.setAttribute("pays",pays);
			request.setAttribute("telephone", telephone);
			request.setAttribute("password", password);
			request.setAttribute("password2", password2);
			request.setAttribute("email", email);
			request.setAttribute("etatInsertion", "erreur");
			request.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher("/formulaireInscription.jsp").forward(request, response);
		}
	}

	private Date convertStringToDate(String sDatedenaissance) {
		int jour = Integer.valueOf(sDatedenaissance.substring(0, 2)).intValue();
		int mois = Integer.valueOf(sDatedenaissance.substring(3, 5)).intValue();
		int annee = Integer.valueOf(sDatedenaissance.substring(6, 10)).intValue();

		return new Date(annee, mois, jour);
	}

}
