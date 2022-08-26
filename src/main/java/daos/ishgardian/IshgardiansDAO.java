package daos.ishgardian;

import entities.Ishgardians;

import java.util.List;

public interface IshgardiansDAO {
    Ishgardians createIshgardians(Ishgardians ishgardians);

    List<Ishgardians> getAllIshgardians();

    Ishgardians updateIshgardiansRole(Ishgardians ishgardians);
    Ishgardians getIshgardianByName(String name);
}
