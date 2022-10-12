package application;

import java.util.Scanner;

import p.enums.Rank;
import veiculos.veiculo.Veiculo;

public class IG {

	public void inicioInterface() {
		Veiculo veiculo = new Veiculo();
		UI ui = new UI();
		Scanner sc = new Scanner(System.in);
		System.out.println("Bem-Vindo a loja ZokiCar");
		System.out.print("Voce e cliente? s/n: ");
		char resposta = sc.next().charAt(0);
		if (resposta == 'S' || resposta == 's') {
			ui.usuario(Rank.CLIENTE);
		}
		if (resposta == 'N' || resposta == 'n') {
			System.out.print("Digite a senha: ");
			sc.nextLine();
			String senha = sc.nextLine();
			if (ui.rank(senha)) {
				ui.usuario(Rank.GERENTE);
			} else {
				System.out.println("Senha errada trouxa kkk");
			}
		}
		if (ui.usuario.getRank() == Rank.GERENTE) {
			System.out.println("Bem-Vindo gerente");
			System.out.println("O que deseja?");
			System.out.println("1- Ver veiculos");
			System.out.println("2- Modificar veiculos");
			int resposta2 = sc.nextInt();
			if (resposta2 == 1) {
				for (int i = 0; i < veiculo.getList().size(); i++) {
					System.out.println("Marca: " + ui.getList().get(i).getMarca());
					System.out.println("Modelo: " + ui.getList().get(i).getModelo());
					System.out.println("Chassi: " + ui.getList().get(i).getChassi());
					System.out.println("Valor: " + ui.getList().get(i).getValor());
				}
			}
			if (resposta2 == 2) {
				for (int i = 0; i < ui.getList().size(); i++) {
					System.out.println("Modelo: " + ui.getList().get(i).getModelo() + " Marca: "
							+ ui.getList().get(i).getMarca() + " ID: " + ui.getList().get(i).getID());
				}
				System.out.println();
				System.out.print("Qual voce deseja modificar?");
				int escolha = sc.nextInt();
				for (int i = 0; i < ui.getList().size(); i++) {

					if (escolha == ui.getList().get(i).getID()) {
						System.out.print("Digite um novo valor: ");
						Double valor = sc.nextDouble();
						ui.getList().get(i).setValor(valor);
						System.out.println("Marca: " + ui.getList().get(i).getMarca());
						System.out.println("Modelo: " + ui.getList().get(i).getModelo());
						System.out.println("Chassi: " + ui.getList().get(i).getChassi());
						System.out.println("Valor: " + ui.getList().get(i).getValor());

					}
				}
			}
		}

		sc.close();
	}

}
