<%--
  Created by IntelliJ IDEA.
  User: Seek
  Date: 2017/2/25
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <script type="text/javascript" src="../../script/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("a").click(function(){
                var serializeVal = $(":hidden").serialize();
                var href = this.href + "&" + serializeVal;
                window.location.href = href;
                return false;
            });
        })
    </script>

    <input type="hidden" name="minPrice" value="${param.minPrice}"/>
    <input type="hidden" name="maxPrice" value="${param.maxPrice}"/>
