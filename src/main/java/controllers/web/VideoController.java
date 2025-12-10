package controllers.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Category;
import models.Video;
import services.CategoryServiceImpl;
import services.ICategoryService;
import services.IVideoService;
import services.VideoServiceImpl;

@WebServlet(urlPatterns = { "/video/detail", "/video/category" })
public class VideoController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    IVideoService videoService = new VideoServiceImpl();
    ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();

        if (url.contains("detail")) {
            String videoId = req.getParameter("id");
            if (videoId != null) {
                Video video = videoService.findById(videoId);
                req.setAttribute("video", video);
            }
            req.getRequestDispatcher("/WEB-INF/views/web/video-detail.jsp").forward(req, resp);
        } else if (url.contains("category")) {
            String categoryIdParam = req.getParameter("id");
            if (categoryIdParam != null) {
                int categoryId = Integer.parseInt(categoryIdParam);

                // 1. Get List of Videos
                List<Video> videos = videoService.findByCategoryId(categoryId);
                req.setAttribute("videos", videos);

                // 2. Get Count (Question 6 requirement explicit check)
                int count = videoService.countByCategoryId(categoryId);
                req.setAttribute("videoCount", count);

                // 3. Get Category Details for Name display
                List<Category> categories = categoryService.findAll();
                Category currentCategory = categories.stream()
                        .filter(c -> c.getCategoryId() == categoryId)
                        .findFirst().orElse(null);

                req.setAttribute("currentCategory", currentCategory);
            }
            req.getRequestDispatcher("/WEB-INF/views/web/video-category.jsp").forward(req, resp);
        }
    }
}
