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
 * Servlet implementation class DeletarNoticiaController
 */
@WebServlet("/DeletarNoticiaController.do")
public class DeletarNoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		System.out.println("POST DO DELETAR");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("Id Delete: " + id);
		
		Noticia noticia = new Noticia();
		NoticiaService ns = new NoticiaService();
		noticia = ns.carregar(id);
		//ns.excluir(noticia);
		
		PrintWriter out = response.getWriter();
		out.print("Essa é a noticia: " + noticia.toString());
		//ns.excluir(noticia);
		out.print("Noticia Apagada com Sucesso. Noticias: " + ns.carregarTudo());
		
	}
}