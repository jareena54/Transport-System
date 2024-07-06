package updaatingstatus;

import java.io.IOException;
import java.io.PrintWriter;

import TruckCreation.Truckbean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/method")
public class Updatingstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		String modelno = request.getParameter("truckmodelno");
	
		Truckbean t=new Truckbean();
		t.setStatus(status);
		
		t.setTruckmodel(modelno);
		int c = UpdateStausDAO.updateStatus(t);
		PrintWriter w = response.getWriter();
		response.setContentType("text/html");
		System.out.println(c);
		if(c>0) {
			w.println("The status of the truck updated");
			request.getRequestDispatcher("Status").include(request, response);
		}
		else {
			w.println("status of the truck not updated try again to update");
			RequestDispatcher re = request.getRequestDispatcher("value.jsp");
			re.include(request, response);
		}
		
		
	}

}
