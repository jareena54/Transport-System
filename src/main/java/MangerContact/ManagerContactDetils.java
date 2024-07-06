package MangerContact;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Contactus.Contactbean;

@WebServlet("/contacteddetails")
public class ManagerContactDetils extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ArrayList<Contactbean> de = ContactsDAO.getcontact();
		PrintWriter w = response.getWriter();
		request.setAttribute("bean0", de);
		if(de !=null) {
			
			RequestDispatcher re = request.getRequestDispatcher("returndetatils.jsp");
			re.forward(request, response);
		}
		else {
			w.println("the data get");
		}
		
		
	}

}
