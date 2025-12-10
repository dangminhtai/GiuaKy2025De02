<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="<c:url value='/home'/>">GiuaKy</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value='/home'/>">Trang Chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value='/product'/>">Sản phẩm</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value='/login'/>">Đăng nhập</a>
                        </li>

                        <%-- Admin Page link only for admin users --%>
                            <c:if test="${sessionScope.account.admin == true}">
                                <li class="nav-item">
                                    <a class="nav-link" href="<c:url value='/admin/home'/>">Trang quản trị</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="<c:url value='/admin/users'/>">Quản lý User</a>
                                </li>
                            </c:if>
                    </ul>
                </div>
            </div>
        </nav>