package adminLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.http.HttpServletRequest;

public class AdminDAo {
	public static userbean adminlogin(HttpServletRequest req){
		Connection con = Connectioncl.getcon();
		userbean u=null;
		try {
		PreparedStatement st = con.prepareStatement("select*from adminlogin  where Name=? and PASSWORD=?");
	
		st.setString(1, req.getParameter("adminname"));
		st.setString(2, req.getParameter("password"));
		ResultSet ex = st.executeQuery();
		while(ex.next()) 
		{
			u=new userbean();
			
			u.setName(ex.getString(1));
			u.setId(ex.getString(2));
		
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}

}
