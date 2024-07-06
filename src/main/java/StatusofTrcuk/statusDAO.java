package StatusofTrcuk;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import TruckCreation.Truckbean;
import adminLogin.Connectioncl;

public class statusDAO {
	public static ArrayList<Truckbean> getstatus() {
		ArrayList<Truckbean>li=new ArrayList<Truckbean>();
		Connection con = Connectioncl.getcon();
		
		try {
		PreparedStatement st = con.prepareStatement("select*from TRUCKCREATION");
		ResultSet ex = st.executeQuery();
		
		while(ex.next()) {
			Truckbean	t=new Truckbean();
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
			li.add(t);
		}
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return li;
		
		
	}

}
