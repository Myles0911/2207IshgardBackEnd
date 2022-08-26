package service.ishgardian;

import entities.Ishgardians;

import java.util.List;

public interface IshgardiansService {
    Ishgardians registerIshgardians(Ishgardians ishgardians);

    List<Ishgardians> getAllIshgardians();

    Ishgardians modifyIshgardians(Ishgardians ishgardians);
}
