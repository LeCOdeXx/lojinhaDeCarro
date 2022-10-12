package veiculos.modelo;

public class Modelo {
	protected String modelo;
	protected String chassi;

	public Modelo(String nome, String chassi) {
		this.modelo = nome;
		this.chassi = chassi;
	}

	public Modelo() {
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String nome) {
		this.modelo = nome;
	}

	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

}
