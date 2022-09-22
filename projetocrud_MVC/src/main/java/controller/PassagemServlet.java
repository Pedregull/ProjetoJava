package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PassagemDAO;
import model.Passagem;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet(urlPatterns = { "/passagem", "/cadastrar-passagem", "/editar-passagem", "/atualizar-passagem",
		"/deletar-passagem" })
public class PassagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PassagemDAO passagemDao = new PassagemDAO();
	Passagem passagem = new Passagem();

	public PassagemServlet() {
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
		case "/passagem":
			read(request, response);
			break;

		case "/cadastrar-passagem":
			create(request, response);
			break;

		case "/editar-passagem":
			readById(request, response);
			break;

		case "/atualizar-passagem":
			update(request, response);
			break;

		case "/deletar-passagem":
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

		passagem.setNome_passagem(request.getParameter("nome"));
		passagem.setPreco_passagem(Double.parseDouble(request.getParameter("preco")));
		passagemDao.save(passagem);
		response.sendRedirect("passagem");

	}

	// Read
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Passagem> lista = passagemDao.getPassagem();

		request.setAttribute("passagem", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./view/passagem/");
		rd.forward(request, response);

	}

	// Update
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		passagem.setNome_passagem(request.getParameter("nome"));
		passagem.setPreco_passagem(Double.parseDouble(request.getParameter("preco")));
		passagem.setId_passagem(Integer.parseInt(request.getParameter("id")));
		passagemDao.update(passagem);
		response.sendRedirect("passagem");
	}

	// Delete
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		passagemDao.deleteById(id);
		response.sendRedirect("passagem");
	}

	// Read by Id
	protected void readById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		passagem = passagemDao.getpassagemById(id);

		request.setAttribute("id", passagem.getId_passagem());
		request.setAttribute("nome", passagem.getNome_passagem());
		request.setAttribute("preco", passagem.getPreco_passagem());

		RequestDispatcher rd = request.getRequestDispatcher("./view/passagem/atualizar.jsp");
		rd.forward(request, response);

	}

}
