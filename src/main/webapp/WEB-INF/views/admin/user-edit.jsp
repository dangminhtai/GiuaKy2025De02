<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h4 class="mb-0">
                            <c:choose>
                                <c:when test="${not empty user}">Cập nhật người dùng</c:when>
                                <c:otherwise>Thêm mới người dùng</c:otherwise>
                            </c:choose>
                        </h4>
                    </div>
                    <div class="card-body">
                        <c:if test="${not empty error}">
                            <div class="alert alert-danger">${error}</div>
                        </c:if>

                        <form action="<c:url value='${not empty user ? " /admin/user/update" : "/admin/user/create"
                            }' />" method="post">

                        <div class="form-group">
                            <label for="username">Username:</label>
                            <c:choose>
                                <c:when test="${not empty user}">
                                    <input type="text" class="form-control" id="username" name="username"
                                        value="${user.username}" readonly>
                                </c:when>
                                <c:otherwise>
                                    <input type="text" class="form-control" id="username" name="username" required>
                                </c:otherwise>
                            </c:choose>
                        </div>

                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" class="form-control" id="password" name="password"
                                value="${user.password}" required>
                        </div>

                        <div class="form-group">
                            <label for="fullname">Fullname:</label>
                            <input type="text" class="form-control" id="fullname" name="fullname"
                                value="${user.fullname}">
                        </div>

                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" class="form-control" id="email" name="email" value="${user.email}">
                        </div>

                        <div class="form-group">
                            <label for="phone">Phone:</label>
                            <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}">
                        </div>

                        <div class="form-group">
                            <label for="image">Image URL:</label>
                            <input type="text" class="form-control" id="image" name="image" value="${user.images}">
                        </div>

                        <div class="form-check mb-2">
                            <input type="checkbox" class="form-check-input" id="admin" name="admin" value="true"
                                ${user.admin ? 'checked' : '' }>
                            <label class="form-check-label" for="admin">Is Admin</label>
                        </div>

                        <div class="form-check mb-3">
                            <input type="checkbox" class="form-check-input" id="active" name="active" value="true"
                                ${user.active ? 'checked' : '' }>
                            <label class="form-check-label" for="active">Is Active</label>
                        </div>

                        <button type="submit" class="btn btn-primary">Lưu</button>
                        <a href="<c:url value='/admin/users'/>" class="btn btn-secondary">Hủy</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>