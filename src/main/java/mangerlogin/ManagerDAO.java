package mangerlogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import adminLogin.Connectioncl;
import jakarta.servlet.http.HttpServletRequest;
import managerCreation.Managerbean;

public class ManagerDAO {
	public static Managerbean mangerlogin(HttpServletRequest req) {
		Managerbean m=null;
		Connection con = Connectioncl.getcon();
		try {
		PreparedStatement s = con.prepareStatement("select*from manager where BRANCH=? and USERNAME=? and PASSWORD=?");
		s.setString(1, req.getParameter("branch"));
		s.setString(2, req.getParameter("name1"));
		String pword = req.getParameter("pword");
		s.setInt(3,Integer.parseInt(pword));
		ResultSet ex = s.executeQuery();
		while(ex.next()) {
			m=new Managerbean();
			m.setBranch(ex.getString(1));
			m.setUsername(ex.getString(2));
			m.setPassword(ex.getInt(3));
			
		}
		
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return m;
		}

}
