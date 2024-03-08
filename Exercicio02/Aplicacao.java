package app;

import java.util.List;

import dao.DAO;
import dao.PilotoDAO;
import model.Piloto;

public class Aplicacao {
	
	public static void main(String[] args) throws Exception {
		
		PilotoDAO pilotoDAO = new PilotoDAO();
		
		System.out.println("\n\n==== Inserir piloto === ");
		Piloto piloto = new Piloto("Andrea Kimi", "Antonelli", "ANT", 99, "ITA");
		if(pilotoDAO.insert(piloto) == true) {
			System.out.println("Inserção com sucesso -> " + piloto.toString());
		}
		
		System.out.println("\n\n==== Testando autenticação ===");
		System.out.println("Piloto (" + piloto.getNome() + "): " + pilotoDAO.autenticar("Andrea Kimi", "Antonelli"));

		System.out.println("\n\n==== Atualizar nome (numero (" + piloto.getNumero() + ") === ");
		piloto.setNome(DAO.toMD5("Andrea Kimi"));
		pilotoDAO.update(piloto);
		
		System.out.println("\n\n==== Testando autenticação ===");
		System.out.println("Piloto (" + piloto.getNome() + "): " + pilotoDAO.autenticar("Andrea Kimi", "Antonelli"));		
		
		System.out.println("\n\n==== Invadir usando SQL Injection ===");
		System.out.println("Piloto (" + piloto.getNome() + "): " + pilotoDAO.autenticar("Andrea Kimi", "x' OR 'x' LIKE 'x"));

		System.out.println("\n\n==== Mostrar pilotos ordenados por numero === ");
		pilotos = pilotoDAO.getOrderByNumero();
		for (Piloto u: pilotos) {
			System.out.println(u.toString());
		}
		
		System.out.println("\n\n==== Excluir usuário (numero " + piloto.getNumero() + ") === ");
		pilotoDAO.delete(piloto.getNumero());
	}
}