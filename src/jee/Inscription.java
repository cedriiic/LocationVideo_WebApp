package jee;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_JNDI_NAME="ILocation/remote";
	
    public Inscription() {
        super();
    }

    public void init() {
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom	 			= (String) request.getAttribute("nom");
		String prenom 			= (String) request.getAttribute("prenom");
		DateFormat df 			= new SimpleDateFormat("dd/MM/yyyy");
		Date datedenaissance;
		try {
			datedenaissance = (Date) df.parse((String) request.getAttribute("datedenaissance"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String adresse			= (String) request.getAttribute("adresse");
		String ville			= (String) request.getAttribute("ville");
		String codepostal 		= (String) request.getAttribute("codepostal");
		String pays				= (String) request.getAttribute("pays");
		String telephone		= (String) request.getAttribute("telephone");
		String login 			= (String) request.getAttribute("login");
		String password			= (String) request.getAttribute("password");
		String password2		= (String) request.getAttribute("password2");
		String email			= (String) request.getAttribute("email");
		
		try{
			
		}
		catch(Exception e) {
			request.setAttribute("nom", nom);
			request.setAttribute("prenom", prenom);
			request.setAttribute("datedenaissance", datedenaissance);
			request.setAttribute("adresse", adresse);
			request.setAttribute("ville", ville);
			request.setAttribute("codepostal", codepostal);
			request.setAttribute("pays",pays);
			request.setAttribute("telephone", telephone);
			request.setAttribute("login", login);
			request.setAttribute("password", password);
			request.setAttribute("password2", password2);
			request.setAttribute("email", email);
			request.setAttribute("message", "pas ok!");
			getServletContext().getRequestDispatcher("/formulaireInscription.jsp").forward(request, response);
		}
	}

}
