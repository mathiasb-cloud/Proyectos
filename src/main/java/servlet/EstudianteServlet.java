package servlet;

import java.io.IOException;

import dao.EstudianteDAPImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Estudiante;

@WebServlet("/EstudianteServlet")
public class EstudianteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));
        String nombresApellidos = request.getParameter("nombresApellidos");
        String documento = request.getParameter("documento");
        String telefono = request.getParameter("telefono");
        String carrera = request.getParameter("carrera");
        int tipoDocumento = Integer.parseInt(request.getParameter("tipoDocumento"));

        Estudiante estudiante = new Estudiante();
        estudiante.setIdEstudiante(idEstudiante);
        estudiante.setNombresApellidos(nombresApellidos);
        estudiante.setDocumento(documento);
        estudiante.setTelefono(telefono);
        estudiante.setCarrera(carrera);
        estudiante.setTipoDocumento(tipoDocumento);

        EstudianteDAPImp dao = new EstudianteDAPImp();
        dao.create(estudiante);

        request.setAttribute("mensaje", "Estudiante registrado exitosamente.");
        request.getRequestDispatcher("registroEstudiante.jsp").forward(request, response);
    }
}