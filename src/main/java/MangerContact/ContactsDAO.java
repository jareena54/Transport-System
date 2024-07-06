package MangerContact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Contactus.Contactbean;
import adminLogin.Connectioncl;

public class ContactsDAO {

	public static ArrayList<Contactbean> getcontact() {
		ArrayList<Contactbean> a=new ArrayList<>();
		Contactbean b=null;
		Connection con = Connectioncl.getcon();
		try {
		PreparedStatement st = con.prepareStatement("select*from CONTACTDETAILS");
		ResultSet re = st.executeQuery();
		
		while(re.next()) {
			
			b=new Contactbean();
			b.setName(re.getString(1));
			b.setEmail(re.getString(2));
			b.setPhoneno(re.getLong(3));
			b.setMeassage(re.getString(4));
			a.add(b);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
}
