package reservaPassagemAerea;

public class Aeronave {
	
protected String modelo;
	
	
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
		return    "Aeronave Cadastrada\n" 
				+ "\n" + modelo;
	}

}
