package br.com.recode.model;

public class Passagem {

	private int id_passagem;
	private String nome_passagem;
	private double preco_passagem;

//Contrutores
	public Passagem() {
	}

	public Passagem(String nome_passagem, double preco_passagem) {
		this.nome_passagem = nome_passagem;
		this.preco_passagem = preco_passagem;
	}

	public int getId_passagem() {
		return id_passagem;
	}

	public void setId_passagem(int id_passagem) {
		this.id_passagem = id_passagem;
	}

	public String getNome_passagem() {
		return nome_passagem;
	}

	public void setNome_passagem(String nome_passagem) {
		this.nome_passagem = nome_passagem;
	}

	public double getPreco_passagem() {
		return preco_passagem;
	}

	public void setPreco_passagem(double preco_passagem) {
		this.preco_passagem = preco_passagem;
	}

	
	
}	