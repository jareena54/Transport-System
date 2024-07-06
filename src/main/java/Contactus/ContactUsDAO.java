package Contactus;

import java.sql.Connection;
import java.sql.PreparedStatement;

import adminLogin.Connectioncl;

public class ContactUsDAO {
	public static int contact(Contactbean c) {
		Connection con = Connectioncl.getcon();
		int x=0;
		try {
		PreparedStatement st = con.prepareStatement("insert into contactdetails values(?,?,?,?)");
		st.setString(1,c.getName());
		st.setString(2, c.getEmail());
		st.setLong(3, c.getPhoneno());
	st.setString(4, c.getMeassage());
		x = st.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

}
