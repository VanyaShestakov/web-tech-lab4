package by.ivanshestakov.hotel.builder;

import by.ivanshestakov.hotel.exception.RepositoryException;

import java.sql.ResultSet;

public interface Builder<T> {
    T build(ResultSet resultSet) throws RepositoryException;
}
