package reservaPassagemAerea;

import java.util.Arrays;

public class Aviao extends Aeronave {
	
	public Passageiro[][] lugares;
	public boolean verificarLugarOcupado;
	
	
	//Construtor
	public Aviao(String modelo, int fileira, int assento) {
		super(modelo);
		lugares = new Passageiro[fileira][assento];
	}
	
	//Verifica se está disponivel o assento
	public boolean verificarLugarOcupad(int fileira, int assento) {
		if(lugares [fileira][assento] != null) {
			return true;
		} else {
			return false;
		}
	}

	public Passageiro[][] getLugares() {
		return lugares;
	}

	public void setLugares(Passageiro[][] lugares) {
		this.lugares = lugares;
	}


	public String toString() {
		return "Aviao [lugares=" + Arrays.toString(lugares) + "]";
	}
	
	
	

}
