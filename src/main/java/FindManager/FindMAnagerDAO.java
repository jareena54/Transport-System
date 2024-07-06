package FindManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;

import adminLogin.Connectioncl;
import jakarta.servlet.http.HttpServletRequest;
import managerCreation.Managerbean;

public class FindMAnagerDAO {
	public static Managerbean findmanager(HttpServletRequest req) {
		Managerbean m=null;
		Connection con = Connectioncl.getcon();
		try {
		PreparedStatement st = con.prepareStatement("select*from manager where BRANCH=? and USERNAME=?");
		st.setString(1, req.getParameter("branch"));
		st.setString(2, req.getParameter("manager"));
		ResultSet ex = st.executeQuery();
		while(ex.next()) {
			m=new Managerbean();
			m.setBranch(ex.getString(1));
			m.setUsername(ex.getString(2));
			m.setPassword(ex.getInt(3));
		
		 Date dojDate = ex.getDate("DOJ");
		  LocalDate doj = (dojDate != null) ? dojDate.toLocalDate() : null;
          m.setDate_of_joining(doj);
	
	  Date dobDate = ex.getDate("DOB");
      LocalDate dob = (dobDate != null) ? dobDate.toLocalDate() : null;
      m.setDate_of_birth(dob);
      m.setSal(ex.getDouble(6));
		
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return m;
	}

}
