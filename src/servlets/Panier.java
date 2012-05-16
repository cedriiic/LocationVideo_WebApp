package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.location.pojo.Video;
import fr.epsi.location.remote.ILocation;

public class Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ILocation location;
	private HttpSession session;
   
    public Panier() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String etape = request.getParameter("etape");
		String typePaiement = request.getParameter("typePaiement");
		
		request.setAttribute("etape", etape);
		if(typePaiement != null)
			request.setAttribute("typePaiement", typePaiement);
		getServletContext().getRequestDispatcher("/panier.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		session = request.getSession();
		List<Video> panier;
		if(session.getAttribute("panier") != null) 
			panier = (List<Video>) session.getAttribute("panier");
		else 
			panier = new ArrayList<Video>();
		
		if(action.equals("ajout")) {
			try {
				int idVideo = Integer.parseInt(request.getParameter("idVideo"));
				location = ServiceJNDI.getBeanFromContext();
				
				boolean existeDansLePanier = false;
				for(Video v : panier) {
					if(v.getId() == idVideo)
						existeDansLePanier = true;
				}
				
				if(existeDansLePanier)
					request.setAttribute("message", "<span style=\"font-weight:bold; color:red; font-size:18px\">Vidéo déjà dans le panier !</span>");
				else {
					Video video = location.getVideo(idVideo);
					panier.add(video);
					request.setAttribute("message", "<span style=\"font-weigh:bold; color:#3A9D23; font-size:18px\">Vidéo ajouté au panier !</span>");
				}
					
				session.setAttribute("panier", panier);
				getServletContext().getRequestDispatcher("/nouveautes").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("message", "<span style=\"font-weigh:bold; color:#3A9D23; font-size:18px\">"+e.getMessage()+"</span>");
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		else if(action.equals("suppression")){
			if(panier != null) {
				int idVideo = Integer.parseInt(request.getParameter("idVideo"));
				int i=0;
				
				while(i < panier.size() && panier.get(i).getId() != idVideo) {
					i++;
				}

				if(panier.get(i).getId() == idVideo)
					panier.remove(i);
				
				session.setAttribute("panier", panier);
				request.setAttribute("message", "<span style=\"font-weight:bold; color:red; font-size:18px\">Vidéo supprimé du panier!</span>");
				getServletContext().getRequestDispatcher("/panier.jsp").forward(request, response);
			} 
		}
	}

}
