import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws ParseException {

		SistemaAutenticacao sistema = new SistemaAutenticacao();
		sistema.limparConsole();
		int var = 0;
		// int var2 = 0;
		boolean verificador = true;

		Scanner scanner = new Scanner(System.in);
		Formatacao fmt = new Formatacao();

	 	// Registrar usuários
	 	sistema.registrarUsuario("admin", "admin");

	 	// Autenticar usuário
		fmt.linha();
		System.out.print("Digite o nome de usuário: ");
		String nomeUsuario = scanner.nextLine();

	 	System.out.print("Digite a senha: ");
	 	String senhaUsuario = scanner.nextLine();
		fmt.linha();


		if (sistema.autenticarUsuario(nomeUsuario, senhaUsuario)) {
			sistema.limparConsole();
			fmt.linha();
			System.out.println("Login bem-sucedido!");
			fmt.linha();
			scanner.nextLine();

			do { 
				sistema.limparConsole();
				fmt.linha();
				sistema.listarQuadrosDoUsuario();
				fmt.linha();
				System.out.println("[1] - Criar novo quadro");
				System.out.println("[2] - Excluir quadro");
				System.out.println("[3] - Acessar quadro");
				System.out.println("[4] - Encerrar");
				fmt.linha();

				System.out.println("");
				var = scanner.nextInt();
				sistema.limparConsole();
				
				// Consumir a quebra de linha pendente
				scanner.nextLine();
			
				switch (var) {
					case 1:
						fmt.linha();
						System.out.print("Insira o nome do quadro: ");
						String quadroNome = scanner.nextLine();
						fmt.linha();
						sistema.criarQuadro(quadroNome);
						break;
			
					case 2:
						System.out.println("Deseja excluir qual quadro?");
						fmt.linha();
						sistema.listarQuadrosDoUsuario();
						fmt.linha();
			
						System.out.println("");
						int indice = scanner.nextInt();
						sistema.excluirQuadroDoUsuario(indice);
						sistema.listarQuadrosDoUsuario();
						break;

					case 3:

						System.out.println("Deseja acessar qual quadro?");
						fmt.linha();
						sistema.listarQuadrosDoUsuario();
						fmt.linha();

						System.out.println("");
						int num = scanner.nextInt();

						Quadro quadroSelecionado = sistema.getQuadroPorIndiceUsuario(num);
						sistema.setQuadroAtual(quadroSelecionado);
						sistema.limparConsole();

						do {



							fmt.linha();
							quadroSelecionado.listarListasDoQuadroAtual();
	
							fmt.linha();
							System.out.println("[1] - Criar nova lista");
							System.out.println("[2] - Excluir lista");
							System.out.println("[3] - Acessar lista");
							System.out.println("[4] - Voltar");
							fmt.linha();
	
							num = scanner.nextInt();
							scanner.nextLine();
							sistema.limparConsole();
	
							switch (num) {
								case 1:
									fmt.linha();
									System.out.print("insira o nome da lista: ");
									String tituloLista = scanner.nextLine();
									fmt.linha();
									
									quadroSelecionado.criarLista(tituloLista);
									System.out.println("");
									sistema.limparConsole();
		
		
								break;
								
								case 2:

									fmt.linha();
									System.out.println("Deseja excluir qual lista?");
									fmt.linha();
									quadroSelecionado.listarListasDoQuadroAtual();
									fmt.linha();
							
									System.out.println("");
									int indiceListaExcluir = scanner.nextInt();
									quadroSelecionado.removerLista(indiceListaExcluir);
									sistema.limparConsole();


								break;
	
								case 3:

									System.out.println("Deseja acessar qual lista?");
									fmt.linha();
									quadroSelecionado.listarListasDoQuadroAtual();
									fmt.linha();

									System.out.println("");
									int ind = scanner.nextInt();

									Lista listaSelecionada = quadroSelecionado.getListaPorIndice(ind);
									sistema.limparConsole();


									do {
										
										quadroSelecionado.listarListasDoQuadroAtualComCards();
	
										fmt.linha();
										System.out.println("[1] - Criar novo card");
										System.out.println("[2] - Excluir card");
										System.out.println("[3] - Voltar");
										fmt.linha();
	
										num = scanner.nextInt();
										scanner.nextLine();
										sistema.limparConsole();

										switch (num) {

											case 1:

												fmt.linha();
												System.out.print("Insira o nome do card: ");
												String nomeCard = scanner.nextLine();

												System.out.print("Insira a data de entrega (dd/MM/yyyy): ");
												String dataEntregaStr = scanner.nextLine();
												DateTimeFormatter dtfDataBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");
												LocalDate dataEntrega = LocalDate.parse(dataEntregaStr, dtfDataBrasil);

												System.out.print("Insira a hora de entrega (HH:mm:ss): ");
												String horaEntregaStr = scanner.nextLine();
												SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");
												Date horaEntrega = sdfHora.parse(horaEntregaStr);

												LocalDate dataAtual = LocalDate.now();
												DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
												String dataAtualFormatada = dataAtual.format(dtf);
												// Convertendo a string 
												LocalDate dataAtualConvertida = LocalDate.parse(dataAtualFormatada, dtf);


												listaSelecionada.criarCard(nomeCard, dataAtualConvertida, dataEntrega, horaEntrega);
												sistema.limparConsole();


												
												break;
											case 2:

												fmt.linha();
												System.out.println("Deseja excluir qual card?");
												fmt.linha();
												quadroSelecionado.listarListasDoQuadroAtualComCards();
										
												System.out.println("");
												int indiceCardExcluir = scanner.nextInt();
												listaSelecionada.removerCard(indiceCardExcluir);
												sistema.limparConsole();
		

												break;

											case 3:
												verificador = false;
												break;
			
											default:
												break;
										}

									} while (verificador);

									break;
							
								default:
									break;
							}
	
				
							
						} while (num != 4);

					case 4:
						sistema.limparConsole();
						fmt.linha();
						System.out.println("Programa encerrado!");
						fmt.linha();
						break;
					default:
					break;

					}	
	
			} while (var != 4);

			} else { 
				System.out.println("Falha no login. Credenciais inválidas."); 
			}

	 	scanner.close();

        
    }
}