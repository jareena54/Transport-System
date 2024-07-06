package SerachTruck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import TruckCreation.Truckbean;
import adminLogin.Connectioncl;
import jakarta.servlet.http.HttpServletRequest;

public class SerachTruckDAO {
	static Truckbean t=null;
	public static Truckbean serachtruck(HttpServletRequest req) {
		
		Connection con = Connectioncl.getcon();
		try {
		PreparedStatement stmt = con.prepareStatement("select*from TRUCKCREATION where TRUCKMODEL=?");
		stmt.setString(1, req.getParameter("truck"));
		ResultSet re = stmt.executeQuery();
		while(re.next()) {
			t=new Truckbean();
			t.setTruckmodel(re.getString(1));
			t.setTruckno(re.getInt(2));
			t.setInsurecnce(re.getString(3));
			t.setCmpname(re.getString(4));
			t.setOwner(re.getString(5));
			t.setMobileno(re.getLong(6));
			t.setRoute_from(re.getString(7));
t.setRoute_to(re.getString(8));			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return t;
	}

}
