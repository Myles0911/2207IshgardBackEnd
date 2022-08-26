package daotests;

import daos.ishgardian.IshgardiansDAO;
import daos.ishgardian.IshgardiansDAOPostgres;
import entities.Ishgardians;
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
