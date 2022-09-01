package modelo;

public class Usuario {
	// Atributos
	private int id;
	private String nome;
	private String email;
	private String senha;
	private String destino;
	private String passagem;
	private double valor_passagem;
	
	// Contrutores
	public Usuario(int i, String string, String string2, String string3, Usuario p1) {
		
	}
	
	public Usuario(int id, String nome, String email, String senha, String destino, String passagem, double valor_passagem, double i) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.destino = destino;
		this.passagem = passagem;
		this.valor_passagem = valor_passagem;
	}
	
	// Gets e Sets
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return this.senha;
	}


	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public String getPassagem() {
		return passagem;
	}

	public void setPassagem(String passagem) {
		this.passagem = passagem;
	}
	
	public double getValor_passagem() {
		return valor_passagem;
	}

	public void setValor_passagem(double valor_passagem) {
		this.valor_passagem = valor_passagem;
	}
	
	
	//metodos
	public String mostrar() {
		return "Id: "+ this.id +" Nome: " +this.nome 
				+ " Email: " + this.email 
				+ " Senha: " + this.senha + " Destino: " + this.destino;
}
}