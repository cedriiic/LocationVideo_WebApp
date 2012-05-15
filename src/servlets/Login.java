package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.location.pojo.Client;
import fr.epsi.location.pojo.Location;
import fr.epsi.location.pojo.Video;
import fr.epsi.location.remote.ILocation;

public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
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
				location = ServiceJNDI.getBeanFromContext();
	    		Client client = location.getClientParIdentifiants(email,password); 
				if(client != null) {
					//List<Video> listeVideos = location.getListeVideos();
					session = request.getSession();
					session.setAttribute("client", client);
					//request.setAttribute("listeVideos", listeVideos);
					System.out.println("coucou1");
					request.getRequestDispatcher("nouveautes").forward(request, response);
				}
				else {
					request.setAttribute("email", email);
					request.setAttribute("password", password);
					request.setAttribute("erreur", "Login et/ou mot de passe incorrect");
					getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("email", email);
				request.setAttribute("password", password);
				request.setAttribute("message", e.getMessage());
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
	}

}
