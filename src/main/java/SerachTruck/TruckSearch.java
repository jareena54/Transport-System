package SerachTruck;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import TruckCreation.Truckbean;
@WebServlet("/truckserch")
public class TruckSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Truckbean t = SerachTruckDAO.serachtruck(request);
		response.setContentType("text/html");
		request.setAttribute("truckbean", t);
		PrintWriter w = response.getWriter();
		if(t!=null) {
			w.print("done");
			RequestDispatcher re = request.getRequestDispatcher("truckddestails.jsp");
		re.forward(request, response);
		
		}
		else {
			w.println("The TruckModel Number Truck is not Available");
			RequestDispatcher re = request.getRequestDispatcher("SearchTruck.html");
			re.include(request, response);
		}
		
		
		
	}

}
