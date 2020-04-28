package model;

import java.util.List;

public class Noticia {

	private int id;
	private String titulo;
	private String descricao;
	private String texto;
	private List<Comentario> lstComm;

	public Noticia() {}
	
	public Noticia (int id, String titulo, String descricao, String texto, List<Comentario> lstComm) {
		setId(id);
		setTitulo(titulo);
		setDescricao(descricao);
		setTexto(texto);
		setLstComm(lstComm);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public List<Comentario> getLstComm() {
		return lstComm;
	}

	public void setLstComm(List<Comentario> lstComm) {
		this.lstComm = lstComm;
	}
	
	@Override
	public String toString() {
		return "{Id: " + getId() + ", Título: " + getTitulo() + ", Descrição: " + getDescricao() + 
				", Texto: " + getTexto();
	}
}
