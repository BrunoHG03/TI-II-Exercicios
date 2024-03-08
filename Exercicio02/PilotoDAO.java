package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Piloto;

public class PilotoDAO extends DAO {
	
	public PilotoDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(Piloto piloto) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO piloto (nome, sobrenome, sigla, numero, pais) "
				       + "VALUES ("+piloto.getNome()+ ", '" + piloto.getSobrenome() + "', '"  
				       + piloto.getSigla() + "', '" + piloto.getNumero() + "', '" + piloto.getPais() + "');";
			System.out.println(sql)
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Piloto get(int numero) {
		Piloto piloto = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id=" + numero;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 piloto = new Piloto(rs.getInt("numero"), rs.getString("nome"), rs.getString("sobrenome"), rs.getString("sigla"), rs.getString("pais"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return piloto;
	}
	
	
	public List<Piloto> get() {
		return get("");
	}

	
	public List<Piloto> getOrderByNumero() {
		return get("numero");		
	}
	
	
	public List<Piloto> getOrderByNome() {
		return get("nome");		
	}
	
	
	public List<Piloto> getOrderBySobrenome() {
		return get("sobrenome");		
	}
	
	public List<Piloto> getOrderBySigla() {
		return get("sigla");		
	}
	
	public List<Piloto> getOrderByPais() {
		return get("pais");		
	}
	
	
	private List<Piloto> get(String orderBy) {	
	
		List<Piloto> pilotos = new ArrayList<Piloto>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM piloto" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Piloto u = new Piloto(rs.getInt("numero"), rs.getString("nome"), rs.getString("sobrenome"), rs.getString("sigla"), rs.getString("pais"));
	            pilotos.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return pilotos;
	}
	
	public boolean update(Piloto piloto) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE piloto SET nome = '" + piloto.getNome() + "', sobrenome = '"  
				       + piloto.getSobrenome() + "', sigla = '" + piloto.getSigla() + "', pais = '" + piloto.getPais() +"'"
					   + " WHERE numero = " + piloto.getNumero();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int numero) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM usuario WHERE numero = " + numero;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean autenticar(String nome, String sobrenome) {
		boolean resp = false;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM piloto WHERE nome LIKE '" + nome + "' AND sobrenome LIKE '" + sobrenome + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			resp = rs.next();
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resp;
	}	
}