package service;

import daos.IshgardiansDAO;
import entities.Ishgardians;

public class IshgardiansServiceImpl implements IshgardiansService {
    private IshgardiansDAO ishgardiansDAO;

    public IshgardiansServiceImpl(IshgardiansDAO ishgardiansDAO) {
        this.ishgardiansDAO = ishgardiansDAO;
    }

    @Override
    public Ishgardians newIshgardians(Ishgardians ishgardians) {
        if (ishgardians.getName().length() == 0) {
            throw new RuntimeException("Sorry, to use this application you must register your name");
        }
        if (ishgardians.getPassword().length() == 0) {
            throw new RuntimeException("Sorry, you must insert your password");
        }
        Ishgardians myI = this.ishgardiansDAO.createIshgardians(ishgardians);
        return ishgardians;
    }
}

