<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rcdeanda10
  Date: 2/2/23
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Final Result</title>
</head>
<body>
  <c:choose>
    <c:when test="${result}">
      <h1>Winner Winner Chicken Dinner!</h1>
    </c:when>
    <c:otherwise>
      <h1>Better Luck Next Time.</h1>
      </c:otherwise>
  </c:choose>
  <a ref="/guess">Play Again?</a>

</body>
</html>
