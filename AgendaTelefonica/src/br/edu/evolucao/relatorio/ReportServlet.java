package br.edu.evolucao.relatorio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import br.edu.evolucao.bean.Contato;
import br.edu.evolucao.dao.ContatoDao;

@WebServlet(urlPatterns = { "/report" })
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/pdf");  
		OutputStream out = response.getOutputStream();
		
		try {
			
			ReportService reportService = new ReportService();
			
			String absolutePath = request.getServletContext().getRealPath("");
			String relativePath = absolutePath + "/relatorios/contatos.jasper";
			InputStream jasperInputStream = Files.newInputStream(Paths.get(relativePath));
			
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.listar();
			
			reportService.genarateReport(jasperInputStream, contatos, null, out);
			
		} catch (JRException e) {
			e.printStackTrace();
		} finally {
			response.flushBuffer();
		}		  
		
	}

}
