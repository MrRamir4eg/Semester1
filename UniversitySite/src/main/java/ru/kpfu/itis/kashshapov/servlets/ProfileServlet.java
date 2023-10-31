package ru.kpfu.itis.kashshapov.servlets;

import ru.kpfu.itis.kashshapov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.kashshapov.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/profile.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDaoImpl userDao = new UserDaoImpl();
        String email = session.getAttribute("login").toString();
        String password = session.getAttribute("password").toString();
        UserDto user = userDao.getByEmailAndPassword(email, password);
        user.setFirstName(req.getParameter("new_first"));
        user.setLastName(req.getParameter("new_last"));
        session.setAttribute("first_name", user.getFirstName());
        session.setAttribute("last_name", user.getLastName());
        userDao.update(user);
        doGet(req, resp);
    }
}
