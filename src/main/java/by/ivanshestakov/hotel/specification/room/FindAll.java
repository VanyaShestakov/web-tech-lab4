package by.ivanshestakov.hotel.specification.room;

import by.ivanshestakov.hotel.specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindAll implements Specification {

    @Override
    public String toSql() {
        return "";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.emptyList();
    }
}
