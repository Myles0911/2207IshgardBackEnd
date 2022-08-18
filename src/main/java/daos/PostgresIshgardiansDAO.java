package daos;

import entities.Ishgardians;
import utils.connectionUtil;

import java.sql.*;

public class PostgresIshgardiansDAO  implements IshgardiansDAO {

    @Override
    public Ishgardians createIshgardians(Ishgardians ishgardians) {
        try(Connection conn = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = "insert into Ishgardians (name, password, role) values(?,?,?,?) ";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ishgardians.getName());
            ps.setString(2, ishgardians.getPassword());
            ps.setString(3,ishgardians.getRole());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int key = rs.getInt("user_id");
            ishgardians.setUserid(key);
            return ishgardians;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
}
