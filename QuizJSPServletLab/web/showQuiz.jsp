<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Quiz in JSP now</title> 
        <meta charset="utf-8" />
    </head>
    <body>
        <h1>The Number Quiz</h1>
        <form method="POST">
            <p><label>Type your age: <input type="text" name="age" value="${age}" /> ${ageMessage}</label></p>
            <c:forEach var="line" items="${quiz.getCurrentQuestion()}">
                <p>${line}</p>
            </c:forEach>
            <c:if test="${!quiz.isFinished()}">
                    <p>
                        <label>
                            Your answer: <input type="text" name="guess" /> <span id="tipArea" style="display: none;">${quiz.getCurrentTip()}</span>
                        </label>
                        <button type="button" onClick="document.getElementById('tipArea').style.display = 'inline'; this.style.display = 'none';">TIP NAO!</button>
                    </p>
                    <p>
                        <input type="submit" value="Submit" />
                    </p> 
            </c:if>
        </form>
    </body>
</html>