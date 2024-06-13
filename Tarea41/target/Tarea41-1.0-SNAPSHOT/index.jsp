<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tarea4</title>
</head>
<body>
    <h1 style="color: ${cookie.color.getValue()}" > Tarea 4: Cambiar el color de los textos </h1>
    <h3 style="color: ${cookie.color.getValue()}"> Este es un texto que cambia de color segun las opciones</h3>
    <h4>Cambiar Color</4>

    <form action="/Tarea41/cambiar-color" method="get">
        <select name="color" id="color">
            <option value="blue">Azul</option>
            <option value="red">Rojo</option>
            <option value="green">Verde</option>
            <option value="aqua">Aqua</option>
            <option value="BlueViolet">Violeta</option>
            <option value="Gray">Gris</option>
            <option value="Cyan">Cyan</option>
        </select>
        <input type="submit" value="cambiar">
    </form>

</body>
</html>