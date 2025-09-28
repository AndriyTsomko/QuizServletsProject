<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Питання</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="quiz-page">
<div class="container">
    <h2>Питання <c:out value="${currentQuestionIndex + 1}"/> з <c:out value="${questionsCount}"/></h2>
    <p>Помилки: <span class="tries"><c:out value="${tries} із ${totalTries}"/></span></p>

    <img src="images/<c:out value="${image}"/>" alt="Фото боксера" class="boxer-photo">

    <form action="/quiz" method="post">
        <div class="options">
            <c:forEach var="option" items="${options}">
                <label class="option">
                    <input type="radio" name="answer" value="<c:out value="${option}"/>" required>
                    <span><c:out value="${option}"/></span>
                </label>
            </c:forEach>
        </div>
        <button type="submit" class="btn">Далі</button>
    </form>
</div>
</body>
</html>