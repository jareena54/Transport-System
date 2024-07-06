package Services;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import TruckCreation.Truckbean;
@WebServlet("/servicesdone")
public class services extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Truckbean> s = ServicesDAO.getservice(request);
		request.setAttribute("bean", s);
		PrintWriter w = response.getWriter();
		if(s!=null) {
			w.println("From the selected routes no.of trucks are avalilble");
			RequestDispatcher re = request.getRequestDispatcher("routeTruck.jsp");
			re.forward(request, response);
//			
		}
		else {
			w.println("From selected routes no trucks are avilable");
			RequestDispatcher re = request.getRequestDispatcher("Services.html");
			re.include(request, response);
		}
		
		
		
		
	}

}
