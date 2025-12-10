package controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/admin/home" })
public class UserController extends HttpServlet {
    // User provided UserController in admin package, reusing it for admin home or
    // creating new one.
    // Assuming UserController is for User Management, but for now using it as entry
    // point or creating AdminHomeController
    // Requirement says "Trang quản trị".
    // The user had UserController.java. I'll stick to creating a specific
    // AdminHomeController just to be safe or reuse if it's cleaner.
    // Let's create AdminHomeController to map /admin/home

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/admin/home.jsp").forward(req, resp);
    }
}
