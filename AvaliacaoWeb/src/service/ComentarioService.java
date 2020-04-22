package service;

import dao.ComentarioDAO;
import model.Comentario;

public class ComentarioService {

	ComentarioDAO dao = new ComentarioDAO();
	
	public int criar(Comentario comentario) {
		dao.insert(comentario);
		return comentario.getId();
	}
	
	public void atualizar(Comentario comentario){
		dao.upDate(comentario);
	}
	
	public void excluir(Comentario comentario){
		dao.delete(comentario);
	}
	
	public Comentario carregar(Comentario noticia){
		return dao.select(noticia);
	}
}
