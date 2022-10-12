package veiculos.marca;

import veiculos.modelo.Modelo;

public class Marca extends Modelo {
	private String marca;

	public Marca() {
	}

	public Marca(String modelo, String chassi, String marca) {
		super(modelo, chassi);
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
