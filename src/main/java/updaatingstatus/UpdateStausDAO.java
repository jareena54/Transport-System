package updaatingstatus;

import java.sql.Connection;
import java.sql.PreparedStatement;

import TruckCreation.Truckbean;
import adminLogin.Connectioncl;

public class UpdateStausDAO {
	public static int updateStatus(Truckbean t) {
		
		Connection con = Connectioncl.getcon();
		int x = 0;
		try {
			PreparedStatement st = con.prepareStatement("update truckcreation set  STATUS=? where TRUCKMODEL =?");
			System.out.println(t.getStatus());
			System.out.println(t.getTruckmodel());
			st.setString(1, t.getStatus());
			st.setString(2, t.getTruckmodel());
			x = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

}
