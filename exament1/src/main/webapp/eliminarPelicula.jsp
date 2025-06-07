<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entidades.Pelicula" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Eliminar Película</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h2>Eliminar Película</h2>
       
        <div class="alert alert-warning">
            ¿Está seguro que desea eliminar la película: <strong>Moana</strong>?
        </div>

        <form action="PeliculaServlet" method="post">
            <input type="hidden" name="accion" value="eliminar">
            <input type="hidden" name="idpelicula" value="2">
            <button type="submit" class="btn btn-danger">Eliminar</button>
            <a href="listaPeliculas.jsp" class="btn btn-secondary">Cancelar</a>
        </form>
       
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
