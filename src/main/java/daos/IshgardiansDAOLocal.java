package daos;

import entities.Ishgardians;

import java.util.HashMap;
import java.util.Map;

public class IshgardiansDAOLocal implements IshgardiansDAO {

    private Map<Integer, Ishgardians> ish_table = new HashMap();
    private int idMaker = 1;

    @Override
    public Ishgardians createIshgardians(Ishgardians ishgardians) {

        ishgardians.setUserid(idMaker);
        idMaker++;
        ish_table.put(ishgardians.getUserid(),ishgardians);
        System.out.println(ish_table.values());
        return ishgardians;
    }
}
