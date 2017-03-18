<%--
  Created by IntelliJ IDEA.
  User: Seek
  Date: 2017/2/23
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../commons/queryCondition.jsp" %>
<html>
<head>
    <title>Books</title>
</head>
<body>

<center>
    <%

    %>

    <c:if test="${param.title!=null}">
        已经将${param.title} 放入购物车
    </c:if>

    <%--<c:if test="${!empty sessionScope.shoppingCart.books}">--%>
        <%--您的购物车中有 ${sessionScope.shoppingCart.bookNumber} 本书,--%>
        <%--<a href="bookServlet?method=forwardPage&page=cart&pageNo=${bookpage.pageNo }">查看购物车</a>--%>
    <%--</c:if>--%>

    <c:if test="${sessionScope.shoppingCart.books != null}">
        购物车中有${sessionScope.shoppingCart.bookNumber}本书。
        <%--<a href="bookServlet?method=forwardPage&page=cart&pageNo=${bookpage.pageNo }">查看购物车</a>--%>
        <br>
        <a href="bookServlet?method=toCartPage&page=cart&pageNo=${bookPage.pageNo}">查看购物车</a>
    </c:if>

    <br><br>
    Hello11
    <form action="bookServlet?method=getBooks" method="post">
        Price:<input type="text" size="1" name="minPrice"/> -
        <input type="text" size="1" name="maxPrice"/>
        <input type="submit" value="查找"/>
    </form>

    <table cellspacing="10">
        <c:forEach items="${bookPage.list}" var="book">
            <tr>
                <td>
                    <a href="bookServlet?method=getBook&pageNo=${bookPage.pageNo}&id=${book.id}">
                        ${book.title}
                    </a>
                    <br> ${book.author}
                </td>

                <td>${book.price}</td>

                <td>
                    <a href="bookServlet?method=addToCart&pageNo=${bookPage.pageNo}&id=${book.id}&title=${book.title}">
                        加入购物车
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br><br>

    共${bookPage.totalPageNumber}页
    &nbsp;&nbsp;
    当前第 ${bookPage.pageNo} 页
    &nbsp;&nbsp;

    <c:if test="${bookPage.hasPrev}">
        <a href="bookServlet?method=getBooks&pageNo=1">首页</a>
        &nbsp;&nbsp;
        <a href="bookServlet?method=getBooks&pageNo=${bookPage.prePage}">上一页</a>
    </c:if>

    &nbsp;&nbsp;
    <c:if test="${bookPage.hasNext}">
        <a href="bookServlet?method=getBooks&pageNo=${bookPage.nextPage}">下一页</a>
        &nbsp;&nbsp;
        <a href="bookServlet?method=getBooks&pageNo=${bookPage.totalPageNumber}">末页</a>
    </c:if>
</center>
</body>
</html>