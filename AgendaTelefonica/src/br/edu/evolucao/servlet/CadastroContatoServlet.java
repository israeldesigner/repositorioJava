package br.edu.evolucao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.evolucao.bean.Contato;
import br.edu.evolucao.service.ContatoService;

@WebServlet("/add")
public class CadastroContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idString = request.getParameter("contatoId");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");;
		String telefone = request.getParameter("telefone");;
		
		Long id = null;
		if (idString != null) {
			id = Long.parseLong(idString);
		}
		
		Contato contato = new Contato(nome, email, telefone);
		contato.setId(id);
		
		ContatoService service = new ContatoService();
		if (id == null) {
			service.cadastrar(contato);
		} else {
			service.atualizar(contato);
		}
		
		response.sendRedirect("pages/cadastro.jsp");
		
	}

}
