package adminLogin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Loginform")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userbean u = AdminDAo.adminlogin(request);
		PrintWriter w = response.getWriter();
		
		if(u!=null) {
			w.println("login sucess");
			RequestDispatcher req = request.getRequestDispatcher("AdminFunctionlitys.html");
			req.forward(request, response);
			
		}
		else {
			RequestDispatcher req = request.getRequestDispatcher("loginasadmmin.html");
			req.include(request, response);
		}

	}

}
