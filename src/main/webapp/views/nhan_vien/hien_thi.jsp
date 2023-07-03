<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>SD17313 - NHÂN VIÊN</title>

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
<h1>Danh Sách Nhân Viên</h1>
<a href="/admin/nhan-vien/create" class="btn btn-primary">Thêm mới</a>
<table class="table table-bordered ">
    <thead>
    <th>ID</th>
    <th>Mã</th>
    <th>Họ Tên</th>
    <th>SDT</th>
    <th>Địa Chỉ</th>
    <th>Ngày Sinh</th>
    <th>Cửa Hàng</th>
    <th>Chức Vụ</th>
    <th>Mật Khẩu</th>
    <th>Trạng Thái</th>
    <th>Email</th>
    <th colspan="2">Thao tác</th>
    </thead>
    <tbody>
    <c:forEach items="${ nhanVienList }" var="a">
        <tr>
            <td>${ a.id }</td>
            <td>${ a.ma }</td>
            <td>${ a.hoTen }</td>
            <td>${ a.sdt }</td>
            <td>${ a.diaChi }</td>
            <td>${ a.ngaySinh }</td>
            <td>${ a.idCuaHang.ten }</td>
            <td>${ a.idChucVu.ten }</td>
            <td>${ a.matKhau }</td>
            <td>${ a.trangThai == '1'?'Đang làm':'Đã Nghỉ' }</td>
            <td>${ a.email }</td>
            <td>
                <a href="/admin/nhan-vien/edit/${a.id}">Cập nhật</a>

                <a href="/admin/nhan-vien/delete/${a.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>