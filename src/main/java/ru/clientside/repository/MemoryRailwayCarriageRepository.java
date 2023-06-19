package ru.clientside.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.clientside.model.RailwayCarriage;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class MemoryRailwayCarriageRepository implements RailwayCarriageRepository {

    private final AtomicInteger nextId = new AtomicInteger(0);

    private final ObservableList<RailwayCarriage> carriages = FXCollections.observableArrayList();

    private MemoryRailwayCarriageRepository() {
        save(new RailwayCarriage(1, 66, 12, 52,
                "Вагон-цистерна", "Москва"));
        save(new RailwayCarriage(2, 66, 12, 52,
                "Вагон-цистерна", "Москва"));
        save(new RailwayCarriage(3, 66, 12, 52,
                "Вагон-цистерна", "Москва"));
        save(new RailwayCarriage(4, 66, 12, 52,
                "Вагон-цистерна", "Москва"));
    }

    @Override
    public RailwayCarriage save(RailwayCarriage railwayCarriage) {
        railwayCarriage.setNumber(nextId.incrementAndGet());
        carriages.add(railwayCarriage.getNumber(), railwayCarriage);
        return railwayCarriage;
    }

    @Override
    public boolean deleteById(int id) {
        return carriages.remove(carriages.get(id + 1));
    }

    @Override
    public boolean update(RailwayCarriage railwayCarriage) {
        return false;
    }

    @Override
    public Optional<RailwayCarriage> findById(int id) {
        return Optional.empty();
    }
}
