package by.ivanshestakov.hotel.controller.command.common;

import by.ivanshestakov.hotel.controller.command.Command;
import by.ivanshestakov.hotel.controller.command.CommandResult;
import by.ivanshestakov.hotel.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartPageCommand implements Command {

    private static final String LOGIN_PAGE = "/index.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return CommandResult.forward(LOGIN_PAGE);
    }
}
