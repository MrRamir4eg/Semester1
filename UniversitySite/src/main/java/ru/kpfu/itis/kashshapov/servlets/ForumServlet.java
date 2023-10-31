package ru.kpfu.itis.kashshapov.servlets;

import ru.kpfu.itis.kashshapov.dao.impl.DiscussionDaoImpl;
import ru.kpfu.itis.kashshapov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.kashshapov.dto.DiscussionDto;
import ru.kpfu.itis.kashshapov.entity.DiscussionAndUser;

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

@WebServlet(name = "forumServlet", urlPatterns = "/forum")
public class ForumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DiscussionDto> discussions = new DiscussionDaoImpl().getAll();
        List<DiscussionAndUser> dis = new ArrayList<>();
        for (DiscussionDto d : discussions) {
            dis.add(new DiscussionAndUser(d));
        }
        req.setAttribute("discussions", dis);
        req.getRequestDispatcher("forum.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiscussionDto discussion = new DiscussionDto();
        HttpSession session = req.getSession();
        discussion.setTitle(req.getParameter("title"));
        discussion.setDescription(req.getParameter("description"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY kk:mm");
        discussion.setTimeCreated(sdf.format(new Date()));
        Long id = new UserDaoImpl().getByEmailAndPassword(session.getAttribute("login").toString(), session.getAttribute("password").toString()).getId();
        discussion.setUser_id(id);
        new DiscussionDaoImpl().add(discussion);
        doGet(req, resp);
    }
}
