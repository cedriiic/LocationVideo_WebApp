package servlets;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.location.pojo.Categorie;
import fr.epsi.location.pojo.Video;
import fr.epsi.location.remote.ILocation;

public class Nouveautes extends HttpServlet{

    private HttpSession session;
	private ILocation location;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			location = ServiceJNDI.getBeanFromContext();
    		
    		List<Video> listeVideos = location.getListeNouveautesVideos();
    		request.setAttribute("listeVideos", listeVideos);
    		
    		getServletContext().getRequestDispatcher("/nouveautes.jsp").forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			location = ServiceJNDI.getBeanFromContext();
    		
    		List<Video> listeVideos = location.getListeNouveautesVideos();
    		request.setAttribute("listeVideos", listeVideos);
    		
    		getServletContext().getRequestDispatcher("/nouveautes.jsp").forward(request, response);
		}
		catch(UndeclaredThrowableException e){
			e.printStackTrace();
		}
	}
}
