package application;

import java.util.List;
import java.util.Scanner;

import exception.ProgramException;
import p.enums.Rank;
import p.enums.Usuario;
import veiculos.marca.Marca;
import veiculos.modelo.Modelo;
import veiculos.veiculo.Veiculo;

public class UI extends Veiculo {
	private Marca marca;
	private Modelo modelo;
	private Veiculo veiculo;
	Usuario usuario = new Usuario();
	private Scanner sc;

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public void limparTela() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

////// SETTERS
	public void setMarca(String novaMarca) {
		if (getUsuario() == Rank.GERENTE) {
			marca.setMarca(novaMarca);
		} else {
			System.out.println("Voce nao tem permissao");
		}
	}

	public void setModelo(String novoModelo) {
		this.modelo.setModelo(novoModelo);
	}

	public void setChassi(String novoChassi) {
		this.modelo.setChassi(novoChassi);
	}

	public void setValor(Double novoValor) {
		this.veiculo.setValor(novoValor);
	}

///// GETTERS
	public String getMarca() {
		return this.marca.getMarca();
	}

	public String getModelo() {
		return this.modelo.getModelo();
	}

	public String getChassi() {
		return this.modelo.getChassi();
	}

	public Double getValor() {
		return this.veiculo.getValor();
	}

	public Rank getUsuario() {
		return usuario.getRank();
	}

	public void usuario(Rank rank) {
		usuario.setRank(rank);
	}

	public UI(List<Veiculo> list, String modelo, String chassi, String marca, Double valor, int ID) {
		super(list, modelo, chassi, marca, valor, ID);
	}

	public boolean rank(String senha) {
		final String senhafinal = "jkreiaz123";
		if (senhafinal.equals(senha)) {
			return true;
		}
		return false;
	}

	public UI() {
		super();
	}

	public void testeUsuario() {
		sc = new Scanner(System.in);
		int xa = 1;
		try {
			while (xa == 1) {
				String resposta = sc.nextLine();
				if (!resposta.equals("SIM") && !resposta.equals("sim") && !resposta.equals("NAO")
						&& !resposta.equals("nao")) {
					extracted();
				}

				if (resposta.equals("SIM") || resposta.equals("sim")) {
					usuario(Rank.CLIENTE);
					xa = 2;
				}

				else if (resposta.equals("NAO") || resposta.equals("nao")) {
					System.out.print("Digite a senha: ");
					String senha = sc.nextLine();
					if (rank(senha)) {
						usuario(Rank.GERENTE);
						xa = 2;
					}

					else {
						System.out.println("Senha incorreta");
						System.out.println("DIGITE QUALQUER COISA PARA RETORNAR!!");
						sc.nextLine();
						xa = 2;
					}
				}
			}
		} catch (ProgramException e) {
			System.out.println();
			System.out.println("INTEGRIDADE CORROMPIDA: " + e.getMessage());
			System.out.println("DIGITE QUALQUER COISA PARA RETORNAR!!");
			sc.nextLine();
			System.out.println();
			limparTela();
		}
	}

	
	
	
	
	public void argumentosDeGerente(int resposta2) {
		if (resposta2 == 1) {
			for (int i = 0; i < getList().size(); i++) {
				System.out.println(ANSI_BLUE + "Lista de veiculos" + ANSI_RESET);
				System.out.println("Marca: " + getList().get(i).getMarca());
				System.out.println("Modelo: " + getList().get(i).getModelo());
				System.out.println("Chassi: " + getList().get(i).getChassi());
				System.out.println("Valor: " + getList().get(i).getValor());
				System.out.println();
				System.out.println("Digite qualquer tecla para continuar!");
				sc.nextLine();
			}
		}
		if (resposta2 == 2) {
			for (int i = 0; i < getList().size(); i++) {
				System.out.println("Modelo: " + getList().get(i).getModelo() + " Marca: " + getList().get(i).getMarca()
						+ " ID: " + getList().get(i).getID());
			}
			System.out.println();
			System.out.print("Qual voce deseja modificar?");
			int escolha = sc.nextInt();
			for (int i = 0; i < getList().size(); i++) {

				if (escolha == getList().get(i).getID()) {
					System.out.print("Digite um novo valor: ");
					Double valor = sc.nextDouble();
					getList().get(i).setValor(valor);
					System.out.println("Marca: " + getList().get(i).getMarca());
					System.out.println("Modelo: " + getList().get(i).getModelo());
					System.out.println("Chassi: " + getList().get(i).getChassi());
					System.out.println("Valor: " + getList().get(i).getValor());

				}
			}
		}
	}

	// Extracted da excessao de argumentos invalidos
	private void extracted() {
		throw new ProgramException("Voce esta digitando algo invalido");
	}

}
