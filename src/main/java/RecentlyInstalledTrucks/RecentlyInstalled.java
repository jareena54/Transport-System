package RecentlyInstalledTrucks;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import TruckCreation.Truckbean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/recentlyins")
public class RecentlyInstalled extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Truckbean> tbean = RecentlytruckDAO.getrecentlyinstalled(request);
		request.setAttribute("truckbean", tbean);
		if(tbean!=null) {
			RequestDispatcher re = request.getRequestDispatcher("recentlyinstalled.jsp");
			re.forward(request, response);
		}
		else {
			RequestDispatcher re = request.getRequestDispatcher("notrucks.jsp");
			re.include(request, response);
		}
		
	}
}
