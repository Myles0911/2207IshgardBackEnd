package dev.walker.daotests;

import dev.walker.daos.meetings.MeetingsDAO;
import dev.walker.daos.meetings.MeetingsDAOPostgres;
import dev.walker.entities.Meetings;
import org.junit.jupiter.api.*;
import dev.walker.utils.connectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MeetingsDAOTests {
    static MeetingsDAO meetingsDAO = new MeetingsDAOPostgres();

    @BeforeAll
    static void setup() {
        try (Connection conn = connectionUtil.createConnection()) {
            String sql = "create table Meetings(\n" +
                    "\tmeeting_id serial primary key,\n" +
                    "\taddress varchar(200),\n" +
                    "\tsummary varchar(200) ,\n" +
                    "\ttime long \n" +
                    ");";
            Statement statement = conn.createStatement();
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    void create_Meetings_test() {
        Meetings meetings = new Meetings(-1, "NONE", "The complaint has not been reviewed", 0);
        Meetings savedMeetings = meetingsDAO.createMeetings(meetings);
        Assertions.assertNotEquals(0, savedMeetings.getMeeting_id());
    }

    @Test
    @Order(2)
    void get_all_meetings_test() {
        Meetings meet1 = new Meetings(-1, "NONE", "The complaint has not been reviewed", 0);
        Meetings meet2 = new Meetings(1, "Forgotten Knight", "The Meeting has been scheduled at the Forgotten Knight", 11);
        meetingsDAO.createMeetings(meet1);
        meetingsDAO.createMeetings(meet2);

        List<Meetings> meetingsList = meetingsDAO.getAllComplaints();
        Assertions.assertEquals(2, meetingsList.size());
    }
}
