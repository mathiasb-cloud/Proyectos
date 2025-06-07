<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="entidades.Genero" %>
<%@ page import="dao.GeneroDaoImpl" %>
<%@ page import="java.util.List" %>
<%
    GeneroDaoImpl dao = new GeneroDaoImpl();
    List<Genero> generos = dao.findAll();
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Película</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header bg-dark text-white">
                <h4 class="mb-0">Registrar Película</h4>
            </div>
            <div class="card-body">
                <form action="PeliculaServlet" method="post">
                    <input type="hidden" name="accion" value="registrar" />
                    <div class="mb-3">
                        <label class="form-label">Nombre</label>
                        <input type="text" name="nombre" class="form-control" required />
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Director</label>
                        <input type="text" name="director" class="form-control" required />
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Fecha de Estreno</label>
                        <input type="date" name="fechEstreno" class="form-control" required />
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Género</label>
                        <select name="idgenero" class="form-select">
                            <% for (Genero g : generos) { %>
                                <option value="<%= g.getIdgenero() %>"><%= g.getNombre() %></option>
                            <% } %>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-success">Guardar</button>
                    <a href="PeliculaServlet?accion=listar" class="btn btn-secondary ms-2">Volver</a>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
