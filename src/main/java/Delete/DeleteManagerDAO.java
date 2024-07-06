package Delete;

import java.sql.Connection;
import java.sql.PreparedStatement;

import adminLogin.Connectioncl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import managerCreation.Managerbean;

public class DeleteManagerDAO {
	public static int managerDeletr(HttpServletRequest request) {
		ServletContext ser = request.getServletContext();
		Managerbean m=(Managerbean)ser.getAttribute("bean");
	
		Connection con = Connectioncl.getcon();
		int ex=0;
		
		try {
		PreparedStatement st = con.prepareStatement("delete from manager where USERNAME=?");
		st.setString(1,m.getUsername() );
		ex = st.executeUpdate();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ex;
		
	}

}
