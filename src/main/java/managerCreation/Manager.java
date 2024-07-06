package managerCreation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;
@WebServlet("/Maangerrr")
public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Managerbean m=new Managerbean();
		m.setBranch(request.getParameter("branch"));
		m.setUsername(request.getParameter("username"));
		String s = request.getParameter("password");
		m.setPassword(Integer.parseInt(s));
		String doj = request.getParameter("date of joinig");
		m.setDate_of_joining(LocalDate.parse(doj));
		String dob = request.getParameter("date of birth");
		m.setDate_of_birth(LocalDate.parse(dob));
	String sal = request.getParameter("salary");
	m.setSal(Double.parseDouble(sal));
	int ma = ManagerDAO.addmanager(m);
	PrintWriter w = response.getWriter();
	if(ma>0) {
		w.println("inserted sucessfully");
	}
		
	}

}
