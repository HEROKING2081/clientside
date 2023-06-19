package ru.clientside.repository;

import ru.clientside.model.RailwayCarriage;

import java.util.List;
import java.util.Optional;

public interface RailwayCarriageRepository {

    RailwayCarriage save(RailwayCarriage railwayCarriage);

    boolean deleteById(int id);

    boolean update(RailwayCarriage railwayCarriage);

    Optional<RailwayCarriage> findById(int id);
}
