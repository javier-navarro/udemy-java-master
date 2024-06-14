<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="layout/header.jsp" />
<h3>${title}</h3>
<ul class="list-group">
    <li class="list-group-item active">Menu de Opciones</li>
    <li class="list-group-item"> <a href="${pageContext.request.contextPath}/productos.html"> Mostrar productos html</a> </li>
    <li class="list-group-item"> <a href="${pageContext.request.contextPath}/login.html">Login</a> </li>
    <li class="list-group-item"> <a href="${pageContext.request.contextPath}/logout">Cerrar Sesion</a> </li>
    <li class="list-group-item"> <a href="${pageContext.request.contextPath}/carro/ver">Ver carro</a> </li>
</ul>
<jsp:include page="layout/footer.jsp" />