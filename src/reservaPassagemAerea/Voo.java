package reservaPassagemAerea;

public class Voo {
	
	private Aviao aeronave; 
	private int numero;
	private String data;
	private String hora; 

	
	//default
	//public Voo() {}
	
	//ConstrutorVôo
	public Voo(Aviao aeronave, int numero, String data, String hora) {
		this.aeronave = aeronave;
		this.numero = numero;
		this.data = data;
		this.hora = hora; 	
	}
	
	//GET
	public int getNumero() {
		return numero;
	}
	
	public String getData() {
		return data;
	}
	
	public String getHora() {
		return hora;
	}

	public Aviao getAeronave() {
		return aeronave;
	}


	//SET
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public void setAeronave(Aviao aeronave) {
		this.aeronave = aeronave;
	}
	


	//DadosDoVôo
	public String toString() {
		return 	  "*Vôo Cadastrado*\n"
				+ "\nNúmero = "	+ numero 
				+ "\nData   = " + data 
				+ "\nHora   = " + hora
				+ "\nAeronave =" + aeronave;
	}

}
