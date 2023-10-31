package ru.kpfu.itis.kashshapov.servlets;

import ru.kpfu.itis.kashshapov.dao.impl.CourseDaoImpl;
import ru.kpfu.itis.kashshapov.dto.CourseDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "aboutServlet", urlPatterns = "/about")
public class AboutCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CourseDto> courses = new CourseDaoImpl().getAll();
        req.setAttribute("courses", courses);
        req.getRequestDispatcher("about.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
