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
 * Servlet implementation class MostrarNoticiasController
 */
@WebServlet("/MostrarNoticiasController.do")
public class MostrarNoticiasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		System.out.println("POST DO LISTAR NOTICIA");
		
		
		Noticia noticia = new Noticia();
		NoticiaService ns = new NoticiaService();
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Noticia</title><body>");
		for(Noticia noticia1 : ns.carregarTudo()) {
			System.out.println("NOTICIA: " + noticia1);
			noticia = noticia1;
			out.print("<br> Titulo: " + noticia.getTitulo() + 
						" Descrição: " + noticia.getDescricao());
						//" Texto: " + noticia.getTexto());
		}
		//out.print("<a href=ViewNoticia.do + noticia.getId() + >+ noticia.getTitulo() + </a>");
		out.print("</body></html>");
	}
}