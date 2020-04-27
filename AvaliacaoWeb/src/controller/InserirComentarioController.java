package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;

/**
 * Servlet implementation class InserirComentarioController
 */
@WebServlet("/InserirComentarioController.do")
public class InserirComentarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST DO COMENTARIO");
		String pName = request.getParameter("firstname");
		String pSubject = request.getParameter("subject");
		
		//instanciar o javabean
		Comentario comentario = new Comentario();
		comentario.setId(0);
		comentario.setNome(pName);
		comentario.setTexto(pSubject);
		System.out.println("noticia: " + comentario);
		
		ComentarioService cs = new ComentarioService();
		cs.criar(comentario);
	}

}
