<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%
    Map <String,String> errores = (Map<String,String>)request.getAttribute("errores");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>tarea 39</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <h1> Formulario de Registro </h1>

    <%
        if(errores != null){
        %>
        <ul class="alert alert-danger px-5">
            <% for(String error: errores.values()) { %>
            <li> <%=error%> </li>
            <%}%>
        </ul>
    <%}%>
    <div class="px-5">
    <form action="/Tarea39/crear" method="post">
     <div class="row mb-3">
         <label for="nombre" class="col-form-label col-sm-2"> USUARIO</label>
         <div class="col-sm-4 ">
             <input type="text" name="nombre" id="nombre"  class="form-control" value="${param.nombre}">
         </div>
         <%
         if(errores != null && errores.containsKey("nombre")){
             out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>"+errores.get("nombre")+ "</small>");
         }
         %>
     </div>

     <div class="row mb-3">
          <label for="precio" class="col-form-label col-sm-2"> PRECIO</label>
          <div class="col-sm-4 ">
              <input type="text" name="precio" id="precio"  class="form-control" value="${param.precio}">
          </div>
          <%
          if(errores != null && errores.containsKey("precio")){
              out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>"+errores.get("precio")+ "</small>");
          }
          %>
      </div>

      <div class="row mb-3">
            <label for="fabricante" class="col-form-label col-sm-2"> FABRICANTE</label>
            <div class="col-sm-4 ">
                <input type="text" name="fabricante" id="fabricante"  class="form-control" value="${param.fabricante}">
            </div>
            <%
            if(errores != null && errores.containsKey("fabricante")){
                out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>"+errores.get("fabricante")+ "</small>");
            }else{
            out.println("<small class='alert alert-danger col-sm-4' style='color: red;'>algo salio mal </small>");
            }
            %>
      </div>


    </form>
    <input type="submit" value="Enviar" class="btn btn-primary">
</body>
</html>