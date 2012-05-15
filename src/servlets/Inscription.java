package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.location.pojo.Client;
import fr.epsi.location.remote.ILocation;

public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ILocation location;
	
    public Inscription() {
        super();
    }

    public void init() {
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom	 			= request.getParameter("nom");
		String prenom 			= request.getParameter("prenom");
		String sDatedenaissance = request.getParameter("datedenaissance");
		String adresse			= request.getParameter("adresse");
		String ville			= request.getParameter("ville");
		String codepostal 		= request.getParameter("codepostal");
		String pays				= request.getParameter("pays");
		String telephone		= request.getParameter("telephone");
		String password			= request.getParameter("password");
		String password2		= request.getParameter("password2");
		String email			= request.getParameter("email");

		String message = verifierChamps(nom, prenom, sDatedenaissance, adresse, ville, codepostal, pays, telephone, password, password2, email);
		
		if(message == null) {
			
			try{
				Date datedenaissance 	= convertStringToDate(sDatedenaissance);
				location = ServiceJNDI.getBeanFromContext();
	    		Client client = new Client(nom, prenom, datedenaissance, adresse, ville, codepostal, pays, telephone, email, password, null);
	    		location.ajouterClient(client);
	    		
	    		request.setAttribute("etatInsertion", "ok");
	    		request.setAttribute("message", "Inscription effectuée.");
	    		getServletContext().getRequestDispatcher("/formulaireInscription.jsp").forward(request, response);
			}
			catch(Exception e) {
				e.printStackTrace();
				request.setAttribute("nom", nom);
				request.setAttribute("prenom", prenom);
				request.setAttribute("datedenaissance", sDatedenaissance);
				request.setAttribute("adresse", adresse);
				request.setAttribute("ville", ville);
				request.setAttribute("codepostal", codepostal);
				request.setAttribute("pays",pays);
				request.setAttribute("telephone", telephone);
				request.setAttribute("password", password);
				request.setAttribute("password2", password2);
				request.setAttribute("email", email);
				request.setAttribute("etatInsertion", "erreur");
				request.setAttribute("message", message);
			}
		}
		else {
			request.setAttribute("nom", nom);
			request.setAttribute("prenom", prenom);
			request.setAttribute("datedenaissance", sDatedenaissance);
			request.setAttribute("adresse", adresse);
			request.setAttribute("ville", ville);
			request.setAttribute("codepostal", codepostal);
			request.setAttribute("pays",pays);
			request.setAttribute("telephone", telephone);
			request.setAttribute("password", password);
			request.setAttribute("password2", password2);
			request.setAttribute("email", email);
			request.setAttribute("etatInsertion", "erreur");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/formulaireInscription.jsp").forward(request, response);
		}
	}

	private String verifierChamps(String nom, String prenom, String sDatedenaissance, String adresse, String ville, String codepostal, String pays, String telephone, String password, String password2, String email) {
		
		if(nom.isEmpty() || prenom.isEmpty() || sDatedenaissance.isEmpty() || adresse.isEmpty() || ville.isEmpty() || codepostal.isEmpty() || pays.isEmpty() || telephone.isEmpty() || password.isEmpty() || password2.isEmpty() || email.isEmpty())
			return "Veuillez renseigner tous les champs.";
		else if(!password.equals(password2))
			return "Les mots de passes saisis ne sont pas identiques";
		return null;
	}

	private Date convertStringToDate(String sDatedenaissance) {
		if(sDatedenaissance.length() == 10) {
			int jour = Integer.valueOf(sDatedenaissance.substring(0, 2)).intValue();
			int mois = Integer.valueOf(sDatedenaissance.substring(3, 5)).intValue();
			int annee = Integer.valueOf(sDatedenaissance.substring(6, 10)).intValue();
	
			return new Date(annee, mois, jour);
		}
		else
			return null;
	}

}
