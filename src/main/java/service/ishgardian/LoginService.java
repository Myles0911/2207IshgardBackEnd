package service.ishgardian;

import entities.Ishgardian;

public interface LoginService {
    Ishgardian validateUser(String name, String password);
}
