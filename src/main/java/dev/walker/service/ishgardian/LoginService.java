package dev.walker.service.ishgardian;

import dev.walker.entities.Ishgardians;

public interface LoginService {
    Ishgardians validateUser(String name, String password);
}
