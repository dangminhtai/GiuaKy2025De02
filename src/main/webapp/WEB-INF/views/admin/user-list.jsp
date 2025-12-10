<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div class="row">
            <div class="col-md-12">
                <h3 class="text-center">Quản lý người dùng</h3>
                <a href="<c:url value='/admin/user/create'/>" class="btn btn-primary mb-3">Thêm mới</a>

                <table class="table table-bordered table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>Username</th>
                            <th>Fullname</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Image</th>
                            <th>Role</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>${user.username}</td>
                                <td>${user.fullname}</td>
                                <td>${user.email}</td>
                                <td>${user.phone}</td>
                                <td>
                                    <c:if test="${not empty user.images}">
                                        <img src="${user.images}" alt="Avatar" width="50" height="50"
                                            class="img-thumbnail" />
                                    </c:if>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${user.admin}">Admin</c:when>
                                        <c:otherwise>User</c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${user.active}"><span class="badge badge-success">Active</span>
                                        </c:when>
                                        <c:otherwise><span class="badge badge-secondary">Inactive</span></c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <a href="<c:url value='/admin/user/update?username=${user.username}'/>"
                                        class="btn btn-sm btn-warning">Edit</a>
                                    <a href="<c:url value='/admin/user/delete?username=${user.username}'/>"
                                        class="btn btn-sm btn-danger"
                                        onclick="return confirm('Bạn có chắc chắn muốn xóa user này không?');">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <!-- Pagination -->
                <nav aria-label="Page navigation">
                    <ul class="pagination justify-content-center">
                        <c:if test="${currentPage > 1}">
                            <li class="page-item">
                                <a class="page-link"
                                    href="<c:url value='/admin/users?page=${currentPage - 1}'/>">Previous</a>
                            </li>
                        </c:if>

                        <c:forEach begin="1" end="${totalPages}" var="i">
                            <li class="page-item ${currentPage == i ? 'active' : ''}">
                                <a class="page-link" href="<c:url value='/admin/users?page=${i}'/>">${i}</a>
                            </li>
                        </c:forEach>

                        <c:if test="${currentPage < totalPages}">
                            <li class="page-item">
                                <a class="page-link"
                                    href="<c:url value='/admin/users?page=${currentPage + 1}'/>">Next</a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </div>