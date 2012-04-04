package jee;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if(login.isEmpty() || password.isEmpty()) {
			request.setAttribute("Erreur", "Vous devez remplir les deux champs");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else {
			// Vérifier identifiants
		}
	}

}
