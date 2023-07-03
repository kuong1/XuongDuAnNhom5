<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>SD17313 - Thêm mới Lịch Sử Nhập</title>
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
             modelAttribute="lsn">
        <div>
            <label>Tên Sản Phẩm</label>
            <div>
                <sf:select path="idSpNhap">
                    <c:forEach var="a" items="${chiTietDoGoList}">
                        <sf:option value="${a.id}">${a.tenSP}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>

        <div>
            <label>Số Lượng Nhập</label>
            <div>
                <sf:input type="number" path="soLongNhap" class="form-control"/>
                <sf:errors path="soLongNhap"/>
            </div>
        </div>

<%--        <div>--%>
<%--            <label>Ngày Nhập</label>--%>
<%--            <div>--%>
<%--                <sf:input type="date" path="ngayNhap" class="form-control"/>--%>
<%--                <sf:errors path="ngayNhap"/>--%>
<%--            </div>--%>
<%--        </div>--%>

        <div>
            <label>Tổng Tiền</label>
            <div>
                <sf:input type="number" path="tongTienNhap" class="form-control"/>
                <sf:errors path="tongTienNhap"/>
            </div>
        </div>


        <div>
            <button class="btn btn-primary">Thêm mới</button>
        </div>
    </sf:form>
</div>

</body>
</html>
