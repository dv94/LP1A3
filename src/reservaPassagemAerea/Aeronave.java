package reservaPassagemAerea;

public class Aeronave {
	
	protected String modelo;
	public Aeronave aeronave;
	
	public Aeronave() {
		this.aeronave = new Aeronave(); 
	}
	
	//ConstrutorAeronave
	public Aeronave(String modelo) {
		this.modelo = modelo; 
	}
	
	//SETModelo
	public void setModelo(String modelo) {
		//retornaOModeloAeronave
		this.modelo = modelo;
	}

	//GETModelo
	public String getModelo() {
		//AtribuiNovoModeloAoAtributoModelo 
		return modelo;
	}

	public String toString() {
		return "----Aeronave---- " 
			 + "modelo = " + modelo;
	}

}
