package application;

import java.util.List;

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

}
