package daos.meetings;

import entities.Meetings;
import utils.connectionUtil;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeetingsDAOPostgres implements MeetingsDAO {
    @Override
    public Meetings createMeetings(Meetings meetings) {
    try(Connection conn = connectionUtil.ConnectionUtil.createConnection()) {
        String sql = "insert into Meetings values(default, ?, ?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,meetings.getAddress());
        preparedStatement.setString(2, meetings.getSummary());
        preparedStatement.setInt(3,meetings.getTime());

        preparedStatement.execute();

        ResultSet rs = preparedStatement.getGeneratedKeys();
        rs.next();

        int generatedKey = rs.getInt("meeting_id");
        meetings.setMeeting_id(generatedKey);
        return meetings;

    } catch (
    SQLException sqlException) {
        sqlException.printStackTrace();
    }
        return null;
}

    @Override
    public List<Meetings> getAllComplaints() {
        try(Connection connection = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = "select * from Meetings";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Meetings> meetingsList = new ArrayList();

            while(rs.next()) {
                Meetings meetings = new Meetings();
                meetings.setMeeting_id(rs.getInt("meeting_id"));
                meetings.setAddress(rs.getString("address"));
                meetings.setSummary(rs.getString("summary"));
                meetings.setTime(rs.getInt("time"));
                meetingsList.add(meetings);
            }
            return meetingsList;
        } catch (SQLException sqlException) {
        sqlException.printStackTrace();
        }
        return null;
        }

}
