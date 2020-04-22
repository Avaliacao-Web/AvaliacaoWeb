package service;

import dao.NoticiaDAO;
import model.Noticia;

public class NoticiaService {

	NoticiaDAO dao = new NoticiaDAO();
	
	public int criar(Noticia noticia) {
		dao.insert(noticia);
		return noticia.getId();
	}
	
	public void atualizar(Noticia noticia){
		dao.upDate(noticia);
	}
	
	public void excluir(Noticia noticia){
		dao.delete(noticia);
	}
	
	public Noticia carregar(Noticia noticia){
		return dao.select(noticia);
	}
}
