<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Estudiante</title>
</head>
<body>
    <h2>Registrar Estudiante</h2>
    <form action="EstudianteServlet" method="post">
        ID Estudiante: <input type="number" name="idEstudiante" required><br><br>
        Nombres y Apellidos: <input type="text" name="nombresApellidos" required><br><br>
        Documento: <input type="text" name="documento" required><br><br>
        Teléfono: <input type="text" name="telefono"><br><br>
        Carrera: <input type="text" name="carrera"><br><br>
        Tipo Documento (ID numérico): <input type="number" name="tipoDocumento" required><br><br>
        <input type="submit" value="Registrar">
    </form>

    <%
        String mensaje = (String) request.getAttribute("mensaje");
        if (mensaje != null) {
    %>
        <p style="color: green;"><%= mensaje %></p>
    <%
        }
    %>
</body>
</html>