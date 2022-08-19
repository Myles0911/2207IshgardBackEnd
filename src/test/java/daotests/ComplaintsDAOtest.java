package daotests;


import daos.complaints.ComplaintsDAO;
import daos.complaints.PostgresComplaintsDAO;
import entities.Complaints;
import org.junit.jupiter.api.*;
import utils.connectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ComplaintsDAOtest {

    static ComplaintsDAO complaintsDAO = new PostgresComplaintsDAO();

    @BeforeAll
    static void setup() {
        try (Connection conn = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = "create table Complaints(\n" +
                    "\tcomplaint_id serial primary key,\n" +
                    "\tdescription varchar(100),\n" +
                    "\tstatus varchar(100) ,\n" +
                    "\tmeeting_id int references meetings(meeting_id) default -1 \n" +
                    ");";
            Statement statement = conn.createStatement();
            statement.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    @Order(1)
    void create_Complaints_test() {
        Complaints complaints = new Complaints(1, "The Brume needs to be better maintained", "UNREVIEWED", -1);
        Complaints savedComplaints = complaintsDAO.createComplaints(complaints);
        Assertions.assertNotEquals(0, savedComplaints.getComplain_id());
        System.out.println(complaints);
    }
}




