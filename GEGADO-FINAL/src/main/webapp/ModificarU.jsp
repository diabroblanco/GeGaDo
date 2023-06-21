<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="es">
<head>
  <title>GeGaDo</title>
  <link rel="stylesheet" href="css/styleModificarU.css" type="text/css">
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

<h2 class="text-center">Editar Usuario</h2>
<hr>
<div class="container">
  <h4 class="text-center my-2">Actualización</h4>

  <!--Enviamos el formulario que lo lea el Controller -->
  <form action="Controller"  method="post" class="needs-validation text-center" novalidate >

    <input type="hidden" name="opcion" value="modificar">
	<input type="hidden" name="nombre" value='<c:out value="${nombre}"></c:out>'>
	<input type="hidden" name="idU" value="${idU}">

    <div class="needs-validation">
      <div class="row">
        <div class="col-md-4 mx-auto">
          <label for="nombreU" class="form-label">Nombre de usuario</label>
          <input type="text" class="form-control" id="nombreU" name="nombreU" required maxlength="50"
                 value='<c:out value="${nombreU}"></c:out>'>
          <div class="invalid-feedback">
            Nombre requerido!
          </div>
        </div>
       
        <div class="col-md-2 mx-auto">
          <label for="passU" class="form-label">Contraseña actual</label>
          <input type="password" class="form-control" id="passU" name="passU" required>
          <div class="invalid-feedback">
            Contraseña requerida!
          </div>
        </div>
        <div class="col-md-2 mx-auto">
          <label for="passU2" class="form-label">Contraseña nueva</label>
          <input type="password" class="form-control" id="passU2" name="passU2" required pattern="(?=.*\d)(?=.*[\W_]).{8,}">
          <div class="invalid-feedback">
            Contraseña requerida!
          </div>
        </div>
      </div>
      </div>
      <div class="row my-4">
        <div class="col-6 ">
          <button class="btn btn-primary text-end" type="submit">Modificar</button>
        </div>
        <div class="col-6 ">
          <!-- Comentario de Javi: Añadido código javascript para que el botón 'Cancelar' haga bien su función -->
      <a class="btn btn-primary" href="Controller?id=${idU}&nombreU=${nombreU}&opcion=todo">Cancelar</a>
        </div>
      </div>
  </form>
  
<script src="<c:url value="js/script.js"/>"></script>

</div>
</body>
</html>
