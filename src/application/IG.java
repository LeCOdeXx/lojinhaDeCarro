package application;

import java.util.Scanner;

import p.enums.Rank;

public class IG {
	
	private Scanner sc;
	
	public void inicioInterface()  {
		do {
			UI ui = new UI();
			sc = new Scanner(System.in);
			
			
			System.out.println("Bem-Vindo a loja ZokiCar");
			System.out.print("Voce e cliente? s/n: ");
			
			String resposta = sc.nextLine();
			ui.testeSenha(resposta); // teste da resposta, para reduzir
			// o tamanho do IG e utilizar mais o UI
			
			if (ui.usuario.getRank() == Rank.GERENTE) {
				System.out.println("Bem-Vindo gerente");
				System.out.println("O que deseja?");
				System.out.println("1- Ver veiculos");
				System.out.println("2- Modificar veiculos");
				int resposta2 = sc.nextInt();
				ui.argumentosDeGerente(resposta2); // teste da resposta, para reduzir
				// o tamanho do IG e utilizar mais o UI
			}

		} while (true);
	}

}
