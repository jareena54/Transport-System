package Services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import TruckCreation.Truckbean;
import adminLogin.Connectioncl;
import jakarta.servlet.http.HttpServletRequest;

public class ServicesDAO {
	public static ArrayList<Truckbean> getservice(HttpServletRequest req) {
		Connection con = Connectioncl.getcon();
		Truckbean t=null;
		ArrayList<Truckbean> list=new ArrayList<>();
		try {
		PreparedStatement st = con.prepareStatement("select*from truckcreation where ROUTEFROM=? and ROUTETO=?");
		st.setString(1, req.getParameter("RouteFrom"));
		st.setString(2, req.getParameter("Routeto"));
		ResultSet ex = st.executeQuery();
		
		while(ex.next()) {
			t=new Truckbean();
			t.setTruckmodel(ex.getString(1));
			t.setTruckno(ex.getInt(2));
			t.setInsurecnce(ex.getString(3));
			t.setCmpname(ex.getString(4));
			t.setOwner(ex.getString(5));
			t.setMobileno(ex.getLong(6));
			t.setRoute_from(ex.getString(7));
			t.setRoute_to(ex.getString(8));
			Date d = ex.getDate(9);
			LocalDate v=(d!=null)?d.toLocalDate():null;
			t.setAdddate(v);
			t.setStatus(ex.getString(10));
			list.add(t);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		return list;
	}
	

}
