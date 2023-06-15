<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="es">
<head>
  <title>Gegado</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container text-center">
  <form class="needs-validation" novalidate action="Controller" method="get">
<div class="text-center mx-auto">
<h1>Transacción</h1>
<hr>
<hr>
</div>
<div class="row border border-black mx-auto">
<div class="text-start">
<input type="radio" id="ingresos" name="categoria" value="ingresos" class="mt-4" required>
<label for="ingresos"><strong>Ingresos</strong></label><br>
<input type="radio" id="gastos" name="categoria" value="gastos" class="mt-3">
<label for="gastos"><strong>Gastos</strong></label><br>
</div>
<div class="invalid-feedback">
     Tienes que seleccionar uno
      </div>
<div class="col-md-3 ">
      <label for="importe" class="form-label fst-italic"><strong>Importe</strong></label>
      <input type="number" class="form-control" id="importe" name="importe" required max="999999" min="0" step="0.01" required>
      <div class="invalid-feedback">
       La cantidad introducida es incorrecta
      </div>

<div class="row-md-3 mx-auto p-2 px-3">
		      <label for="nombreC" class="form-label fst-italic"><strong>Información sobre el movimiento</strong></label>
		            <label for="nombreC" class="form-label fst-italic"><strong>(Reducido a una palabra)</strong></label>
       <input type="text" class="form-control"  name="nombreC" id="nombreC" maxlength="50" placeholder="Ejemplo: coche, cumpleaños" required>
</div>
<h4>Choose your icon</h4>
<div class="text-end">
<c:forEach items="${icon}" var="icon">
<input type="checkbox" class="btn-check" name="icon" autocomplete="off" id="icon" value="<c:out value="${icon}"/>">
<img src="<c:url value="${icon}"></c:url>" class="btn" alt="icono" width="70">

</c:forEach>
</div>
</div>
<div class="row my-auto">
<div class="col-md-3 mx-auto p-2 px-3">
      <button class="btn btn-success mt-3" type="submit">Añadir</button>
   
      <a class="btn btn-danger mt-3" href="index.jsp">Cancelar </a>
    </div>
</div>
</div>

</form>
<script src="<c:url value="js/script.js"/>"></script>

</div>
</body>
</html>