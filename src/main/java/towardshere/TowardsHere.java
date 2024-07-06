package towardshere;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import TruckCreation.Truckbean;
@WebServlet("/towardshere")
public class TowardsHere extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Truckbean> towards = Towardsheree.gettowards(request);
		response.setContentType("text/html");
		PrintWriter w = response.getWriter();
		request.setAttribute("bean", towards);
		
		if(towards!=null) {
			
			RequestDispatcher re = request.getRequestDispatcher("towards.jsp");
			re.forward(request, response);
		}
		else {
			w.println("the truck location not found");
			RequestDispatcher re = request.getRequestDispatcher("Towardshere.html");
			re.include(request, response);
		}
		
		
	}

}
