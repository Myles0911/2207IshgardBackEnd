package dev.walker.daotests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import dev.walker.utils.connectionUtil;

import java.sql.Connection;

public class ComplaintsDaoSmokeTests {

    @Test
    void connection_available() {
        Connection connection = connectionUtil.createConnection();
        System.out.println(connection);
        Assertions.assertNotNull(connection);
    }
}

