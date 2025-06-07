package servlet;

import dao.*;
import entidades.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/PeliculaServlet")

public class PeliculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PeliculaDao dao = new PeliculaDaoImpl();
		GeneroDao generoDao = new GeneroDaoImpl();
		String accion = request.getParameter("accion");

		switch (accion == null ? "listar" : accion) {
			case "editar":
				int idEditar = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("pelicula", dao.find(idEditar));
				request.setAttribute("generos", generoDao.findAll());
				request.getRequestDispatcher("editarPelicula.jsp").forward(request, response);
				break;
			case "eliminar":
				int idEliminar = Integer.parseInt(request.getParameter("id"));
				dao.delete(idEliminar);
				response.sendRedirect("PeliculaServlet");
				break;
			case "listar":
			default:
				request.setAttribute("lista", dao.findAll());
				request.getRequestDispatcher("listarPelicula.jsp").forward(request, response);
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PeliculaDao dao = new PeliculaDaoImpl();
		GeneroDao generoDao = new GeneroDaoImpl();
		String accion = request.getParameter("accion");

		String nombre = request.getParameter("nombre");
		String director = request.getParameter("director");
		String fecha = request.getParameter("fechEstreno");
		int idGenero = Integer.parseInt(request.getParameter("idgenero"));
		Genero genero = generoDao.find(idGenero);

		Pelicula p;
		if ("actualizar".equals(accion)) {
			int id = Integer.parseInt(request.getParameter("idpelicula"));
			p = dao.find(id);
		} else {
			p = new Pelicula();
		}

		p.setNombre(nombre);
		p.setDirector(director);
		p.setFechEstreno(java.sql.Date.valueOf(fecha));
		p.setGenero(genero);

		if ("actualizar".equals(accion)) {
			dao.update(p);
		} else {
			dao.create(p);
		}

		response.sendRedirect("PeliculaServlet");
	}
}
