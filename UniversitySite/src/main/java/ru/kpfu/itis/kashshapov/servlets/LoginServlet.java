package ru.kpfu.itis.kashshapov.servlets;

import ru.kpfu.itis.kashshapov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.kashshapov.dto.UserDto;
import ru.kpfu.itis.kashshapov.util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDaoImpl userDao = new UserDaoImpl();
        UserDto user = userDao.getByEmailAndPassword(req.getParameter("email").toString(),
                PasswordUtil.encrypt(req.getParameter("password").toString()));
        if (user != null){
            session.setAttribute("login", user.getEmail());
            session.setAttribute("password", user.getPassword());
            session.setAttribute("first_name", user.getFirstName());
            session.setAttribute("last_name", user.getLastName());
            session.setAttribute("dob", user.getDateOfBirth());
            session.setAttribute("image_url", user.getImageUrl());
            if (req.getParameter("remember_me").toString().equals("true")){
                Cookie login = new Cookie("login", user.getEmail());
                login.setMaxAge(7 * 24 * 3600);
                Cookie password = new Cookie("password", user.getPassword());
                password.setMaxAge(7 * 24 * 3600);
                resp.addCookie(login);
                resp.addCookie(password);
            }
        } else {
            resp.setContentType("text/plain");
            resp.getWriter().print("false");
        }
    }
}
