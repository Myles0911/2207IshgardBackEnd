package dev.walker.service.ishgardian;

import dev.walker.daos.ishgardian.IshgardiansDAO;
import dev.walker.entities.Ishgardians;

public class LoginServiceImpl implements  LoginService{

    private IshgardiansDAO ishgardiansDAO;

    public LoginServiceImpl(IshgardiansDAO ishgardiansDAO) {
        this.ishgardiansDAO = ishgardiansDAO;
    }

    @Override
    public Ishgardians validateUser(String name, String password) {
        Ishgardians ishgardians = this.ishgardiansDAO.getIshgardianByName(name);

        if(ishgardians == null) {
            throw new RuntimeException("Input a valid name");
        }
        if(!ishgardians.getPassword().equals(password)) {
            throw new RuntimeException("password does not match");
        }
        return ishgardians;
    }
}
