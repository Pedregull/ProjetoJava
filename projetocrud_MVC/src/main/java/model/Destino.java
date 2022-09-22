package model;

public class Destino {

	private int id_destino;
	private String nome_destino;


//Contrutores
	public Destino() {
	}

	public Destino(int id_destino, String nome_destino) {
		this.id_destino = id_destino;
		this.nome_destino = nome_destino;

	}

//Gets e sets
	public int getId_destino() {
		return id_destino;
	}

	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}

	public String getnome_destino() {
		return nome_destino;
	}

	public void setnome_destino(String nome_destino) {
		this.nome_destino = nome_destino;
	}

}