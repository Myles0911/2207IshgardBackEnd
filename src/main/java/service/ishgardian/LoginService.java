package service.ishgardian;

import entities.Ishgardians;

public interface LoginService {
    Ishgardians validateUser(String name, String password);
}
