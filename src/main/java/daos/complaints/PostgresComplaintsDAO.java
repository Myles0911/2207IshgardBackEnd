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
            String sql = "insert into complaints values (default, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, complaints.getDescription());
            preparedStatement.setString(2, complaints.getStatus());
            preparedStatement.setInt(3, complaints.getMeeting_id());

            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();

            int generatedKey = rs.getInt("complaint_id");
            complaints.setId(generatedKey);
            return complaints;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Complaints> getAllComplaints() {
        try(Connection connection = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = "select * from Complaints";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Complaints> complaintsList = new ArrayList();
            while(rs.next()) {
                Complaints complaints = new Complaints();
                complaints.setId(rs.getInt("complaint_id"));
                complaints.setDescription(rs.getString("description"));
                complaints.setStatus(rs.getString("status"));
                complaints.setMeeting_id(rs.getInt("meeting_id"));
                complaintsList.add(complaints);
            }

            return complaintsList;
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public Complaints getComplaintById(int id) {

        try (Connection connection = connectionUtil.ConnectionUtil.createConnection()){
            String sql = "select * from Complaints where complaint_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Complaints complaints = new Complaints();
            complaints.setId(rs.getInt("complaint_id"));
            complaints.setDescription(rs.getString("description"));
            complaints.setStatus(rs.getString("status"));
            complaints.setMeeting_id(rs.getInt("meeting_id"));
            return complaints;


        } catch (SQLException sqlException) {
        sqlException.printStackTrace();
            return null;
    }
    }
}







