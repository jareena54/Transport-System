package RecentlyInstalledTrucks;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import TruckCreation.Truckbean;
import adminLogin.Connectioncl;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;

public class RecentlytruckDAO {
	public static ArrayList<Truckbean> getrecentlyinstalled(HttpServletRequest re) {
		ArrayList<Truckbean> li = new ArrayList<Truckbean>();

		Connection con = Connectioncl.getcon();

		try {
			PreparedStatement st = con.prepareStatement("select*from truckcreation where DOC between to_date(?,'dd-mm-yy') and to_date(?,'dd-mm-yy')");

			String pa = re.getParameter("date1");
			LocalDate l = LocalDate.parse(pa);
			Date v1 = Date.valueOf(l);
			st.setDate(1, v1);
			String date = re.getParameter("date2");
			LocalDate lo = LocalDate.parse(date);
			Date va = Date.valueOf(lo);
			st.setDate(2, va);

			ResultSet ex = st.executeQuery();

			while (ex.next()) {
				Truckbean t = new Truckbean();
				t.setTruckmodel(ex.getString(1));
				t.setTruckno(ex.getInt(2));
				t.setInsurecnce(ex.getString(3));

				t.setCmpname(ex.getString(4));
				t.setOwner(ex.getString(5));
				t.setMobileno(ex.getLong(6));
				t.setRoute_from(ex.getString(7));
				t.setRoute_to(ex.getString(8));
				Date d = ex.getDate(9);
				LocalDate v = (d != null) ? d.toLocalDate() : null;
				t.setAdddate(v);
				li.add(t);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;

	}

}
