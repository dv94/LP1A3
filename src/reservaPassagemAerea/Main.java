package reservaPassagemAerea;

import java.io.*;
import javax.swing.*;

public class Main {
	

	//FunçõesDoParametroDoSistema
		public static void parametroDoSistema() {
			int opcaoSistema = 0; 
			
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
					int fileiras = Integer.parseInt(JOptionPane.showInputDialog(null, "O numero de fileiras"));
					//Indica quantos assentos o avião posssui
                    int assentos = Integer.parseInt(JOptionPane.showInputDialog(null, "O numero de assentos"));
					//MostrandoOValorInseridoNaTela
					//JOptionPane.showMessageDialog(null, cadastrandoAeronave);
					
					//InformaçõesDoAvião
					Aviao a = new Aviao(cadastrandoAeronave, fileiras, assentos);
					JOptionPane.showMessageDialog(null, a.toString());
				
					break;
				case 2:
					
					Voo v = new Voo();
					
					
					//NumeroDoVoo
					int numeroVoo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do voo: "));
					//JOptionPane.showMessageDialog(null,numeroVoo);
					v.setNumero(numeroVoo);
					
					//DataDoVoo
					String dataVoo = JOptionPane.showInputDialog(null, "Digite a data do Voo: ");
					//JOptionPane.showMessageDialog(null, dataVoo);
					v.setData(dataVoo);
					
					//HoraDoVoo
					String horaVoo = JOptionPane.showInputDialog(null, "Digite a hora do Voo: ");
					//JOptionPane.showMessageDialog(null, horaVoo);
					v.setHora(horaVoo);
					
					String NomedaAeronaveVoo = JOptionPane.showInputDialog(null, "Digite o Nome da Aeronave: ");
					v.setAviao(cadastrandoAeronave);
					
					/*Aeronave  aeronaveVoo = new Aeronave(NomedaAeronaveVoo);
					JOptionPane.showInputDialog(null, "Digite a hora do Voo: ");*/
					
					
					JOptionPane.showMessageDialog(null, v.toString());
					
					break;
				case 3:
					break;
				default:
					JOptionPane.showMessageDialog(null,"Opção Inválida");
					break;
				}
				
			}while(opcaoSistema!=3);
		}
		
		//FunçãoReservaDePassagens
		public static void reservaDePassagens() {
			int opcaoReserva = 0; 
			
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
		
		public static void sair() {
			JOptionPane.showMessageDialog(null, "Saindo");
		}
		
		
		//ClassePrincipal
		public static void main(String[] args) {
			
			int opcao = 0;
			
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
		}

}
