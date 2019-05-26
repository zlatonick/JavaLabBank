package controller.handlers;

import model.BankModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {

    BankModel bankModel;

    public abstract String execute(HttpServletRequest req, HttpServletResponse resp);

}
