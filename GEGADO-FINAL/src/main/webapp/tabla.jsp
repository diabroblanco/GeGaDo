<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Información</title>
<link rel="stylesheet" href="css/styletabla.css" type="text/css">
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

<div class="container">
<form action="Controller" method="get">
<div class="container-fluid hstack gap-3">
      <input type="hidden" name="id" value="${idU}">
      <input type="hidden" name="nombreU" value="${nombreU}">
      
      <a class="btn btn-info mt-3 text-center" href="Controller?id=${idU}&nombreU=${nombreU}&opcion=nuevaTransaccion">Nueva Transacción</a>
      <!--  <label for="importe" class="form-label fst-italic mx-auto p-3"><strong><c:out value="${nombreU}"></c:out>&#129503;</strong></label>-->
      <label for="importe" class="form-label fst-italic mx-auto p-3"><strong>${nombreU}&#129503;</strong></label>
      <a class="btn btn-info mt-3" href="Controller?id=${idU}&opcion=modificacion">Editar Usuario</a>
      <a class="btn btn-danger mt-3" href="Controller?opcion=cerrarSesion">Cerrar Sesión</a>
      
     <div class="hstack gap-3">
  <select class="form-select mt-2 " aria-label="Default select example" name="opcion">
    <option selected value="sinEleccion">Método de búsqueda</option>
    <option value="todo">Ingresos y gastos</option>
    <option value="ingresos">Sólo ingresos</option>
    <option value="gastos">Sólo gastos</option>
 
     </select>
    

   </div>
      <button class="btn btn-outline-dark" type="submit" name="search">Buscar</button>
      
</div>
 <table class="table table-hover">
        <tr>
            <th>CATEGORIA</th>
            <th>DETALLES</th>
            <th>TIPO</th>
            <th>CANTIDAD</th>
            <th>FECHA</th>
            <th>ACCIONES</th>
        </tr>

        <!--RECORRIDO FOR EACH DE LA TABLA-->
        <c:forEach var="tabla" items="${listaA}">
        <tr>
            <th><c:out value="${tabla.nombreC}"/></th>
            <td><c:out value="${tabla.detalles}"></c:out></td>
            <td><c:out value="${tabla.nombreT}"/></td>          
            <td><c:out value="${tabla.importe}"></c:out></td>
            <td><c:out value="${tabla.fecha}"></c:out></td>
           <td>
               <a href="Controller?idU=${idU}&nombreU=${nombreU}&opcion=eliminarMovimiento&pagina=1&id=<c:out value='${tabla.id}'></c:out>" class="btn fs-6">&#128465;</a>
           </td>
        </tr>
        </c:forEach>
        </table>
</form>
</div>
</body>
</html>
