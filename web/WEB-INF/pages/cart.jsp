<%--
  Created by IntelliJ IDEA.
  User: Seek
  Date: 2017/2/26
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<center>
    <table>
        <tr>
            <%--<td>书名</td>--%>
            <td>数量</td>
            <td>价格</td>
            <td>&nbsp;</td>
        </tr>

        <c:forEach items="${sessionScope.shoppingCart.items}" var="item">
            <tr>
                <%--<td> ${item.book.title}</td>--%>
                <td>${item.book.storeNumber}</td>
                <td> ${item.book.price}</td>
                <td><a href="">删除</a></td>
                    <%--${item.book.title} - ${item.book.price} - ${item.book.storeNumber}--%>
            </tr>

        </c:forEach>

        <tr>
            <td colspan="4">总金额：￥${sessionScope.shoppingCart.totalMoney}</td>
        </tr>

        <tr>
            <td colspan="4">
                <a href="">继续购物</a>
                <a href="">清空购物车</a>
                <a href="">结账</a>
            </td>
        </tr>

    </table>
    购物车共有${sessionScope.shoppingCart.bookNumber}本书
    <br><br>
</center>


<a href="bookServlet?method=forwardPage&page=cart&pageNo=${bookpage.pageNo }">查看购物车</a>
<br>


</body>
<head>
    <title>Title</title>
</head>
</html>