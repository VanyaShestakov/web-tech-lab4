package by.ivanshestakov.hotel.service;

import by.ivanshestakov.hotel.entity.Room;
import by.ivanshestakov.hotel.exception.RepositoryException;
import by.ivanshestakov.hotel.exception.ServiceException;
import by.ivanshestakov.hotel.repository.creator.RepositoryCreator;
import by.ivanshestakov.hotel.repository.impl.RoomRepository;
import by.ivanshestakov.hotel.specification.common.FindById;
import by.ivanshestakov.hotel.specification.room.FindAll;
import by.ivanshestakov.hotel.specification.room.FindIsNotOccupied;

import java.util.List;
import java.util.Optional;

public class RoomService {

    public List<Room> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            return roomRepository.queryAll(new FindAll());
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public List<Room> findIsNotOccupied() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            return roomRepository.queryAll(new FindIsNotOccupied());
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public void saveRoom(Integer id, String roomNumber, Boolean occupied) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            Room room = new Room(id, roomNumber, occupied);
            roomRepository.save(room);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public void changeOccupiedStatus(Integer id, Boolean occupied) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            Optional<Room> room = roomRepository.query(new FindById(id));
            if (room.isPresent()) {
                room.get().setIsOccupied(occupied);
                roomRepository.save(room.get());
            } else {
                throw new ServiceException("No room with such id");
            }
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
