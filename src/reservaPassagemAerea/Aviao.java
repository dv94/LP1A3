package reservaPassagemAerea;

import java.util.Arrays;

public class Aviao extends Aeronave {
	
	public Passageiro[][] lugares;
	public boolean verificaLugarOcupado; 
	
	public Aviao(String modelo, int fileira, int assentos) {
		super(modelo);
		lugares = new Passageiro[fileira][assentos];
	}
	
	//RecebeAsCoordenadasDeUmAssento
	public boolean verificaLugarOcupado(int fileira, int assentos) {
		if(lugares [fileira][assentos] != null) {
			return true;
		}else{
			return false; 
		}
	}

	//GETPassageiros
	public Passageiro getPassageiro(int fileira, int assentos) {
		return lugares[fileira][assentos];
	}

	//SETPassageiros
	public void setPassageiro(int fileira, int assento, Passageiro p1) {
		this.lugares[fileira][assento] = p1;
	}
	
	public String toString() {
		return "Aviao [lugares=" + Arrays.toString(lugares) + ", verificaLugarOcupado=" + verificaLugarOcupado + "]";
	}
}
