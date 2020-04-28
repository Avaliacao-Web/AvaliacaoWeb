package service;

import java.util.ArrayList;

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
	
	public Noticia carregar(int id){
		return dao.select(id);
	}
	
	public ArrayList<Noticia> carregarTudo(){
		return dao.selectAll();
	}
}
