<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>SD17313 - Thêm Chi Tiết Đồ Gỗ</title>
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
             modelAttribute="chiTietDoGo">

        <div>
            <label>Sản Phẩm</label>
            <div>
                <sf:select path="idSanPham">
                    <c:forEach var="a" items="${spList}">
                        <sf:option value="${a.id}">${a.ten}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>

        <div>
            <label>Loại Sản Phẩm</label>
            <div>
                <sf:select path="idLoaiSP">
                    <c:forEach var="a" items="${loaiSPList}">
                        <sf:option value="${a.id}">${a.ten}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>

        <div>
            <label>Dòng Gỗ</label>
            <div>
                <sf:select path="idDongGo">
                    <c:forEach var="a" items="${dongGoList}">
                        <sf:option value="${a.id}">${a.ten}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>


        <div>
            <label>Nhà Cung Cấp</label>
            <div>
                <sf:select path="idNhaCungCap">
                    <c:forEach var="a" items="${nhaCungCapList}">
                        <sf:option value="${a.id}">${a.ten}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>


        <div>
            <label>Nguồn Gốc</label>
            <div>
                <sf:select path="idNguonGoc">
                    <c:forEach var="a" items="${nguonGocList}">
                        <sf:option value="${a.id}">${a.quocGia}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>

        <div>
            <label>Đơn Vị Tính</label>
            <div>
                <sf:select path="idDonViTinh">
                    <c:forEach var="a" items="${donViTinhList}">
                        <sf:option value="${a.id}">${a.donViTinh}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>
        <div>
            <label>Ảnh</label>
            <div>
                <sf:select path="idAnh">
                    <c:forEach var="a" items="${anhList}">
                        <sf:option value="${a.id}">${a.ma}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>


        <div>
            <label>Tên Sản Phẩm</label>
            <div>
                <sf:input path="tenSP" class="form-control"/>
                <sf:errors path="tenSP"/>
            </div>
        </div>

        <div>
            <label>Số Lượng</label>
            <div>
                <sf:input type="number" path="soLuong" class="form-control"/>
                <sf:errors path="soLuong"/>
            </div>
        </div>

        <div>
            <label>Giá Nhập</label>
            <div>
                <sf:input type="number" path="giaNhap" class="form-control"/>
                <sf:errors path="giaNhap"/>
            </div>
        </div>
        <div>
            <label>Giá Bán</label>
            <div>
                <sf:input type="number" path="giaBan" class="form-control"/>
                <sf:errors path="giaBan"/>
            </div>
        </div>


        <div>
            <label>Mô Tả</label>
            <div>
                <sf:input path="moTa" class="form-control"/>
                <sf:errors path="moTa"/>
            </div>
        </div>

        <div>
            <label>Trạng Thái</label>
            <div>
                <sf:radiobutton value="1" label="1" path="trangThai" checked="true"/>
                <sf:radiobutton value="0" label="0" path="trangThai"/>
                <sf:errors path="trangThai"/>
            </div>
        </div>

        <div>
            <button class="btn btn-primary">Thêm mới</button>
        </div>
    </sf:form>
</div>

</body>
</html>
