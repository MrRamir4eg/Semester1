package ru.kpfu.itis.kashshapov.servlets;

import ru.kpfu.itis.kashshapov.dao.impl.DiscussionCommentDao;
import ru.kpfu.itis.kashshapov.dao.impl.DiscussionDaoImpl;
import ru.kpfu.itis.kashshapov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.kashshapov.dto.DiscussionCommentDto;
import ru.kpfu.itis.kashshapov.dto.DiscussionDto;
import ru.kpfu.itis.kashshapov.entity.DiscussionAndUser;
import ru.kpfu.itis.kashshapov.entity.DiscussionCommentAndUser;

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

@WebServlet(name = "discussionServlet", urlPatterns = "/discussion")
public class DiscussionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = (long) Integer.parseInt(req.getParameter("discussionId"));
        DiscussionDto discussion = new DiscussionDaoImpl().getById(id);
        DiscussionAndUser dis = new DiscussionAndUser(discussion);
        List<DiscussionCommentDto> comments = new DiscussionCommentDao().getAllByDiscussionId(id);
        List<DiscussionCommentAndUser> comms = new ArrayList<>();
        for (DiscussionCommentDto i : comments) {
            comms.add(new DiscussionCommentAndUser(i));
        }
        req.setAttribute("dis", dis);
        if (!comms.isEmpty()) {
            req.setAttribute("comments", comms);
        }
        req.getRequestDispatcher("discussion.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long userId = new UserDaoImpl().getByEmailAndPassword(session.getAttribute("login").toString(), session.getAttribute("password").toString()).getId();
        String discussionId = req.getParameter("discussionId");
        String description = req.getParameter("description");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY kk:mm");
        String timeCreated = sdf.format(new Date());
        DiscussionCommentDto comment = new DiscussionCommentDto();
        comment.setDescription(description);
        comment.setDiscussionId((long) Integer.parseInt(discussionId));
        comment.setUserId(userId);
        comment.setTimeCreated(timeCreated);
        comment.setMain(true);
        new DiscussionCommentDao().add(comment);
        resp.sendRedirect(getServletContext().getContextPath() + "/discussion?discussionId="+discussionId);
    }
}
