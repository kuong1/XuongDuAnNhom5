<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>SD17313 - CHI TIẾT ĐỒ GỖ</title>

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
<h1>Danh Sách Chi Tiết Đồ Gỗ</h1>
<a href="/admin/chi-tiet-do-go/create" class="btn btn-primary">Thêm mới</a>
<table class="table table-bordered ">
    <thead>
    <th>ID</th>
    <th>Sản Phẩm</th>
    <th>Loại Sản Phẩm</th>
    <th>Dòng Gỗ</th>
    <th>Nhà Cung Cấp</th>
    <th>Nguồn Gốc</th>
    <th>Đơn Vị Tính</th>
    <th>Tên Sản Phẩm</th>
    <th>Số Lượng</th>
    <th>Giá Nhập</th>
    <th>Giá Bán</th>
    <th>Mô Tả</th>
    <th>Trạng Thái</th>
    <th>Ảnh</th>
    <th colspan="2">Thao tác</th>
    </thead>
    <tbody>
    <c:forEach items="${ chiTietDoGoList }" var="a">
        <tr>
            <td>${ a.id }</td>
            <td>${ a.idSanPham.ten }</td>
            <td>${ a.idLoaiSP.ten }</td>
            <td>${ a.idDongGo.ten }</td>
            <td>${ a.idNhaCungCap.ten }</td>
            <td>${ a.idNguonGoc.quocGia }</td>
            <td>${ a.idDonViTinh.donViTinh }</td>
            <td>${ a.tenSP }</td>
            <td>${ a.soLuong }</td>
            <td>${ a.giaNhap }</td>
            <td>${ a.giaBan }</td>
            <td>${ a.moTa }</td>
            <td>${ a.trangThai }</td>
            <td>${ a.idAnh.ma }</td>
            <td>
                <a href="/admin/chi-tiet-do-go/edit/${a.id}">Cập nhật</a>

                <a href="/admin/chi-tiet-do-go/delete/${a.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>