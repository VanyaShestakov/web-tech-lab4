package by.ivanshestakov.hotel.specification.user;

import by.ivanshestakov.hotel.specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindByUsername implements Specification {

    private final String username;

    public FindByUsername(String username) {
        this.username = username;
    }

    @Override
    public String toSql() {
        return "WHERE username=?";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.singletonList(username);
    }
}
