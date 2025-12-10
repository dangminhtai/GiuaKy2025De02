<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>

        <head>
            <title>Đăng Nhập</title>
        </head>

        <body>
            <h1>Đăng Nhập</h1>

            <c:if test="${not empty message}">
                <div class="alert alert-info">${message}</div>
            </c:if>

            <form action="<c:url value='/login'/>" method="post">
                <div class="mb-3">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <button type="submit" class="btn btn-primary">Đăng Nhập</button>
            </form>
            <div class="mt-3">
                <p>Chưa có tài khoản? <a href="<c:url value='/register'/>">Đăng ký ngay</a></p>
            </div>
        </body>

        </html>