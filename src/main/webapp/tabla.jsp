<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Información</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">

      <a class="btn btn-info mt-3" href="transaccion.jsp">Nueva Transaccion </a>
      <label for="importe" class="form-label fst-italic mx-auto"><strong><c:out value="${nombreU}"></c:out></strong></label>
      

 <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>FECHA</th>
            <th>TIPO</th>
            <th>CLASE</th>
            <th>CANTIDAD</th>
            <th>ACCIONES</th>
        </tr>

        <!--RECORRIDO FOR EACH DE LA TABLA-->
        <c:forEach var="tabla" items="${listaA}">
        <tr>
            <th><c:out value="${tabla.idT}"></c:out></th>
            <td><c:out value="${tabla.fechahora}"></c:out></td>
            <td><c:out value="${tabla.nombreT}"/></td>
            <td><c:out value="${tabla.detalles}"/></td>
            <td><c:out value="${tabla.importe}"></c:out></td>
           <td>
               <a href="Controller?opcion=eliminar&pagina=1&cod=<c:out value='${tabla.idT}'></c:out> " class="btn fs-6"> &#128465;</a>
           </td>


        </tr>
        </c:forEach>
        </table>
</div>
</body>
</html>