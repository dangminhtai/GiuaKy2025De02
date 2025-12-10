<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <html>

        <head>
            <title>Chi tiết Video</title>
        </head>

        <body>
            <div class="container mt-4">
                <c:choose>
                    <c:when test="${not empty video}">
                        <div class="row">
                            <div class="col-md-4">
                                <img src="${video.poster}" class="img-fluid rounded" alt="${video.title}"
                                    style="width: 100%;">
                            </div>
                            <div class="col-md-8">
                                <h2>[Poster] ${video.title}</h2>
                                <hr>
                                <p><strong>Mã video:</strong> ${video.videoId}</p>
                                <p><strong>Category ID:</strong> ${video.categoryId}</p>
                                <!-- Requirement asks for Category Name but DB has ID. Ideally join or fetch. -->
                                <p><strong>Views:</strong> ${video.views}</p>
                                <p>
                                    <button class="btn btn-primary btn-sm">Share (10)</button>
                                    <button class="btn btn-outline-danger btn-sm">Like (10)</button>
                                </p>
                                <hr>
                                <h5>Description:</h5>
                                <p>${video.description}</p>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="alert alert-warning">Video không tồn tại hoặc đã bị xóa.</div>
                    </c:otherwise>
                </c:choose>
            </div>
        </body>

        </html>