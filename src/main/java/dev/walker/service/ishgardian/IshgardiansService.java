package dev.walker.service.ishgardian;

import dev.walker.entities.Ishgardians;

import java.util.List;

public interface IshgardiansService {
    Ishgardians registerIshgardians(Ishgardians ishgardians);

    List<Ishgardians> getAllIshgardians();

    Ishgardians modifyIshgardians(Ishgardians ishgardians);
}
