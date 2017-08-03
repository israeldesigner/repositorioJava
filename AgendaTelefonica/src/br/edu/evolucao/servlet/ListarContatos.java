package br.edu.evolucao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.evolucao.bean.Contato;
import br.edu.evolucao.service.ContatoService;

@WebServlet("/list")
public class ListarContatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");	
		ContatoService service = new ContatoService();		
		List<Contato> contatos = null;
		
		if (nome == null) {
			contatos = service.listar();
		} else {
			contatos = service.procurarPorNome(nome);
		}
		
		request.setAttribute("contatos", contatos);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("pages/contatos.jsp");
				
		dispatcher.forward(request, response);
		
		
	}

}
