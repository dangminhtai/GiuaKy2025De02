<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <html>

        <head>
            <title>Danh sách Video</title>
        </head>

        <body>
            <div class="container mt-4">
                <h2 class="mb-4">
                    Category Name:
                    <c:choose>
                        <c:when test="${not empty currentCategory}">${currentCategory.categoryname}</c:when>
                        <c:otherwise>Unknown</c:otherwise>
                    </c:choose>
                    (${videoCount})
                </h2>

                <div class="row">
                    <c:forEach items="${videos}" var="video">
                        <div class="col-md-12 mb-4 border p-3 rounded">
                            <div class="row">
                                <div class="col-md-3">
                                    <a href="<c:url value='/video/detail?id=${video.videoId}'/>">
                                        <img src="${video.poster}" class="img-fluid" alt="${video.title}">
                                    </a>
                                </div>
                                <div class="col-md-9">
                                    <h4><a href="<c:url value='/video/detail?id=${video.videoId}'/>"
                                            class="text-decoration-none text-dark">[Poster] ${video.title}</a></h4>
                                    <p><strong>Mã video:</strong> ${video.videoId}</p>
                                    <p><strong>Category name:</strong> ${currentCategory.categoryname}</p>
                                    <p><strong>View:</strong> ${video.views}</p>
                                    <p>
                                        <span class="text-primary">Share(10)</span> | <span
                                            class="text-danger">Like(10)</span>
                                    </p>
                                    <p class="text-muted">${video.description}</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    <c:if test="${empty videos}">
                        <div class="col-12">
                            <div class="alert alert-info">Không có video nào trong danh mục này.</div>
                        </div>
                    </c:if>
                </div>
            </div>
        </body>

        </html>