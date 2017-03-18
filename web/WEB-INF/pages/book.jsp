<%--
  Created by IntelliJ IDEA.
  User: Seek
  Date: 2017/2/25
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../commons/queryCondition.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>

        <br>
        书名: ${book.title}
        <br>
        <br>
        作者: ${book.author}
        <br>
        <br>
        价格：${book.price}
        <br>
        <br>
        出版时间:${book.publishingDate}
        <br>
        <br>
        备注：${book.remark}
        <br>
        <a href="bookServlet?method=getBooks&pageNo=${param.pageNo}">继续购物</a>
    </center>

</body>
</html>
