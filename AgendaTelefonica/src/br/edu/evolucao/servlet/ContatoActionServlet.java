package br.edu.evolucao.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.evolucao.bean.Contato;
import br.edu.evolucao.service.ContatoService;

@WebServlet("/contatoAction")
public class ContatoActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String olharId = request.getParameter("olharId");
		String excluirId = request.getParameter("excluirId");
		
		ContatoService service = new ContatoService();
		
		if (olharId != null) { // Olhar
			
			Long id = Long.parseLong(olharId);
			Contato contato = service.procurarPorId(id);
			
			request.setAttribute("contato", contato);
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("pages/cadastro.jsp");
			
			dispatcher.forward(request, response);

		} else { // Excluir
			
			Long id = Long.parseLong(excluirId);
			service.removerPorId(id);
			
			response.sendRedirect("pages/contatos.jsp");
			
		}
		
	}

}
