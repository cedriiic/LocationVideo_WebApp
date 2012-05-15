package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.location.pojo.Video;
import fr.epsi.location.remote.ILocation;

/**
 * Servlet implementation class Top10
 */
public class Top10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private ILocation location;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Top10() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			location = ServiceJNDI.getBeanFromContext();
    		
    		List<Video> listeVideos = location.getTop10Videos();
    		request.setAttribute("listeVideos", listeVideos);
    		
    		getServletContext().getRequestDispatcher("/top10.jsp").forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
