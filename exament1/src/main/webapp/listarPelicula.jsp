<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entidades.Pelicula" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Películas</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h2>Lista de Películas</h2>
            <a href="registrarPelicula.jsp" class="btn btn-primary">Registrar Nueva Película</a>
        </div>

        <div class="table-responsive">
            <table class="table table-bordered table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Director</th>
                        <th>Fecha de Estreno</th>
                        <th>Género</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        @SuppressWarnings("unchecked")
                        List<Pelicula> lista = (List<Pelicula>) request.getAttribute("lista");
                        if (lista != null && !lista.isEmpty()) {
                            for (Pelicula p : lista) {
                    %>
                    <tr>
                        <td><%= p.getIdpelicula() %></td>
                        <td><%= p.getNombre() %></td>
                        <td><%= p.getDirector() %></td>
                        <td><%= p.getFechEstreno() %></td>
                        <td><%= (p.getGenero() != null) ? p.getGenero().getNombre() : "Sin género" %></td>
                        <td>
                            <a href="PeliculaServlet?accion=editar&id=<%= p.getIdpelicula() %>">Editar</a> |
                            <a href="PeliculaServlet?accion=eliminar&id=<%= p.getIdpelicula() %>" onclick="return confirm('¿Seguro?')">Eliminar</a>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="6" class="text-center">No hay películas registradas</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Bootstrap JS (opcional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
