<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>${title} - Admin</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    ${head}
</head>

<body>

    <!-- Header -->
    <jsp:include page="/common/header.jsp"></jsp:include>

    <div class="container mt-4">
        <h1>Admin Dashboard</h1>
        ${body}
    </div>

    <!-- Footer -->
    <jsp:include page="/common/footer.jsp"></jsp:include>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
