package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.location.pojo.Categorie;
import fr.epsi.location.pojo.Video;
import fr.epsi.location.remote.ILocation;

public class Categories extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ILocation location;
    
    public Categories() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			location = ServiceJNDI.getBeanFromContext();
			List<Categorie> listeCategories = (List<Categorie>) location.getListeCategories();
			List<Video> listeVideos = (List<Video>) location.getListeVideos();
			
			request.setAttribute("listeCategories", listeCategories);
			request.setAttribute("listeVideos", listeVideos);
			
			getServletContext().getRequestDispatcher("/categories.jsp").forward(request, response);
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idCategorie = Integer.parseInt(request.getParameter("choix_categorie"));
			location = ServiceJNDI.getBeanFromContext();
			
			List<Video> listeVideos = new ArrayList<Video>();
			if(idCategorie == -1)
				listeVideos = (List<Video>) location.getListeVideos();
			else
				listeVideos = (List<Video>) location.getListeVideosParCategorie(idCategorie);
			List<Categorie> listeCategories = (List<Categorie>) location.getListeCategories();
			
			request.setAttribute("listeVideos", listeVideos);
			request.setAttribute("listeCategories", listeCategories);
			request.setAttribute("idCategorie", idCategorie);
			
			getServletContext().getRequestDispatcher("/categories.jsp").forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "<span style=\"font-weight:bold; color:red; font-size:18px\">"+e.getMessage()+"</span>");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
