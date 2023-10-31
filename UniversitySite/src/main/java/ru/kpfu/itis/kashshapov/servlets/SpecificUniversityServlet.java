package ru.kpfu.itis.kashshapov.servlets;

import ru.kpfu.itis.kashshapov.dao.impl.UniversityDaoImpl;
import ru.kpfu.itis.kashshapov.dto.UniversityDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns = "/universityInfo")
public class SpecificUniversityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = (long) Integer.parseInt(req.getParameter("id"));
        UniversityDto university = new UniversityDaoImpl().getById(id);
        req.setAttribute("name", university.getName());
        req.setAttribute("description", university.getDescription());
        req.setAttribute("addImg", university.getAddImg());
        req.getRequestDispatcher("/university.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
