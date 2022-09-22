package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import model.Destino;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet(urlPatterns = { "/destino", "/cadastrar-destino", "/editar-destino", "/atualizar-destino",
		"/deletar-destino" })
public class DestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DestinoDAO destinoDao = new DestinoDAO();
	Destino destino = new Destino();

	public DestinoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/destino":
			read(request, response);
			break;

		case "/cadastrar-destino":
			create(request, response);
			break;

		case "/editar-destino":
			readById(request, response);
			break;

		case "/atualizar-destino":
			update(request, response);
			break;

		case "/deletar-destino":
			delete(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}

	}

	// Create
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		destino.setnome_destino(request.getParameter("nome"));
		destinoDao.save(destino);
		response.sendRedirect("destino");

	}

	// Read
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Destino> lista = destinoDao.getDestino();

		request.setAttribute("destino", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./view/destino/");
		rd.forward(request, response);

	}

	// Update
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		destino.setnome_destino(request.getParameter("nome"));
		destino.setId_destino(Integer.parseInt(request.getParameter("id")));
		destinoDao.update(destino);
		response.sendRedirect("destino");
	}

	// Delete
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		destinoDao.deleteById(id);
		response.sendRedirect("destino");
	}

	// Read by Id
	protected void readById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		destino = destinoDao.getdestinoById(id);

		request.setAttribute("id", destino.getId_destino());
		request.setAttribute("nome", destino.getnome_destino());
		RequestDispatcher rd = request.getRequestDispatcher("./view/destino/atualizar.jsp");
		rd.forward(request, response);

	}

}
