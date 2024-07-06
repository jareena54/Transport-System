package FindManager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import managerCreation.Managerbean;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/adminduty")
public class MaangerFinding extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Managerbean m = FindMAnagerDAO.findmanager(request);
		ServletContext s = request.getServletContext();
		s.setAttribute("bean", m);
		request.setAttribute("managerbean", m);
		response.setContentType("text/html");
		PrintWriter w = response.getWriter();
		  if (m != null) {
	            RequestDispatcher req = request.getRequestDispatcher("mangercompletedetails.jsp");
		        req.forward(request, response);
	        } else {
	        	w.println("No...Manager Available with this name and Branch....!");
	        	RequestDispatcher req = request.getRequestDispatcher("AdminFunctionlitys.html");
		        req.include(request, response);
	          
	        }
	        
	        
	}
}
