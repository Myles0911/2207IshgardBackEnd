package dev.walker.daos.complaints;

import dev.walker.entities.Complaints;
import dev.walker.entities.Status;
import dev.walker.utils.connectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresComplaintsDAO implements ComplaintsDAO {

    @Override
    public Complaints createComplaints(Complaints complaints) {
        try(Connection conn = connectionUtil.createConnection()) {
            String sql = "insert into complaints values (default, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, complaints.getDescription());
            preparedStatement.setString(2, Status.UNREVIEWED.name());
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
        try(Connection connection = connectionUtil.createConnection()) {
            String sql = "select * from Complaints";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Complaints> complaintsList = new ArrayList();
            while(rs.next()) {
                Complaints complaints = new Complaints();
                complaints.setId(rs.getInt("complaint_id"));
                complaints.setDescription(rs.getString("description"));
                complaints.setStatus(Status.valueOf(rs.getString("status")));
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
    public Complaints createComplaintByMeeting(Complaints complaints, int meeting_id) {
        try(Connection conn = connectionUtil.createConnection()) {
            String sql = "update Complaints set meeting_id = ? where complaint_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, meeting_id);
            ps.setInt(2, complaints.getId());

            ps.executeUpdate();
            return complaints;

    } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Complaints> getStatus(Status stats) {
        try(Connection connection = connectionUtil.createConnection()) {
            String sql = "select * from Complaints status";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Complaints> complaintsList = new ArrayList();
            while(rs.next()) {
                Complaints complaints = new Complaints();
                complaints.setId(rs.getInt("complaint_id"));
                complaints.setDescription(rs.getString("description"));
                complaints.setStatus(Status.valueOf(rs.getString("status")));
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

        try (Connection connection = connectionUtil.createConnection()){
            String sql = "select * from Complaints where complaint_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Complaints complaints = new Complaints();
            complaints.setId(rs.getInt("complaint_id"));
            complaints.setDescription(rs.getString("description"));
            complaints.setStatus(Status.valueOf(rs.getString("status")));
            complaints.setMeeting_id(rs.getInt("meeting_id"));
            return complaints;


        } catch (SQLException sqlException) {
        sqlException.printStackTrace();
            return null;
    }



    }
}







