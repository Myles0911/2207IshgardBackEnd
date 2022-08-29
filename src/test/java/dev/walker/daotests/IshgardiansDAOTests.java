package dev.walker.daotests;

import dev.walker.daos.ishgardian.IshgardiansDAO;
import dev.walker.daos.ishgardian.IshgardiansDAOPostgres;
import dev.walker.entities.Ishgardians;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IshgardiansDAOTests {

    static IshgardiansDAO ishgardiansDAO = new IshgardiansDAOPostgres();

    @Test
    void get_ishgardian_by_name() {
        Ishgardians ishgardians = ishgardiansDAO.getIshgardianByName("Hilda Ware");
        System.out.println(ishgardians);
        Assertions.assertEquals("CONSTITUENT", ishgardians.getRole());
    }

}
