package mangerlogin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import managerCreation.Managerbean;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/mangerLoginform")
public class ManagerLoginpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Managerbean mangerlogin = ManagerDAO.mangerlogin(request);
		PrintWriter w = response.getWriter();
		response.setContentType("text/html");
		if(mangerlogin!=null) {
			RequestDispatcher re = request.getRequestDispatcher("AdminFunctionlitys.html");
			re.forward(request, response);
		}
		
		else {
			w.println("userName/password is incorrect try again");
			RequestDispatcher re = request.getRequestDispatcher("Homepage.html");
		re.include(request, response);
		
		
		}
		
		
		
	}

}
