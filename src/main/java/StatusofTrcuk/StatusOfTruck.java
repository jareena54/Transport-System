package StatusofTrcuk;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import RecentlyInstalledTrucks.RecentlytruckDAO;
import TruckCreation.Truckbean;
@WebServlet("/Status")
public class StatusOfTruck extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
			ArrayList<Truckbean> tbean = statusDAO.getstatus();
			request.setAttribute("truckbean", tbean);
			if(tbean!=null) {
				RequestDispatcher re = request.getRequestDispatcher("status.jsp");
				re.forward(request, response);
			}
			else {
				RequestDispatcher re = request.getRequestDispatcher("notrucks.jsp");
				re.include(request, response);
			}
			System.out.println(tbean);
			
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
