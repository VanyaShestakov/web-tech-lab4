package by.ivanshestakov.hotel.controller.command.user;

import by.ivanshestakov.hotel.controller.command.Command;
import by.ivanshestakov.hotel.controller.command.CommandResult;
import by.ivanshestakov.hotel.entity.Room;
import by.ivanshestakov.hotel.exception.ServiceException;
import by.ivanshestakov.hotel.service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MainPageCommand implements Command {

    private static final String MAIN_PAGE = "/WEB-INF/pages/createOrder.jsp";
    private static final String ROOM_LIST = "roomList";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        RoomService roomService = new RoomService();
        List<Room> freeRoomList = roomService.findIsNotOccupied();
        request.setAttribute(ROOM_LIST, freeRoomList);
        return CommandResult.forward(MAIN_PAGE);
    }
}
