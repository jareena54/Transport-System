package towardshere;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import TruckCreation.Truckbean;
import adminLogin.Connectioncl;
import jakarta.servlet.http.HttpServletRequest;

public class Towardsheree {
	public static List<Truckbean> gettowards(HttpServletRequest req) {
		Connection con = Connectioncl.getcon();
		List<Truckbean>list=null;
		Truckbean t=null;
		try {
		PreparedStatement st = con.prepareStatement("select*from truckcreation where ROUTETO=?");
		st.setString(1, req.getParameter("name"));
		
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
			list=new ArrayList<>();
			list.add(t);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
