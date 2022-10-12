package veiculos.veiculo;

import java.util.ArrayList;
import java.util.List;

import veiculos.marca.Marca;

public class Veiculo extends Marca {
	private List<Veiculo> list = new ArrayList<>();
	private Double valor;
	private int ID;

	public Double getValor() {
		return valor;
	}

	public int getID() {
		return ID;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Veiculo(List<Veiculo> list, String modelo, String chassi, String marca, Double valor, int ID) {
		super(modelo, chassi, marca);
		this.valor = valor;
		this.ID = ID;
	}

	public void addMarca(String novamarca, Marca marca) {
		marca.setMarca(novamarca);
	}

	public Veiculo() {
		list.add(new Veiculo(list, "Gol", "123", "VW", 10000.00, 10));
	}

	public List<Veiculo> getList() {
		return list;
	}

}
