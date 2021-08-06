package reservaPassagemAerea;

import java.io.*;
import javax.swing.*;

public class Main {
	//Variaveis globais
	static Aviao a;
	static Voo[] v = new Voo[10]; //Array da classe Voo
	static int numeroDeVoos = 0; //número de voos criados (0 à 9)

	//FunçõesDoParametroDoSistema
		public static void parametroDoSistema() {
			int opcaoSistema = 0; 
			
			
			try {
			
				do {
					opcaoSistema = Integer.parseInt(JOptionPane.showInputDialog(
								   "Parâmetros do Sistema\n"
								 + "1 - Cadastrar Aeronave\n"
								 + "2 - Cadastrar Voo\n"
								 + "3 - Voltar\n"
								 + "\nEscolha sua Opção:"));
					
					switch(opcaoSistema) {
					
					case 1:
						
						//ModeloAvião
						String cadastrandoAeronave = JOptionPane.showInputDialog(null, "Digite o modelo da Aeronave:");
						
						//Indica quantas fileiras o avião posssui
						int fileiras = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite quantas Fileiras a Aeronave terá: "));
						
						//Indica quantos assentos o avião posssui
	                    int assentos = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite quantos Assentos a Aeronave terá: "));
						
						//InformaçõesDoAvião
						a = new Aviao(cadastrandoAeronave, fileiras, assentos);
						JOptionPane.showMessageDialog(null, a.toString());
						break;
						
					case 2:
						
						//Verifica se a aeronave já foi cadastrada, caso não há ele barra acontinuação
						if(a == null) {
							JOptionPane.showMessageDialog(null,"Não há aeronave cadastrada");
							break;
						}
						
						//Verifica se o numero de voos cadastrados excedeu o valor de 10 voos
						if(numeroDeVoos == 10) {
							JOptionPane.showMessageDialog(null,"Já atigiu o numero de voos");
							break;
						}
						
						//NumeroDoVoo
						int numeroVoo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do voo a partir do numero 0: "));
						
						//DataDoVoo
						String dataVoo = JOptionPane.showInputDialog(null, "Digite a data do Voo: ");
						
						//HoraDoVoo
						String horaVoo = JOptionPane.showInputDialog(null, "Digite a hora do Voo: ");
						
						//Cadastra os dados na classe Voo da posição numeroDeVoos e armazena.				
						v[numeroDeVoos]= new Voo(a, numeroVoo, dataVoo, horaVoo);				
						
						//Mostra as informações armazenadas de cadastrar voo
						String message =  "*Vôo Cadastrado*\n"
				                + "\nNúmero   : " + v[numeroDeVoos].getNumero() 
				                + "\nData     : " + v[numeroDeVoos].getData() 
				                + "\nHora     : " + v[numeroDeVoos].getHora()
				                + "\nAeronave : " + v[numeroDeVoos].getAeronave();
						JOptionPane.showMessageDialog(null, message);
						
						numeroDeVoos ++; //Atualiza o número de voos existentes
						
						break;
					case 3:
						break;
					default:
						JOptionPane.showMessageDialog(null,"Opção Inválida");
						break;
					}//fechamento:SWITCH
					
				}while(opcaoSistema!=3);
			}
			catch(Exception e) {
				
			}
			
		}//fechamento:ParametroDoSistema
		
