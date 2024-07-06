package TruckCreation;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/truckcreate")
public class Truckcreation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Truckbean t = new Truckbean();

		t.setTruckmodel(request.getParameter("trcukmodel"));
		String truckno = request.getParameter("truckno");
		t.setTruckno(Integer.parseInt(truckno));
		t.setInsurecnce(request.getParameter("same"));
		String i = request.getParameter("same");
		if(i.equalsIgnoreCase("yes")) {
			
	t.setCmpname(request.getParameter("cmpname"));
		
		}
		
		t.setOwner(request.getParameter("owner"));
		String mobileno = request.getParameter("mobile");
		t.setMobileno(Long.parseLong(mobileno));
		t.setRoute_from(request.getParameter("routefrom"));
		t.setRoute_to(request.getParameter("Route-to"));
		String date = request.getParameter("dateadd");
		t.setAdddate(LocalDate.parse(date));
		TruckDAO tt=new TruckDAO();
		int truck = tt.addTruck(t);
		PrintWriter w = response.getWriter();
		if(truck>0) {
			w.println("registread");
		}
		else {
			w.println("not registered");
		}
	}
}
