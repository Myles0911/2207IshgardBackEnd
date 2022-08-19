package daos.complaints;

import entities.Complaints;
import utils.connectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresComplaintsDAO implements ComplaintsDAO {

    @Override
    public Complaints createComplaints(Complaints complaints) {
        try(Connection conn = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = "insert into Complaints (description, status, meeting_id) values(?,?,?) ";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, complaints.getDescription());
            ps.setString(2, complaints.getStatus());
            ps.setInt(3,complaints.getMeeting_id());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int key = rs.getInt("complaint_id");
            complaints.setComplain_id(key);
            return complaints;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Complaints> getAllComplaints() {
        try(Connection connection = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = "select * from complaints";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Complaints> complaintsList = new ArrayList();
            while(rs.next()) {
                Complaints complaints = new Complaints();
                complaints.setComplain_id(rs.getInt("complaint_id"));
                complaints.setDescription(rs.getString("description"));
                complaints.setStatus(rs.getString("status"));
                complaints.setMeeting_id(rs.getInt());
            }
        }
    }

    @Override
    public Complaints getComplaintById(int complain_id) {
        return null;
    }
}

