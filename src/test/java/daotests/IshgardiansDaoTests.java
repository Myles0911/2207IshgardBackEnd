package daotests;


import daos.IshgardiansDAO;
import daos.PostgresIshgardiansDAO;
import entities.Ishgardians;
import org.junit.jupiter.api.*;
import utils.connectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IshgardiansDaoTests {

    static IshgardiansDAO ishgardiansDAO = new PostgresIshgardiansDAO();

    @BeforeAll
    static void setup() {
        try (Connection conn = connectionUtil.ConnectionUtil.createConnection()) {
            String sql = "create table Ishgardians(\n" +
                    "\tuser_id serial primary key,\n" +
                    "\tname varchar(100),\n" +
                    "\tpassword varchar(100) ,\n" +
                    "\trole varchar(100), \n" +
                    ");";
            Statement statement = conn.createStatement();
            statement.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    @Order(1)
    void create_Ishgardians_test() {
        Ishgardians ishgardians = new Ishgardians(1, "Hilda Ware", "HildW284", "CONSTITUENT");
        Ishgardians savedIshgardians = ishgardiansDAO.createIshgardians(ishgardians);
        Assertions.assertNotEquals(0, savedIshgardians.getUserid());
        System.out.println(ishgardians);
    }
}




