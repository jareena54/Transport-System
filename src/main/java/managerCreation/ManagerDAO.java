package managerCreation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import adminLogin.Connectioncl;

public class ManagerDAO {
    public static int addmanager(Managerbean m) {
        Connection con = Connectioncl.getcon();
        int ex = 0;
        try {
            PreparedStatement st = con.prepareStatement("INSERT INTO manager values(?,?,?,?,?,?) ");
            st.setString(1, m.getBranch());
            st.setString(2, m.getUsername());
            st.setInt(3, m.getPassword());
            st.setDate(4, Date.valueOf(m.getDate_of_joining())); 
            st.setDate(5, Date.valueOf(m.getDate_of_birth())); 
            st.setDouble(6, m.getSal());
            ex = st.executeUpdate();
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return ex;
    }
}
