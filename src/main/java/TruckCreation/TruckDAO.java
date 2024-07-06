package TruckCreation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import adminLogin.Connectioncl;

public class TruckDAO {
	public int addTruck(Truckbean t) {
		Connection con = Connectioncl.getcon();
		int eu=0;
		try {
		PreparedStatement st = con.prepareStatement("insert into truckcreation values(?,?,?,?,?,?,?,?,?)");
		st.setString(1, t.getTruckmodel());
		st.setInt(2,t.getTruckno());
		st.setString(3, t.getInsurecnce());
		st.setString(4, t.getCmpname());
		
		st.setString(5, t.getOwner());
		st.setLong(6, t.getMobileno());
		st.setString(7, t.getRoute_from());
		st.setString(8, t.getRoute_to());
		st.setDate(9, Date.valueOf(t.getAdddate()));
		eu = st.executeUpdate();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return eu;
	}

}
