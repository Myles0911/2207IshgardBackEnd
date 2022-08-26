package service.ishgardian;

import daos.ishgardian.IshgardiansDAO;
import entities.Ishgardians;

import java.util.List;

public class IshgardiansServiceImpl implements IshgardiansService {

    private IshgardiansDAO ishgardiansDAO;
    public IshgardiansServiceImpl(IshgardiansDAO ishgardiansDAO) {
        this.ishgardiansDAO = ishgardiansDAO;
    }
    @Override
    public Ishgardians registerIshgardians(Ishgardians ishgardians) {
       if(ishgardians.getName().length() == 0) {
           throw new RuntimeException("Your account must have a name");
       }
       Ishgardians savedIshgardians = this.ishgardiansDAO.createIshgardians(ishgardians);
       return savedIshgardians;
    }

    @Override
    public List<Ishgardians> getAllIshgardians() {
        return this.ishgardiansDAO.getAllIshgardians();
    }

    @Override
    public Ishgardians modifyIshgardians(Ishgardians ishgardians) {
        if(ishgardians.getName().length() == 0) {
            throw new RuntimeException("Your account must have a name");
        }
        return this.ishgardiansDAO.updateIshgardiansRole(ishgardians);
    }
}
