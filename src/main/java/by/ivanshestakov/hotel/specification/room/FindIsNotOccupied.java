package by.ivanshestakov.hotel.specification.room;

import by.ivanshestakov.hotel.specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindIsNotOccupied implements Specification {

    public FindIsNotOccupied() {
    }

    @Override
    public String toSql() {
        return "WHERE occupied = 'false'";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.emptyList();
    }
}
