package controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import services.IUserService;
import services.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/users", "/admin/user/create", "/admin/user/update", "/admin/user/delete" })
public class UserController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();

        if (url.contains("delete")) {
            delete(req, resp);
            return;
        }

        if (url.contains("create")) {
            req.getRequestDispatcher("/WEB-INF/views/admin/user-edit.jsp").forward(req, resp);
            return;
        }

        if (url.contains("update")) {
            String username = req.getParameter("username");
            User user = userService.findByUsername(username);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/views/admin/user-edit.jsp").forward(req, resp);
            return;
        }

        // List users (default)
        findAll(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getRequestURL().toString();

        if (url.contains("create")) {
            insert(req, resp);
        } else if (url.contains("update")) {
            update(req, resp);
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int pageSize = 6; // 6 users per page as requested

        if (req.getParameter("page") != null) {
            try {
                page = Integer.parseInt(req.getParameter("page"));
            } catch (Exception e) {
                // default to 1
            }
        }

        List<User> users = userService.findAll(page, pageSize);
        int totalUsers = userService.count();
        int totalPages = (int) Math.ceil((double) totalUsers / pageSize);

        req.setAttribute("users", users);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("currentPage", page);

        req.getRequestDispatcher("/WEB-INF/views/admin/user-list.jsp").forward(req, resp);
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Simple insert logic
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String image = req.getParameter("image");
        boolean admin = req.getParameter("admin") != null;
        boolean active = req.getParameter("active") != null;

        // Check if username exists
        if (userService.findByUsername(username) != null) {
            req.setAttribute("error", "Username already exists!");
            req.getRequestDispatcher("/WEB-INF/views/admin/user-edit.jsp").forward(req, resp);
            return;
        }

        // Using register logic or manual insert via service
        // Since insert in service is void, we'll manually construct User or use
        // register if it fits.
        // But register is specific. Let's use direct insert logic here or create a new
        // service method if needed.
        // Service's register method sets some defaults. Let's essentially do what
        // register does but with admin flags.

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setImages(image);
        user.setAdmin(admin);
        user.setActive(active);

        userService.insert(user);
        resp.sendRedirect(req.getContextPath() + "/admin/users");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String image = req.getParameter("image");
        boolean admin = req.getParameter("admin") != null;
        boolean active = req.getParameter("active") != null;

        User user = new User();
        user.setUsername(username);
        user.setPassword(password); // Note: In real app, check if password changed or handle encryption
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setImages(image);
        user.setAdmin(admin);
        user.setActive(active);

        userService.update(user);
        resp.sendRedirect(req.getContextPath() + "/admin/users");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        if (username != null) {
            userService.delete(username);
        }
        resp.sendRedirect(req.getContextPath() + "/admin/users");
    }
}
