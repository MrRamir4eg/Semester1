package ru.kpfu.itis.kashshapov.servlets;

import ru.kpfu.itis.kashshapov.dao.impl.CourseCommentDao;
import ru.kpfu.itis.kashshapov.dao.impl.CourseDaoImpl;
import ru.kpfu.itis.kashshapov.dao.impl.UniversityDaoImpl;
import ru.kpfu.itis.kashshapov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.kashshapov.dto.CourseCommentDto;
import ru.kpfu.itis.kashshapov.dto.UniversityDto;
import ru.kpfu.itis.kashshapov.entity.CourseCommentWithParams;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "reviewsServlet" ,urlPatterns = "/reviews")
public class ReviewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("universities",new UniversityDaoImpl().getAll());
        req.setAttribute("courses", new CourseDaoImpl().getAll());
        List<CourseCommentDto> courseCommentDtoList = new CourseCommentDao().getAll();
        List<CourseCommentWithParams> comments = new ArrayList<>();
        for (CourseCommentDto i : courseCommentDtoList) {
            comments.add(new CourseCommentWithParams(i));
        }
        if (!comments.isEmpty()) {
            req.setAttribute("comments", comments);
        }
        req.getRequestDispatcher("reviews.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseCommentDto course = new CourseCommentDto();
        HttpSession session = req.getSession();
        Long userId = new UserDaoImpl().getByEmailAndPassword(session.getAttribute("login").toString(), session.getAttribute("password").toString()).getId();
        Long universityId = new UniversityDaoImpl().getByName(req.getParameter("uni")).getId();
        Long courseId = new CourseDaoImpl().getByCodeName(req.getParameter("course")).getId();
        Boolean isPositive = req.getParameter("recommend").equals("Да");
        String description = req.getParameter("description");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY kk:mm");

        course.setDescription(description);
        course.setTimeCreated(sdf.format(new Date()));
        course.setPositive(isPositive);
        course.setUserId(userId);
        course.setCourseId(courseId);
        course.setUniversityId(universityId);
        new CourseCommentDao().add(course);
        doGet(req, resp);
    }
}
