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
	
	public void testeSenha(String resposta) {
		sc = new Scanner(System.in);
		if (!resposta.equals("SIM") && !resposta.equals("sim") && !resposta.equals("NAO")
				&& !resposta.equals("nao")) {
			extracted();
		}
		
		if (resposta.equals("SIM") || resposta.equals("sim")) {
			usuario(Rank.CLIENTE);
		} 
		
		else if (resposta.equals("NAO") || resposta.equals("nao")) {
			System.out.print("Digite a senha: ");
			String senha = sc.nextLine();
			if (rank(senha)) {
				usuario(Rank.GERENTE);
			}
			
			else {
				System.out.println("Senha incorreta");
			}
		}
	}
	
	public void argumentosDeGerente(int resposta2) {
		if (resposta2 == 1) {
			for (int i = 0; i < getList().size(); i++) {
				System.out.println("Marca: " + getList().get(i).getMarca());
				System.out.println("Modelo: " + getList().get(i).getModelo());
				System.out.println("Chassi: " + getList().get(i).getChassi());
				System.out.println("Valor: " + getList().get(i).getValor());
			}
		}
		if (resposta2 == 2) {
			for (int i = 0; i < getList().size(); i++) {
				System.out.println("Modelo: " + getList().get(i).getModelo() + " Marca: "
						+ getList().get(i).getMarca() + " ID: " + getList().get(i).getID());
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
	//Extracted da excessao de argumentos invalidos
	private void extracted() {
		throw new ProgramException("Voce esta digitando algo invalido");
	}

}
