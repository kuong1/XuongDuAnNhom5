<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>SD17313 - CRUD NGUỒN GỐC</title>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ taglib prefix="f" uri="jakarta.tags.functions" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
            integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>Danh Sách NGUỒN GỐC</h1>
<a href="/admin/nguon-goc/create"class="btn btn-primary" >Thêm mới</a>
<table class="table table-bordered ">
    <thead>
    <th>ID</th>
    <th>Mã</th>
    <th>Quốc Gia</th>
    <th colspan="2">Thao tác</th>
    </thead>
    <tbody>
    <c:forEach items="${ data }" var="ng">
        <tr>
            <td>${ ng.id }</td>
            <td>${ ng.ma }</td>
            <td>${ ng.quocGia }</td>
            <td>
                <a href="/admin/nguon-goc/edit/${ng.id}">Cập nhật</a>
            </td>
            <td>
                <a href="/admin/nguon-goc/delete/${ng.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>