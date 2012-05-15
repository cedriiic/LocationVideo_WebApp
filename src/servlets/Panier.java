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
		
		request.setAttribute("etape", etape);
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
					request.setAttribute("message", "Vidéo déjà dans le panier !");
				else {
					Video video = location.getVideo(idVideo);
					panier.add(video);
					request.setAttribute("message", "Vidéo ajouté au panier !");
				}
					
				session.setAttribute("panier", panier);
				getServletContext().getRequestDispatcher("/nouveautes").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("message", e.getMessage());
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
				request.setAttribute("message", "Vidéo supprimé du panier!");
				getServletContext().getRequestDispatcher("/panier.jsp").forward(request, response);
			} 
		}
	}

}
