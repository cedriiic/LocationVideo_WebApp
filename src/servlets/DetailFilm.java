package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arjuna.ats.arjuna.recovery.Service;

import fr.epsi.location.pojo.Video;
import fr.epsi.location.remote.ILocation;

public class DetailFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ILocation location;
    private HttpSession session;
    
    public DetailFilm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int idVideo = Integer.parseInt(request.getParameter("idVideo"));
			session = request.getSession();
			location = ServiceJNDI.getBeanFromContext();
			Video video = location.getVideo(idVideo);
			
			request.setAttribute("video", video);
			getServletContext().getRequestDispatcher("/detailFilm.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
