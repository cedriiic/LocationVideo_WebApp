package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.location.pojo.Client;
import fr.epsi.location.pojo.Location;
import fr.epsi.location.remote.ILocation;

public class Historique extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ILocation location;
	private HttpSession session;
	
    public Historique() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			session = request.getSession();
			Client client = (Client) session.getAttribute("client");
			location = ServiceJNDI.getBeanFromContext();
			List<Location> listeLocations = location.getListeLocationsDuClient(client.getId());			
			request.setAttribute("listeLocations", listeLocations);
			System.out.println("taille : "+listeLocations.size());
			getServletContext().getRequestDispatcher("/historique.jsp").forward(request, response);
		} catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "<span style=\"font-weight:bold; color:red; font-size:18px\">"+e.getMessage()+"</span>");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
