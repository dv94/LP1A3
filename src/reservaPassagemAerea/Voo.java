package reservaPassagemAerea;

public class Voo {
	
	private Aeronave aviao; 
	private int numero;
	private String data;
	private String hora; 
	
	//Comnstrutor
	public Voo(Aeronave aviao, int numero, String data, String hora) {
		this.aviao = new Aeronave(); 
		this.numero = numero;
		this.data = data;
		this.hora = hora; 	
	}

	//GET
	public Aeronave getAviao() {
		return aviao;
	}
	
	//RetornaOAtributoNúmeroDoVôo
	public int getNumero() {
		return numero;
	}
	
	//RetornaOAtributoData
	public String getData() {
		return data;
	}

	//RetornaOAtributoHora
	public String getHora() {
		return hora;
	}

	//DadosDoVôo
	public String toString() {
		return 	"---Voo---"
				+ "Aviao  = " 		+ aviao 
				+ "Numero = "		+ numero 
				+ "Data   = " 		+ data 
				+ "Hora   ="		+ hora ;
	}

}
