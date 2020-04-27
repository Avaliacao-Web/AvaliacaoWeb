package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Noticia;

public class NoticiaDAO {

	private Connection conexao;
	
	public NoticiaDAO () {
		this.conexao = ConnectionFactory.conectar();
	}
	
	public void insert (Noticia noticia) {
		System.out.println("Entrou no insert");
		NoticiaDAO dao = new NoticiaDAO();
		String inserir = "INSERT INTO Noticia (id, nome, senha, email)" + "VALUES(?,?,?,?)";
		//test
		Noticia not = new Noticia(); 
		
		try (PreparedStatement pst = conexao.prepareStatement(inserir)){
			pst.setInt(1, not.getId());
			pst.setString(2, not.getTitulo());
			pst.setString(3, not.getDescricao());
			pst.setString(4, not.getTexto());
			
			not.setId(not.getId());
			not.setTitulo(not.getTitulo());
			not.setDescricao(not.getDescricao());
			not.setTexto(not.getTexto());
			
			pst.execute();
			System.out.println("Insert feito com sucesso");
			
		} catch(SQLException ex){ 
			System.out.println("Houve um erro ao inserir");
			ex.printStackTrace();
		}
	}
	
	public void delete (Noticia noticia) {
			
		String delete = "DELETE FROM Noticia WHERE titulo = ?";
			
		try (PreparedStatement pst = conexao.prepareStatement(delete)){
			pst.setString(1, noticia.getTitulo());
			pst.execute();
			System.out.println("Noticia excluida");
			
		} catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Falha ao excluir a Noticia");
		}
	}
	
	public void upDate (Noticia noticia) {		
		String update = "UPDATE Noticia SET senha = ? WHERE apelido = ?";
				
		try (PreparedStatement pst = conexao.prepareStatement(update)){
			pst.setInt(1, noticia.getId());
			pst.setString(2, noticia.getTitulo());
			pst.setString(3, noticia.getDescricao());
			pst.setString(4, noticia.getTexto());
			pst.execute();
				
			System.out.println("Atualizado com sucesso!");
		} catch(SQLException ex){
			System.out.println("Erro ao atualizar");
			ex.printStackTrace();
		}
	}
	
	public Noticia select (Noticia noticia) {
		Noticia not = null;
		String consulta = "SELECT id, titulo, descricao, texto FROM Noticia WHERE id = ?";
				
		try (PreparedStatement pst = conexao.prepareStatement(consulta)){
			pst.setInt(1, noticia.getId());
			ResultSet resultado = pst.executeQuery();
			
			if(resultado.next()) {
				not = new Noticia();
				
				int idNoticia = resultado.getInt("id");
				String titulo = resultado.getString("titulo");
				String descricao = resultado.getString("descricao");
				String texto = resultado.getString("texto");
				
				not.setId(idNoticia);
				not.setTitulo(titulo);
				not.setDescricao(descricao);
				not.setTexto(texto);
				System.out.println("Essa é a noticia: " + not.toString());
			}
			System.out.println("Consulta feita com sucesso");
			
		} catch(SQLException ex) {	
			ex.printStackTrace();
			System.out.println("Falha na consulta");
		}
		return not;
	}
}
