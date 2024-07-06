package Contactus;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/contactus")
public class ContactUs extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name1");
		String email = request.getParameter("emailtype");
		String pno = request.getParameter("phonetype");
		long phone = Long.parseLong(pno);
		String meassage = request.getParameter("meassage");
		Contactbean c=new Contactbean();
		c.setName(name);
		c.setPhoneno(phone);
		c.setEmail(email);
		c.setMeassage(meassage);
		
		int c1 = ContactUsDAO.contact(c);
		
		PrintWriter w = response.getWriter();
		if(c1>0) {
			w.println("inserteed the contact details");
		}
		else {
			w.println("try insert the data again");
		}
		
		
	}

}
