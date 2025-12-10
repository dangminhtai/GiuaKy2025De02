<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>
                <sitemesh:write property='title' /> - Admin
            </title>
            <!-- Bootstrap CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
            <sitemesh:write property='head' />
        </head>

        <body>

            <!-- Header -->
            <jsp:include page="/common/header.jsp"></jsp:include>

            <!-- Main Content -->
            <div class="container mt-4">
                <h1>Admin Dashboard</h1>
                <sitemesh:write property='body' />
            </div>

            <!-- Footer -->
            <jsp:include page="/common/footer.jsp"></jsp:include>

            <!-- Bootstrap JS -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        </body>

        </html>