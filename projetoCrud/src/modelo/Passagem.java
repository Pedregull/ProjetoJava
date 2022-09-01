package modelo;

public class Passagem {
	// Atributos
	private int id;
	private String nome;
	private double preco;
	private String passagem;

	// Construtores
	public Passagem() {
	}

	public Passagem(int id, String nome, double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	// Getters e Setters

	public Passagem(int id2, String nome2) {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getPassagem() {
	return passagem;
}
	
	public void setPassagem(String passagem) {
		this.passagem = passagem;
	}

	// ToString

	@Override
	public String toString() {
		return "Passagem [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
	}

}