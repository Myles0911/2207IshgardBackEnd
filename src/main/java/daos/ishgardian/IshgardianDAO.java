package daos.ishgardian;

import entities.Ishgardian;

public interface IshgardianDAO {
    Ishgardian getIshgardianByName(String name);
}