		//FunçãoReservaDePassagens
		public static void reservaDePassagens() {
			
			int opcaoReserva = 0; 
			
			try {
				do {
					
					opcaoReserva = Integer.parseInt(JOptionPane.showInputDialog(
								   "Reserva de Passagens\n"
								 + "1 - Fazer Reserva\n"
								 + "2 - Consultar lugares vazios\n"
								 + "3 - Consultar reservas realizadas\n"
								 + "4 - Voltar\n"
								 + "\nEscolha sua Opção:"));
					
					switch(opcaoReserva) {
					case 1:
						//Valida se existe um voo cadastrado caso não haja ele apresenta essa mensagem.
						if(v[0] == null) {
							JOptionPane.showMessageDialog(null, "Cadastre uma aeronave e um voo !!!");
							break;
						}
						
						//Solicita o numero do Voo
						String numeroVoo = JOptionPane.showInputDialog(null, "Digite o Número do Vôo Cadastrado a partir do 0 (0 até 9): ");
						
						//Valida se existe o numero do voo
						Aviao aeronave =  v[Integer.parseInt(numeroVoo)].getAeronave();
						
						if(aeronave.verificarSeExisteLugaresDisponiveis()) {
							//Solicita o nome 
							String nomePassageiro = JOptionPane.showInputDialog(null, "Digite seu nome: ");
							//Solicita o cpf 
							String cpfPassageiro = JOptionPane.showInputDialog(null, "Digite seu CPF: ");
							
							//Armazena e mostra os dados solicitados nome e cpf
							Passageiro p = new Passageiro(nomePassageiro, cpfPassageiro); 
							JOptionPane.showMessageDialog(null, p.toString());
							
							//Realiza a escolha do assento e fileira, valida se o o assento e fileira estão vazio e se estiver armazena
							String fileira = JOptionPane.showInputDialog(null,  aeronave.getFileirasVazias() + " \n Digite a Fileira do assento: ");
							String assento = JOptionPane.showInputDialog(null,  aeronave.getLugaresVazios(Integer.parseInt(fileira)) + " \n Digite o numero do assento: "); //Mostra os assentos da fileira "Integer.parseInt(fileira)"
							if (aeronave.verificaLugarOcupado( Integer.parseInt(fileira), Integer.parseInt(assento))) {
									JOptionPane.showMessageDialog(null, "Assento ocupado, informe outro assento");

							}else{
								//Estando tudo certo na reserva devolve a mensagem
								v[Integer.parseInt(numeroVoo)].getAeronave().setPassageiro(Integer.parseInt(fileira), Integer.parseInt(assento), p);
								
								//Mostra que a reserva foi realizada e mostra a informação de nome, fileira e assento ao usuario.
								JOptionPane.showMessageDialog(null, "Reserva realizada \n nome: " + p.getNome() + "\n Fileira: " + fileira + "\n Assento: " + assento );
							}
						}else{
							//Informa o cliente a mensagem caso não exista mais lugares
							JOptionPane.showMessageDialog(null, "Não existe mais lugares disponiveis!!");
						}
						
						break; 
					case 2:
						
						//Valida se existe um voo cadastrado caso não haja ele apresenta essa mensagem.
						if(v[0] == null) {
							JOptionPane.showMessageDialog(null, "Cadastre uma aeronave e um voo !!!");
							break;
						}
						
						//Solicita a posição do voo cadastrado
						int voo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número do Vôo Cadastrado (0 até 9): "));
						
						
						//Mostra os lugares vazios
						JOptionPane.showMessageDialog(null, "Lugares vazios\n" + v[voo].getAeronave().getModelo() + "\nLugares Vazios\n" + v[voo].getAeronave().mostraLugaresVazios());
						
						break;
						
					case 3:
						
						//Valida se existe um voo cadastrado caso não haja ele apresenta essa mensagem.
						if(v[0] == null) {
							JOptionPane.showMessageDialog(null, "Cadastre uma aeronave e um voo !!!");
							break;
						}
						
						//Solicita a posição do voo cadastrado
						int aviaoVoo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número do Vôo Cadastrado (0 até 9): "));
						//Mostra os lugares reservados
						JOptionPane.showMessageDialog(null, "Reservas Realizadas\n" + v[aviaoVoo].getAeronave().getModelo() + "\nReserva Realizada\n"+ v[aviaoVoo].getAeronave().mostraLugaresOcupados());						
						
						break;
					case 4:
						//voltandoParaOMenuPrincipal
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opção Inválida");
						break;
					}
					
				}while(opcaoReserva != 4);
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Informe um numero inteiro !!!");
			}
		}
		
		public static void sair() {
			JOptionPane.showMessageDialog(null, "Obrigado pela Preferência!!");
		}
		
		
		//ClassePrincipal
		public static void main(String[] args) {
			
		
			int opcao = 0;
			
			try {
				do {
					
					opcao = Integer.parseInt(JOptionPane.showInputDialog(
							"Menu Principal\n"
							+ "		1 - Parâmetro do Sistema\n"
						    + "		2 - Reserva de Passagens\n"
							+ "		3 - Sair\n"
						    + "\nEscolha sua opção: "));
					
						switch(opcao) {
						case 1:
							parametroDoSistema();
							break;
						case 2:
							reservaDePassagens();
							break; 
						case 3:
							sair();
							break;
						default:
							JOptionPane.showMessageDialog(null, "Opção Inválida");
							break;
						}//fechamento:SWITCH
						
				}while(opcao!=3);
			 }catch(Exception e) {
				
			}
		}//fechamento:Main(String[]...)

}//fechamento:MenuPrincipal
