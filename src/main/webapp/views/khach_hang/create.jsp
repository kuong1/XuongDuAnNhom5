<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>SD17313 - Thêm mới Khách Hàng</title>
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
<div class="container">
    <sf:form action="${action}" method="post"
             modelAttribute="khachHang">


        <div>
            <label>Mã</label>
            <div>
                <sf:input path="ma" class="form-control"/>
                <sf:errors path="ma"/>
            </div>
        </div>

        <div>
            <label>Tên Khách Hàng</label>
            <div>
                <sf:input path="tenKhachHang" class="form-control"/>
                <sf:errors path="tenKhachHang"/>
            </div>
        </div>

        <div>
            <label>Số Điện Thoại</label>
            <div>
                <sf:input type="number" path="sdt" class="form-control"/>
                <sf:errors path="sdt"/>
            </div>
        </div>

        <div>
            <label>Địa Chỉ</label>
            <div>
                <sf:input path="diaChi" class="form-control"/>
                <sf:errors path="diaChi"/>
            </div>
        </div>

        <div>
            <label>Trạng Thái</label>
            <div>
                <sf:radiobutton value="1" label="Đang làm việc" path="trangThai" checked="true"/>
                <sf:radiobutton value="0" label="Đã nghỉ" path="trangThai"/>
                <sf:errors path="trangThai"/>
            </div>
        </div>


        <div>
            <label> Hạng Khách Hàng</label>
            <div>
                <sf:select path="idHangKhachHang">
                    <c:forEach var="a" items="${hangKhachHangList}">
                        <sf:option value="${a.id}">${a.tenHang}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>


        <div>
            <button class="btn btn-primary">Thêm mới</button>
        </div>
    </sf:form>
</div>

</body>
</html>
