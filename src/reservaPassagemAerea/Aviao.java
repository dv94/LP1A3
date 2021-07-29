package reservaPassagemAerea;


public class Aviao extends Aeronave {
	
	public Passageiro[][] lugares;
	public boolean verificaLugarOcupado;
	public String mostraLugaresVazios;
	public String mostraLugaresOcupados;
    int lugaresVazios = 0;
   
	
	//Construtor
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

	            lista += "Fileira " + (fileira) + " [";

	            for (int assent = 0; assent < this.lugares[fileira].length; assent++) {
	                if (!this.verificaLugarOcupado(fileira, assent))
	                    lista += "" + (assent) + " ";
	            }

	            lista+="]\n";
	        }
	        return lista;
	    }
	  //Mostra lugares ocupados
	  public String mostraLugaresOcupados(){

	        String lista = "";

	        for (int fileira = 0; fileira < this.lugares.length; fileira++) {

	            lista += "Fileira " + (fileira) + " [";

	            for (int assent = 0; assent < this.lugares[fileira].length; assent++) {
	                if (this.verificaLugarOcupado(fileira, assent))
	                    lista += "" + (assent) + " ";
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
		//Mostra as fileiras vazias
	    public String getFileirasVazias(){
	    	String fileiras = "Fileiras disponíveis";
	        for (int fileira = 0; fileira < this.lugares.length; fileira++) {
	            for (int assent = 0; assent < this.lugares[fileira].length; assent++)
	                if (!this.verificaLugarOcupado(fileira, assent)) {
	                	fileiras += " "+ fileira;
	                    break;
	                    }
	        }
	        return fileiras;
	    }
	    
	    
	  //Mostra as fileiras vazias
	    public String getLugaresVazios(int IndexFileira){
	    	String lugares = "Assentos disponíveis";
	            for (int assent = 0; assent < this.lugares[IndexFileira].length; assent++)
	                if (!this.verificaLugarOcupado(IndexFileira, assent)) {
	                	lugares += " "+ assent;
	                 }
	        return lugares;
	    }
	    
		//Verifica se existem lugares disponiveis
	    public boolean verificarSeExisteLugaresDisponiveis(){
	        for (int fileira = 0; fileira < this.lugares.length; fileira++) {
	            for (int assent = 0; assent < this.lugares[fileira].length; assent++)
	                if (!this.verificaLugarOcupado(fileira, assent)) {
	                	return true;
	                 }
	        }
	        return false;
	    }
		
	  
	//SETPassageiros
	public void setPassageiro(int fileira, int assento, Passageiro p1) {
		this.lugares[fileira][assento] = p1;
	}
	
	public String toString() {
        return " " +  modelo 
        		+ 
        		"\nFileiras: " + lugares.length 
        		+ 
        		"\nNumero de assentos: " + lugares[0].length;
    }
	
}
