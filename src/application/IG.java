package application;

import java.util.Scanner;

import exception.ProgramException;
import p.enums.Rank;

public class IG {
	
	private Scanner sc;
	
	public void inicioInterface()  {
		do {
			UI ui = new UI();
			sc = new Scanner(System.in);
			
			ui.limparTela();
			System.out.println("Bem-Vindo a loja ZokiCar");
			System.out.print("Voce e cliente? s/n: ");
			
			
					
					ui.testeUsuario(); // teste da resposta, para reduzir
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
