package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

/**
 * Servlet implementation class ViewNoticiaController
 */
@WebServlet("/ViewNoticiaController.do")
public class ViewNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
				
		Noticia noticia = new Noticia();
		NoticiaService ns = new NoticiaService();
		noticia = ns.carregar(id);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Noticia</title>");
		out.println("Titulo: " + noticia.getTitulo() + "<br>" + "Descrição: " + noticia.getDescricao() +
				"<br>" + "Texto: " + noticia.getTexto());
		out.println("</body></html>");
	}
}