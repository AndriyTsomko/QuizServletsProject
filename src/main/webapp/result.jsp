<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Перемога!</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="result-page">
<div class="container">
    <h1>Вітаємо! 🎉</h1>
    <h2>Ти вгадав усіх боксерів!</h2>
    <p>Кількість помилок: <span class="tries"><c:out value="${tries}"/></span></p>
    <div class="btn-group">
        <a href="/" class="btn">На головну</a>
    </div>
</div>
</body>
</html>