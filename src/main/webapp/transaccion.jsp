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
<select class="form-select " aria-label="Default select example" name="opcionBusq" onchange="carg(this)" required>
    <option selected> </option>
    <option value="nomina">&#128176; Nómina o Pensión</option>
    <option value="venta">&#128176; Venta</option>
    <option value="coche">&#9936; Coche</option>
    <option value="compra">&#128717; Compra</option>
    <option value="regalos">&#127874; Regalos</option>
    <option value="subvenciones">&#128076; SUBVENCIONES</option>
    <option value="otros">Otros...</option>
</select>
    <input id="nuevoC" id="nuevoC"  >
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
<script>
  (() => {
    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    const forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.from(forms).forEach(form => {
      form.addEventListener('submit', event => {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }

        form.classList.add('was-validated')
      }, false)
    })
  })()
  
  var input = document.getElementById('nuevoC');

function carg(elemento) {
  d = elemento.value;
  
  if(d == "otros"){
    input.disabled = false;
  }else{
    input.disabled = true;
  }
}

</script>
</div>
</body>
</html>