package daotests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.connectionUtil;

import java.sql.Connection;

public class ComplaintsDaoSmokeTests {

    @Test
    void connection_available() {
        Connection connection = connectionUtil.ConnectionUtil.createConnection();
        System.out.println(connection);
        Assertions.assertNotNull(connection);
    }
}

