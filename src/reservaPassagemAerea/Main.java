package reservaPassagemAerea;

import java.io.*;
import javax.swing.*;

public class Main {
	

	//FunçõesDoParametroDoSistema
		public static void parametroDoSistema() {
			int opcaoSistema = 0; 
			Aviao a = null;
			Voo[] v = new Voo[10]; //Array da classe Voo
			int numeroDeVoos = 0; //número de voos criados (0 à 9)
			
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
						int fileiras = Integer.parseInt(JOptionPane.showInputDialog(null, "O numero da fileiras"));
						//Indica quantos assentos o avião posssui
	                    int assentos = Integer.parseInt(JOptionPane.showInputDialog(null, "O numero do assentos"));
						
						//InformaçõesDoAvião
						a = new Aviao(cadastrandoAeronave, fileiras, assentos);
						JOptionPane.showMessageDialog(null, a.toString());
					
						break;
					case 2:
						
						//Voo v = new Voo();
						if(a == null) {
							JOptionPane.showMessageDialog(null,"Não há aeronave cadastrada");
							break;
						}
						if(numeroDeVoos == 10) {
							JOptionPane.showMessageDialog(null,"Já atigiu o numero de voos para aeronave");
							break;
						}
						
						//NumeroDoVoo
						int numeroVoo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do voo: "));
						//JOptionPane.showMessageDialog(null,numeroVoo);
						//v.setNumero(numeroVoo);
						
						//DataDoVoo
						String dataVoo = JOptionPane.showInputDialog(null, "Digite a data do Voo: ");
						//JOptionPane.showMessageDialog(null, dataVoo);
						//v.setData(dataVoo);
						
						//HoraDoVoo
						String horaVoo = JOptionPane.showInputDialog(null, "Digite a hora do Voo: ");
						
						//Cadastra os dados na classe Voo da posição numeroDeVoos					
						v[numeroDeVoos]= new Voo(a, numeroVoo, dataVoo, horaVoo);				
						
						
						//JOptionPane.showMessageDialog(null, v[numeroDeVoos].toString());
						
						//VERIFICAR SE O PROFESSOR NÃO QUER QUE O showMessageDialog SEJA ASSIM JÁ QUE 
						//FORAM CRIADOS GETTERS:
					
						String message =  "*Vôo Cadastrado*\n"
				                + "\nNúmero = " + v[numeroDeVoos].getNumero() 
				                + "\nData   = " + v[numeroDeVoos].getData() 
				                + "\nHora   = " + v[numeroDeVoos].getHora()
				                + "\nAeronave =" + v[numeroDeVoos].getAeronave();
						JOptionPane.showMessageDialog(null, message);
						
						
						numeroDeVoos ++; //Atualiza o número de voos existentes
						
						break;
					case 3:
						break;
					default:
						JOptionPane.showMessageDialog(null,"Opção Inválida");
						break;
					}
					
				}while(opcaoSistema!=3);
			}
			catch(Exception e) {
				
			}
			
			
		}
		
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
						String nomePassageiro = JOptionPane.showInputDialog(null, "Digite seu nome: ");
						//JOptionPane.showMessageDialog(null, nomePassageiro);
						
						String cpfPassageiro = JOptionPane.showInputDialog(null, "Digite seu CPF: ");
						//JOptionPane.showMessageDialog(null, cpfPassageiro);
						
						Passageiro p = new Passageiro(nomePassageiro, cpfPassageiro); 
						JOptionPane.showMessageDialog(null, p.toString());
						
						break; 
					case 2:
						JOptionPane.showMessageDialog(null, "Consultando Lugares Vazios");
						//Lugares l = new Lugares(numfileira, numassento);
						//JOptionPane.showMessageDialog(null, l.toString());
						
						break; 
					case 3:
						int numFileira = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do Fileira: "));
						
						int numAssento = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do Assento: "));
						
						JOptionPane.showMessageDialog(null, "Reservas Realizadas");
						
						/*Lugar l = new Lugar(numFileira, numAssento);
						JOptionPane.showMessageDialog(null, l.toString());*/
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
				
			}
		}
		
		public static void sair() {
			JOptionPane.showMessageDialog(null, "Saindo");
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
						}
						
				}while(opcao!=3);
			 }catch(Exception e) {
				
			}
		}

}
