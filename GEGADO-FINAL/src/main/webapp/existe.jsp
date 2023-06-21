<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="es">
<head>
  <title>Gegado</title>
        <link rel="stylesheet" href="css/styleexiste.css" type="text/css">

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

	<div class="container text-center">
<h2 class="text-center">Inicio de sesión</h2>
  <hr>

  <form class="row g-3 needs-validation" novalidate action="Controller" method="post">
        <input type="hidden" name="opcion" value="buscar">
  <div class="col-md-4 col-xl-4 mx-auto">
      <label for="nombreU" class="form-label">Nombre de usuario</label>
      <input type="text" class="form-control"  name="nombreU" id="nombreU" maxlength="50" autofocus placeholder="Nombre" required>
      <div class="invalid-feedback">
      Nombre de usuario vacío o mal
      </div>
    </div>
 <div class="col-md-4 col-xl-4 mx-auto text-center pb-2">
  <div class="col-auto">
    <label for="passU" class="col-form-label" >Password</label>
  </div>
  <div class="col-auto">
    <input type="password" id="passU" name="passU" class="form-control" aria-labelledby="passwordHelpInline" pattern="(?=.*\d)(?=.*[\W_]).{8,}" required placeholder="8 caracteres mínimo, debe teber un caracter especial y numero">
  </div>
    </div>
 
    <div class="row">
<hr>
<div class="col mt-auto ms-3 text-center">
      <button class="btn btn-primary" type="submit">Iniciar sesión</button>
    </div>
    <div class="col-6">
      <a class="btn btn-primary" href="index.jsp">Cancelar</a>
</div>
    </div>
 </form>
 <script src="<c:url value="js/script.js"/>"></script>
</div>
</body>
</html>
