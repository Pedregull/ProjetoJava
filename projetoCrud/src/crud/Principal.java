package crud;

import modelo.Usuario;

public class Principal {

	public static void main(String[] args) {

		Usuario p1 = new Usuario(1, "Pedro", "pedro@gmail.com", "Lpm2441", "Japão", "Tokyo", 1,550);
		Usuario p2 = new Usuario(2, "Murilo", "murilo@gmail", "$@S234d", "Rússia", "Moscou", 3,250);
		Usuario p3 = new Usuario(3, "Nathália", "nath@gmail.com", "204863", "Noruega", "Oslo", 5,450 );
		Usuario p4 = new Usuario(4, "Camila", "cami@gmail.com", "1313ddfg", "Islândia", "Reiquiavique", 5,532);
		Usuario p5 = new Usuario(5, "Gabriel", "gabri@hotmail.com", "4312312**", "China", "Pequim", 4,659);
		Usuario p6 = new Usuario(6, "Gabriela", "gabs@outlook.com", "@@gugu22!", "Coreia do Norte", "Pyongyang", 2,600);
		
		
		System.out.println(" === Id: " + p1.getId() + " === Nome: " + p1.getNome() + " === Email: " + p1.getEmail() + " === Senha: " + p1.getSenha() + " === Destino: " + p1.getDestino() +
				" === Passagem para: " + p1.getPassagem() + " === Valor da Passagem: " + p1.getValor_passagem());
		
		System.out.println(" === Id: " + p2.getId() + " === Nome: " + p2.getNome() + " === Email: " + p2.getEmail() + " === Senha: " + p2.getSenha() + " === Destino: " + p2.getDestino() +
				" === Passagem para: " + p2.getPassagem() + " === Valor da Passagem: " + p2.getValor_passagem());
		
		System.out.println(" === Id: " + p3.getId() + " === Nome: " + p3.getNome() + " === Email: " + p3.getEmail() + " === Senha: " + p3.getSenha() + " === Destino: " + p3.getDestino() +
				" === Passagem para: " + p3.getPassagem() + " === Valor da Passagem: " + p3.getValor_passagem());
		
		System.out.println(" === Id: " + p4.getId() + " === Nome: " + p4.getNome() + " === Email: " + p4.getEmail() + " === Senha: " + p4.getSenha() + " === Destino: " + p4.getDestino() +
				" === Passagem para: " + p4.getPassagem() + " === Valor da Passagem: " + p4.getValor_passagem());
		
		System.out.println(" === Id: " + p5.getId() + " === Nome: " + p5.getNome() + " === Email: " + p5.getEmail() + " === Senha: " + p5.getSenha() + " === Destino: " + p5.getDestino() +
				" === Passagem para: " + p5.getPassagem() + " === Valor da Passagem: " + p5.getValor_passagem());
		
		System.out.println(" === Id: " + p6.getId() + " === Nome: " + p6.getNome() + " === Email: " + p6.getEmail() + " === Senha: " + p6.getSenha() + " === Destino: " + p6.getDestino() +
				" === Passagem para: " + p6.getPassagem() + " === Valor da Passagem: " + p6.getValor_passagem());
	}

}
