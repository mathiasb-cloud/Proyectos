<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entidades.Pelicula" %>
<%@ page import="entidades.Genero" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Película</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h2>Editar Película</h2>
        <%
            Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
            List<Genero> listaGeneros = (List<Genero>) request.getAttribute("listaGeneros"); // lista de géneros para el select
            if (pelicula == null) {
        %>
            <div class="alert alert-danger">No se encontró la película a editar.</div>
        <%
            } else {
        %>
        <form action="PeliculaServlet" method="post">
            <input type="hidden" name="accion" value="actualizar">
            <input type="hidden" name="idpelicula" value="<%= pelicula.getIdpelicula() %>">

            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="<%= pelicula.getNombre() %>" required>
            </div>

            <div class="mb-3">
                <label for="director" class="form-label">Director</label>
                <input type="text" class="form-control" id="director" name="director" value="<%= pelicula.getDirector() %>" required>
            </div>

            <div class="mb-3">
                <label for="fechaEstreno" class="form-label">Fecha de Estreno</label>
                <input type="date" class="form-control" id="fechaEstreno" name="fechEstreno" value="<%= pelicula.getFechEstreno() != null ? pelicula.getFechEstreno().toString() : "" %>" required>
            </div>

            <div class="mb-3">
                <label for="genero" class="form-label">Género</label>
                <select id="genero" name="idgenero" class="form-select" required>
                    <option value="">Seleccione un género</option>
                    <%
                        if (listaGeneros != null) {
                            for (Genero g : listaGeneros) {
                    %>
                    <option value="<%= g.getIdgenero() %>" <%= (pelicula.getGenero() != null && pelicula.getGenero().getIdgenero() == g.getIdgenero()) ? "selected" : "" %>><%= g.getNombre() %></option>
                    <%
                            }
                        }
                    %>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
            <a href="listaPeliculas.jsp" class="btn btn-secondary">Cancelar</a>
        </form>
        <%
            }
        %>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
