<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*"%>
<html>
    <head>
        <title>Beer Recommendations JSP</title>
    </head>
    <body>
        <h1 align="center">Beer Recommendations JSP</h1>
        <p>
            <c:forEach var="item" items="${styles}">
                <br/>try: ${item}
            </c:forEach>
        </p>
    </body>
</html>
