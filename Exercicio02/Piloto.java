package model;

public class Piloto {
	private String nome;
	private String sobrenome;
	private String sigla;
	private int numero;
	private String pais;
	
	public Piloto() {
		this.nome = "";
		this.sobrenome = "";
		this.sigla = "";
		this.numero = -1;
		this.pais = "";
	}
	
	public Piloto(String nome, String sobrenome, String sigla, int numero, String pais) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sigla = sigla;
		this.numero = numero;
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Piloto [Nome = " + nome + ", Sobrenome = " + sobrenome + ", Sigla = " + sigla + ", Numero = " + numero + ", Pais = " + pais + "]";
	}	
}
