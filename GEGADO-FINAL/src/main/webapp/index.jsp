<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>GeGaDo</title>
        <link rel="stylesheet" href="css/styleindex.css" type="text/css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>

<c:if test="${not empty msgExito}">
	<div class="alert alert-success text-center" role="alert">
		<c:out value="${msgExito}"/>
	</div>
</c:if>

<c:if test="${not empty msgError}">
	<div class="alert alert-danger text-center" role="alert">
		<c:out value="${msgError}"/>
	</div>
</c:if>

<jsp:include page="header.jsp"/>
<form>
<div class="col mx-auto mx-4 px-4 text-center">
      <a class="btn btn-outline-dark" href="alta.jsp">Nuevo usuario</a>
      <a class="btn btn-outline-dark" href="existe.jsp">Iniciar sesión</a>
</div>
</form>
</body>
</html>
