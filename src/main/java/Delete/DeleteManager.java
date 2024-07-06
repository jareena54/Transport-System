package Delete;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import managerCreation.Managerbean;
@WebServlet("/Managerdeleting")
public class DeleteManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int m = DeleteManagerDAO.managerDeletr(request);
		response.setContentType("text/html");
		PrintWriter w = response.getWriter();
		
		ServletContext ser = request.getServletContext();
		Managerbean m1=(Managerbean)ser.getAttribute("bean");
		if(m>0) {
			w.println("The manager "+m1.getUsername()+" has been deleted");
			RequestDispatcher re = request.getRequestDispatcher("AdminFunctionlitys.html");
			re.include(request, response);
		}
		else 
		{
			w.println("not deleted");
			RequestDispatcher re = request.getRequestDispatcher("AdminFunctionlitys.html");
			re.include(request, response);
		}

	}
}
