package modelo;

public class Destino {
	// Atributos
	private int id;
	private String nome;
	//Contrutores
	public Destino() {
	}
	
	public Destino(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	//Getters e Setters

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
	


	public String setDestino(Destino destino) {
		
		return "Destino [id=" + id + ", nome=" + nome + "]";
	}
	
}