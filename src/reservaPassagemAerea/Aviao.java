package reservaPassagemAerea;


public class Aviao extends Aeronave {
	
	public Passageiro[][] lugares;
	public boolean verificaLugarOcupado;
	public String mostraLugaresVazios;
	public String mostraLugaresOcupados;
    int lugaresVazios = 0;
	
	
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
	
	// Mostra os locais vazios
	  public String mostraLugaresVazios(){

	        String lista = "";

	        for (int fileira = 0; fileira < this.lugares.length; fileira++) {

	            lista += "Fileira " + (fileira + 1) + " [";

	            for (int assent = 0; assent < this.lugares[fileira].length; assent++) {
	                if (!this.verificaLugarOcupado(fileira, assent))
	                    lista += "" + (assent + 1) + ", ";
	            }

	            lista+="]\n";
	        }
	        return lista;
	    }
	  //Mostra lugares ocupados
	  public String mostraLugaresOcupados(){

	        String lista = "";

	        for (int fileira = 0; fileira < this.lugares.length; fileira++) {

	            lista += "Fileira " + (fileira + 1) + " [";

	            for (int assent = 0; assent < this.lugares[fileira].length; assent++) {
	                if (this.verificaLugarOcupado(fileira, assent))
	                    lista += "" + (assent + 1) + ", ";
	            }
	            
	            lista+="]\n";
	        }

	        return lista;
	    }
	  

		//GETPassageiros
		//Também verifica se a informação inserida está correta.
		public Passageiro getPassageiro(int fileira, int assentos) {
			if (lugares != null && lugares[fileira][assentos] != null) {
				return lugares[fileira][assentos];
			}else{
				return null;
			}
		}
		
	    public int getNumeroLugaresVazios(){
	        for (int fileira = 0; fileira < this.lugares.length; fileira++) {
	            for (int acento = 0; acento < this.lugares[fileira].length; acento++)
	                if (!this.verificaLugarOcupado(fileira, acento))
	                    lugaresVazios++;
	        }

	        return lugaresVazios;
	    }
		
	  
	//SETPassageiros
	public void setPassageiro(int fileira, int assento, Passageiro p1) {
		this.lugares[fileira][assento] = p1;
	}
	
	public String toString() {
        return "Modelo: " +  modelo 
        		+ 
        		"\nFileiras: " + lugares.length 
        		+ 
        		"\nNumero de assentos: " + lugares[0].length;
    }
	
}
