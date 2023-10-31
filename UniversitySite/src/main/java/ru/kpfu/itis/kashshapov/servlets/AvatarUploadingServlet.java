package ru.kpfu.itis.kashshapov.servlets;

import com.cloudinary.Cloudinary;
import ru.kpfu.itis.kashshapov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.kashshapov.dto.UserDto;
import ru.kpfu.itis.kashshapov.util.CloudinaryUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "uploadAvatar", urlPatterns = "/uploadAvatar")
@MultipartConfig(
        maxFileSize = 512*1024,
        maxRequestSize = 512*1024
)
public class AvatarUploadingServlet extends HttpServlet {


    private final Cloudinary cloudinary = CloudinaryUtil.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Part part = req.getPart("avatar");
            String filename = Paths.get(part.getSubmittedFileName()).toString();
            File file = new File(filename);
            file.createNewFile();

            InputStream content = part.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] buff = new byte[content.available()];
            content.read(buff);
            outputStream.write(buff);
            Map res = cloudinary.uploader().upload(file, new HashMap());

            HttpSession session = req.getSession();
            String avatarURL = res.get("url").toString();
            UserDaoImpl userDao = new UserDaoImpl();
            UserDto user = userDao.getByEmailAndPassword(session.getAttribute("login").toString(), session.getAttribute("password").toString());
            if (user.getImageUrl() != null) {
                String url = user.getImageUrl();
                cloudinary.uploader().destroy(url.substring(url.lastIndexOf('/') + 1, url.lastIndexOf('.')), new HashMap());
            }
            user.setImageUrl(avatarURL);
            userDao.update(user);
            session.setAttribute("image_url", avatarURL);

            outputStream.close();
            file.delete();
        } catch (Exception e) {
            resp.getWriter().print("error");
        } finally {
            resp.sendRedirect(getServletContext().getContextPath() + "/profile");
        }
    }
}

