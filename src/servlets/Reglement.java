package servlets;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arjuna.ats.arjuna.recovery.Service;

import fr.epsi.location.pojo.Client;
import fr.epsi.location.pojo.Exemplaire;
import fr.epsi.location.pojo.Location;
import fr.epsi.location.pojo.TypePaiement;
import fr.epsi.location.pojo.Video;
import fr.epsi.location.remote.ILocation;

public class Reglement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ILocation location;
	private HttpSession session;
       
    public Reglement() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String typePaiement = request.getParameter("typePaiement");
			session = request.getSession();
			location = ServiceJNDI.getBeanFromContext();
			TypePaiement tp = location.getTypePaiement(typePaiement);
			
			List<Video> panier = (List<Video>) session.getAttribute("panier");
			for(Video v : panier) {
				 List<Exemplaire> listeExemplaires = location.getListeExemplairesParVideo(v.getId());
				 int indice = (int) Math.floor((Math.random() * listeExemplaires.size()));
				 Exemplaire exemplaire = listeExemplaires.get(indice);
				 			 
				 java.util.Date dateDuJour = new java.util.Date();
				 long t = dateDuJour.getTime();
				 java.sql.Date sqlDateDuJour = new java.sql.Date(t);
				 Location l = new Location(exemplaire, sqlDateDuJour, v.getPrix(), 24, tp);
				 Client client = (Client) session.getAttribute("client");
				 l.setClient(client);
				 location.ajouterLocation(l);
			}
			request.setAttribute("message", "<span style=\"font-weight:bold; color:#3A9D23; font-size:18px\">Règlement effectué !</span>");
			session.removeAttribute("panier");
			List<Video> listeVideos = location.getListeNouveautesVideos();
    		request.setAttribute("listeVideos", listeVideos);
    		
    		getServletContext().getRequestDispatcher("/nouveautes.jsp").forward(request, response);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "<span style=\"font-weight:bold; color:red; font-size:18px\">"+e.getMessage()+"</span>");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
