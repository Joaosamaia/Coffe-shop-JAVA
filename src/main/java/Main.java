import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.Fornecedor;
import classes.FornecedorDAOImpl;
import classes.Funcionario;
import classes.FuncionarioDAOImpl;
import classes.Pedido;
import classes.PedidoDAOImpl;
import classes.Funcionario;
import classes.Produto;
import classes.ProdutoDAOImpl;
import classes.Bebida;
import classes.BebidaDAOImpl;
import classes.Cliente;
import classes.ClienteDAO;
import classes.ClienteDAOImpl;
import classes.Comida;
import classes.ComidaDAO;
import classes.ComidaDAOImpl;
import classes.DAOException;
import classes.Endereco;
import classes.EnderecoDAOImpl;
import classes.Estoque;
import classes.EstoqueDAOImpl;

public class Main {
	public static void main(String[] args) throws DAOException {
		
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
		EntityManager entity = entityFactory.createEntityManager();
		
		ClienteDAOImpl clienteDAO = new ClienteDAOImpl(entity);
		FuncionarioDAOImpl funcionarioDAO = new FuncionarioDAOImpl(entity);
		EnderecoDAOImpl enderecoDAO = new EnderecoDAOImpl(entity);
		FornecedorDAOImpl fornecedorDAO = new FornecedorDAOImpl(entity);
		EstoqueDAOImpl estoqueDAO = new EstoqueDAOImpl(entity);
		PedidoDAOImpl pedidoDAO = new PedidoDAOImpl(entity);
		ComidaDAOImpl comidaDAO = new ComidaDAOImpl(entity);
		BebidaDAOImpl bebidaDAO = new BebidaDAOImpl(entity);
		ProdutoDAOImpl produtoDAO = new ProdutoDAOImpl(entity);


		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.println("\nEscolha uma aba do sistema:");
				System.out.println("1. Aba do Cliente.");
				System.out.println("2. Aba do Funcionario");
				System.out.println("3. Aba do Fornecedor");
				System.out.println("4. Aba do Estoque");
				System.out.println("5. Aba do Pedido");
				System.out.println("6. Aba Bebida");
				System.out.println("7. Aba Comida");
				System.out.println("0. Sair do programa.");

				int choice = scanner.nextInt();
				switch (choice) {
					case 1:
					System.out.println("\nEscolha uma opcao da aba Cliente: ");
					System.out.println("1. Adicionar Cliente");
					System.out.println("2. Obter Cliente por Id");
					System.out.println("3. Obter todos os Cliente");
					System.out.println("4. Atualizar Cliente");
					System.out.println("5. Excluir Cliente");
					System.out.println("6. Visualizar detalhes do Cliente");
					System.out.println("7. Realizar Pedido");
					System.out.println("8. Ver historico de Pedidos");
					System.out.println("9. Voltar.");
					System.out.print("Insira sua escolha: ");

					int clienteChoice = scanner.nextInt();

					switch (clienteChoice) {
						case 1:
							// Add 
							System.out.print("\n===Cadastre os dados do cliente: ");
							System.out.print("Insira o ID do cliente: ");
							String ClienteID = scanner.next();
							System.out.print("Insira o nome do cliente: ");
							String ClienteNome = scanner.next();
							System.out.print("Insira o telefone do cliente: ");
							String ClienteTEL = scanner.next();
							System.out.print("Insira o email do cliente: ");
							String ClienteEmail = scanner.next();

							System.out.print("\n===Cadastre os dados do endereco cliente: ");
							System.out.print("Digite o CEP do endereco: ");
							String enderecoCEP = scanner.next();
							System.out.print("Digite a rua do endereco: ");
							String enderecoRua = scanner.next();
							System.out.print("Digite o bairro do endereco: ");
							String enderecoBairro = scanner.next();
							System.out.print("Digite a cidade do endereco: ");
							String enderecoCidade = scanner.next();
							System.out.print("Digite o estado do endereco: ");
							String enderecoEstado = scanner.next();
							System.out.print("Digite o pais do endereco: ");
							String enderecoPais = scanner.next();

							Endereco newEndereco = new Endereco(enderecoCEP, enderecoRua, enderecoBairro, enderecoCidade, enderecoEstado, enderecoPais);
							enderecoDAO.addEndereco(newEndereco);

							Cliente newCliente = new Cliente(ClienteID, ClienteNome, ClienteTEL, ClienteEmail, newEndereco);
							clienteDAO.addCliente(newCliente);

							System.out.println("\nCliente cadastrado com sucesso.\n");
							break;
					
						case 2:
							// Get Cliente by ID
							System.out.print("\nInsira o ID do Cliente: ");
							String searchClienteID = scanner.next();
							Cliente foundCliente = clienteDAO.getClienteById(searchClienteID);
							if (foundCliente != null) {
								System.out.println("Cliente encontrado: " + foundCliente.toString());
							} else {
								System.out.println("Cliente nao encontrado.\n");
							}
							break;
					
						case 3:
							// Get todos Clientes
							List<Cliente> allClientes = clienteDAO.getAllClientes();
							System.out.println("\nTodos os Clientes:");
							for (Cliente cliente : allClientes) {
								System.out.println(cliente.toString());
							}
							break;
					
						case 4:
							// Update Cliente
							System.out.print("\nInsira o ID do Cliente a ser atualizado: ");
							String updateClienteID = scanner.next();
							Cliente updateCliente = clienteDAO.getClienteById(updateClienteID);
							Endereco updateEndereco = clienteDAO.getEndereco();
							if (updateCliente != null) {
								System.out.print("Insira o novo nome: ");
								String newNome = scanner.next();
								System.out.print("Insira o novo telefone: ");
								String newTEL = scanner.next();
								System.out.print("Insira o novo email: ");
								String newEmail = scanner.next();
								while (true) {
								System.out.println("\nDeseja atualizar o endereco deste cliente? (s/n)");
								String atualEnd =  scanner.next();								
									switch (atualEnd) {
										case "s":
										if (updateCliente != null) {
											System.out.print("\n===Atualize os dados do endereco cliente: ");
											System.out.print("Digite o novo CEP do endereco: ");
											String newEnderecoCEP = scanner.next();
											System.out.print("Digite a nova rua do endereco: ");
											String newEnderecoRua = scanner.next();
											System.out.print("Digite o novo bairro do endereco: ");
											String newEnderecoBairro = scanner.next();
											System.out.print("Digite a nova cidade do endereco: ");
											String newEnderecoCidade = scanner.next();
											System.out.print("Digite o novo estado do endereco: ");
											String newEnderecoEstado = scanner.next();
											System.out.print("Digite o novo pais do endereco: ");
											String newEnderecoPais = scanner.next();

											updateEndereco.setCEP(newEnderecoCEP);
											updateEndereco.setRua(newEnderecoRua);
											updateEndereco.setBairro(newEnderecoBairro);
											updateEndereco.setCidade(newEnderecoCidade);
											updateEndereco.setEstado(newEnderecoEstado);
											updateEndereco.setPais(newEnderecoPais);
											
										}
											break;
										case "n":
											break;
										default:
											System.out.println("\nOpcao invalida, por favor escolha uma opcao valida.");
									}
									if (updateEndereco != null) {
										enderecoDAO.updateEndereco(updateEndereco);
										System.out.println("Endereco atualizado com sucesso.");
										break; // Exit the loop if a valid produto was created and added
									}
								}

								updateCliente.setNome(newNome);
								updateCliente.setTelefone(newTEL);
								updateCliente.setEmail(newEmail);
								clienteDAO.updateCliente(updateCliente);
								System.out.println("\nCliente atualizado com sucesso.");
							} else {
								System.out.println("\nCliente nao encontrado.");
							}
							break;
						case 5:
							// Delete Cliente
							System.out.print("\nInsira o ID do Cliente a ser excluido: ");
							String deleteClienteID = scanner.next();
							Cliente deleteCliente = clienteDAO.getClienteById(deleteClienteID);
							if (deleteCliente != null) {
								clienteDAO.deleteCliente(deleteCliente);
								System.out.println("\nCliente excluido com sucesso.");
							} else {
								System.out.println("\nCliente nao encontrado.");
							}
							break;					
						case 6:
							// View Cliente Details
							System.out.print("\nInsira o ID do Cliente para vizualizar os detalhes: ");
							String viewClienteID = scanner.next();
							String ClienteDetails = clienteDAO.viewClienteDetails(viewClienteID);
							System.out.println(ClienteDetails != null ? ClienteDetails : "Cliente nao encontrado.");
							break;					
						case 7:
							// Place Order
							System.out.print("\nInsira o ID do Cliente para fazer um Pedido: ");
							String placeOrderClienteID = scanner.next();
						
							// Fetch Produto information and create a list of Produto objects
							List<Produto> produtos = new ArrayList<>();
						
							// Assuming you have a loop to add multiple produtos to the order
							while (true) {
								System.out.print("\nInsira o ID do Produto no Pedido (ou digite: 'pronto' para terminar): ");
								String produtoIDInput = scanner.next();
						
								if (produtoIDInput.equalsIgnoreCase("pronto")) {
									break;
								}
						
								// Fetch Produto details using the entered Produto ID from ProdutoDAOImpl
								try {
									Produto produto = produtoDAO.getProdutoById(produtoIDInput);
						
									if (produto != null) {
										produtos.add(produto);
										System.out.println("\nProduto adicionado ao Pedido: " + produto);
									} else {
										System.out.println("\nProduto nao encontrado, pelo id: " + produtoIDInput);
									}
								} catch (DAOException e) {
									System.out.println("Erro ao buscar detalhes do Produto: " + e.getMessage());
								}
							}
						
							// Place the Pedido using the gathered information
							try {
								clienteDAO.placeOrder(placeOrderClienteID, produtos);
								System.out.println("\nPedido efetuado com sucesso.");
							} catch (DAOException e) {
								System.out.println("Erro ao tentar efetuar o pedido: " + e.getMessage());
							}
							break;						
						case 8:
							// View Pedido History
							System.out.print("\nInsira o ID do Cliente para ver o historico de Pedidos: ");
							String orderHistoryClienteID = scanner.next();
							String orderHistory = clienteDAO.viewOrderHistory(orderHistoryClienteID);
							System.out.println("Historico de Pedidos:\n" + (orderHistory != null ? orderHistory : "Nenhum pedido encontrado."));
							break;
					
						case 9:
							// Exit
							System.out.println("Voltando.");
							break;
					
						default:
							System.out.println("Opcao invalida, por favor escolha uma opcao valida.");
						}
						break;
					case 2:
					System.out.println("Escolha uma opcao da aba Funcionario:");
					System.out.println("1. Adicionar Funcionario");
					System.out.println("2. Obter Funcionario por Id");
					System.out.println("3. Obter todos Funcionarios");
					System.out.println("4. Atualizar Funcionario");
					System.out.println("5. Excluir Funcionario");
					System.out.println("6. Visualizar detalhes do funcionario");
					System.out.println("7. Promover a novo cargo");
					System.out.println("8. Voltar.");
					System.out.print("Insira sua escolha: ");
		
					int funcionarioChoice = scanner.nextInt();
					scanner.next();
		
					switch (funcionarioChoice) {
						case 1:
							System.out.print("===Cadastre os dados do funcionario: \n");
							System.out.print("Insira o ID do funcionario: ");
							String funcionarioID = scanner.next();
							System.out.print("Insira o nome do funcionario: ");
							String funcionarioNome = scanner.next();
							System.out.print("Insira o cpf do funcionario: ");
							String funcionarioCpf = scanner.next();
							System.out.print("Insira o cargo do funcionario: ");
							String funcionarioCargo = scanner.next();
							System.out.print("Insira o telefone do funcionario: ");
							String funcionarioTEL = scanner.next();
							System.out.print("Insira o email do funcionario: ");
							String funcionarioEmail = scanner.next();

							System.out.print("===Cadastre os dados do endereco funcionario: \n");
							System.out.print("Digite o CEP do endereco: ");
							String enderecoCEP = scanner.next();
							System.out.print("Digite a rua do endereco: ");
							String enderecoRua = scanner.next();
							System.out.print("Digite o bairro do endereco: ");
							String enderecoBairro = scanner.next();
							System.out.print("Digite a cidade do endereco: ");
							String enderecoCidade = scanner.next();
							System.out.print("Digite o estado do endereco: ");
							String enderecoEstado = scanner.next();
							System.out.print("Digite o pais do endereco: ");
							String enderecoPais = scanner.next();

							Endereco newEndereco = new Endereco(enderecoCEP, enderecoRua, enderecoBairro, enderecoCidade, enderecoEstado, enderecoPais);
							enderecoDAO.addEndereco(newEndereco);

							Funcionario newFuncionario = new Funcionario(funcionarioID, funcionarioCpf, funcionarioNome, funcionarioTEL, funcionarioEmail, funcionarioCargo, newEndereco);
							funcionarioDAO.addFuncionario(newFuncionario);
							System.out.println("funcionario adicionado com sucesso.");
							break;
						case 2:
							System.out.print("Insira o ID do funcionario: ");
							String searchID = scanner.next();
							Funcionario foundFuncionario = funcionarioDAO.getFuncionarioById(searchID);
							if (foundFuncionario != null) {
								System.out.println("funcionario encontrado: " + foundFuncionario.toString());
							} else {
								System.out.println("funcionario nao encontrado.");
							}
							break;
						case 3:
							List<Funcionario> allFuncionarios = funcionarioDAO.getAllFuncionarios();
							System.out.println("Todos os funcionarios:");
							for (Funcionario emp : allFuncionarios) {
								System.out.println(emp.toString());
							}
							break;
						case 4:
							System.out.print("Insira o ID do funcionario a ser atualizado: ");
							String updateID = scanner.next();
							Funcionario updateFuncionario = funcionarioDAO.getFuncionarioById(updateID);
							Endereco updateEndereco = funcionarioDAO.getEndereco();
							if (updateFuncionario != null) {
								System.out.print("Insira o novo nome: ");
								String newNome = scanner.next();								
								System.out.print("Insira o novo telefone: ");
								String newTEL = scanner.next();								
								System.out.print("Insira o novo email: ");
								String newEmail = scanner.next();		
								System.out.print("Insira o novo cargo: ");
								String newCargo = scanner.next();

								while (true) {
									System.out.println("Deseja atualizar o endereco deste funcionario? (s/n)");
									String atualEnd =  scanner.next();								
									switch (atualEnd) {
										case "s":
										if (updateFuncionario != null) {
											System.out.print("===Atualize os dados do endereco funcionario: ");
											System.out.print("Digite o novo CEP do endereco: ");
											String newEnderecoCEP = scanner.next();
											System.out.print("Digite a nova rua do endereco: ");
											String newEnderecoRua = scanner.next();
											System.out.print("Digite o novo bairro do endereco: ");
											String newEnderecoBairro = scanner.next();
											System.out.print("Digite a nova cidade do endereco: ");
											String newEnderecoCidade = scanner.next();
											System.out.print("Digite o novo estado do endereco: ");
											String newEnderecoEstado = scanner.next();
											System.out.print("Digite o novo pais do endereco: ");
											String newEnderecoPais = scanner.next();

											updateEndereco.setCEP(newEnderecoCEP);
											updateEndereco.setRua(newEnderecoRua);
											updateEndereco.setBairro(newEnderecoBairro);
											updateEndereco.setCidade(newEnderecoCidade);
											updateEndereco.setEstado(newEnderecoEstado);
											updateEndereco.setPais(newEnderecoPais);
										}
											break;
										case "n":
											break; 
										default:
											System.out.println("Opcao invalida, por favor escolha uma opcao valida.");
									}
									if (updateEndereco != null) {
											enderecoDAO.updateEndereco(updateEndereco);
											System.out.println("Endereco atualizado com sucesso.");
											break; // Exit the loop if a valid produto was created and added
										}
								}

								updateFuncionario.setNome(newNome);
								updateFuncionario.setTelefone(newTEL);
								updateFuncionario.setNome(newEmail);
								updateFuncionario.setCargo(newCargo);
								funcionarioDAO.updateFuncionario(updateFuncionario);
								System.out.println("funcionario atualizado com sucesso.");
							} else {
								System.out.println("funcionario nao encontrado.");
							}
							break;
						case 5:
							System.out.print("Insira o ID do funcionario a ser excluido: ");
							String deleteID = scanner.next();
							Funcionario deleteFuncionario = funcionarioDAO.getFuncionarioById(deleteID);
							if (deleteFuncionario != null) {
								funcionarioDAO.deleteFuncionario(deleteFuncionario);
								System.out.println("funcionario excluido com sucesso.");
							} else {
								System.out.println("funcionario nao encontrado.");
							}
							break;
						case 6:
							System.out.print("Insira o ID do funcionario para vizualizar os detalhes: ");
							String viewFuncionarioID = scanner.next();
							String funcionarioDetails = funcionarioDAO.viewFuncionarioDetails(viewFuncionarioID);
							System.out.println(funcionarioDetails != null ? funcionarioDetails : "funcionario nao encontrado.");
							break;
						case 7:
							System.out.print("Insira o ID do funcionario para mudar o cargo: ");
							String atribuirID = scanner.next();
							System.out.print("Insira o novo cargo:");
							String newCargo = scanner.next();
							funcionarioDAO.atribuirCargo(atribuirID, newCargo);
							System.out.println("Role assigned successfully.");
							break;
						case 8:
							System.out.println("Voltando.");
							break;
						default:
							System.out.println("Opcao invalida, por favor escolha uma opcao valida.");
					}
						break;
					case 3:
						System.out.println("Escolha uma opcao da aba Fornecedor: ");
						System.out.println("1. Adicionar Fornecedor");
						System.out.println("2. Obter Fornecedor pelo CNPJ");
						System.out.println("3. Obter todos Fornecedor");
						System.out.println("4. Atualizar Fornecedor");
						System.out.println("5. Excluir Fornecedor");
						System.out.println("6. Voltar.");
						System.out.print("Insira sua escolha: ");
			
						int fornecedorChoice = scanner.nextInt();
						scanner.next();

						switch (fornecedorChoice) {
							case 1:
								// Add Fornecedor
								System.out.print("Insira o CNPJ do fornecedor: ");
								String forncedorCnpj = scanner.next();
								System.out.print("Insira o nome do fornecedor: ");
								String fornecedorNome = scanner.next();
								System.out.print("Insira o telefone do fornecedor: ");
								String fornecedorTEL = scanner.next();
								System.out.print("Insira o email do fornecedor: ");
								String fornecedorEmail = scanner.next();

								System.out.print("===Cadastre os dados do endereco fornecedor: \n");
								System.out.print("Digite o CEP do endereco: ");
								String enderecoCEP = scanner.next();
								System.out.print("Digite a rua do endereco: ");
								String enderecoRua = scanner.next();
								System.out.print("Digite o bairro do endereco: ");
								String enderecoBairro = scanner.next();
								System.out.print("Digite a cidade do endereco: ");
								String enderecoCidade = scanner.next();
								System.out.print("Digite o estado do endereco: ");
								String enderecoEstado = scanner.next();
								System.out.print("Digite o pais do endereco: ");
								String enderecoPais = scanner.next();

								Endereco newEndereco = new Endereco(enderecoCEP, enderecoRua, enderecoBairro, enderecoCidade, enderecoEstado, enderecoPais);
								enderecoDAO.addEndereco(newEndereco);
		
								List<Produto> produtosList = new ArrayList<>();
								System.out.print("===Cadastre a lista dos produtos fornecidos: \n");
								System.out.print("===Cadastre os dados de cada produto fornecido: \n");
								while (true) {
									System.out.print("Digite o ID do produto: ");
									String produtoId = scanner.next();
									System.out.print("Digite o nome do produto: ");
									String produtoNome = scanner.next();
									System.out.print("Digite o preco do produto: ");
									Double produtoPreco = scanner.nextDouble();
									Produto newProduto = null;
									while (true) {
										System.out.print("Digite o tipo do produto (bebida/comida): ");
										String produtoTipo = scanner.next();
										switch (produtoTipo.toLowerCase()) {
											case "bebida":
												if ("bebida".equals(produtoTipo)) {
													Bebida newBebida = new Bebida(produtoId, produtoNome, produtoPreco);
													newProduto = newBebida;
												}
												break;
											case "comida":
												if ("comida".equals(produtoTipo)) {
													Comida newComida = new Comida(produtoId, produtoNome, produtoPreco);
													newProduto = newComida;
												}
												break;
											default:
												System.out.println("Opcao invalida, por favor escolha uma opcao valida.");
										}
										if (newProduto != null) {
											produtoDAO.addProduto(newProduto);
											produtosList.add(newProduto);
											break;
										}
									}
									System.out.print("Deseja adicionar outro produto a lista de produtos fornecidos? (s/n): ");
									String continuar = scanner.next();
									if (!continuar.toLowerCase().equalsIgnoreCase("s")) {
										break;
									}

									// Clear the scanner buffer
									scanner.next();
								}

								Fornecedor newFornecedor = new Fornecedor(forncedorCnpj, fornecedorNome, fornecedorTEL, fornecedorEmail, newEndereco, produtosList);
								fornecedorDAO.addFornecedor(newFornecedor);
								System.out.println("Fornecedor adicionado com sucesso.");
								break;
							case 2:
								// Get Fornecedor by CNPJ
								System.out.print("Insira o CNPJ: ");
								String searchCnpj = scanner.next();
								Fornecedor foundFornecedor = fornecedorDAO.getFornecedorByCnpj(searchCnpj);
								if (foundFornecedor != null) {
									System.out.println("Fornecedor encontrado: " + foundFornecedor.toString());
								} else {
									System.out.println("Fornecedor nao encontrado.");
								}
								break;
						
							case 3:
								// Get todos Fornecedores
								List<Fornecedor> allFornecedores = fornecedorDAO.getAllFornecedores();
								System.out.println("Todos os Fornecedors:");
								for (Fornecedor fornecedor : allFornecedores) {
									System.out.println(fornecedor.toString());
								}
								break;
						
							case 4:
								// Update Fornecedor
								System.out.print("Insira o CNPJ a ser atualizado: ");
								String updateCnpj = scanner.next();
								Fornecedor updateFornecedor = fornecedorDAO.getFornecedorByCnpj(updateCnpj);

								if (updateFornecedor != null) {
									System.out.print("Insira o novo nome: ");
									String newName = scanner.next();
									System.out.print("Insira o novo telefone: ");
									String newTelefone = scanner.next();
									System.out.print("Insira o novo email: ");
									String newEmail = scanner.next();

									//new endereco
									System.out.print("===Atualize os dados do endereco fornecedor: \n");
									System.out.print("Digite o novo CEP do endereco: ");
									String newEnderecoCEP = scanner.next();
									System.out.print("Digite a nova rua do endereco: ");
									String newEnderecoRua = scanner.next();
									System.out.print("Digite o novo bairro do endereco: ");
									String newEnderecoBairro = scanner.next();
									System.out.print("Digite a nova cidade do endereco: ");
									String newEnderecoCidade = scanner.next();
									System.out.print("Digite o novo estado do endereco: ");
									String newEnderecoEstado = scanner.next();
									System.out.print("Digite o novo pais do endereco: ");
									String newEnderecoPais = scanner.next();

									Endereco newEnderecoAtul = new Endereco(newEnderecoCEP, newEnderecoRua, newEnderecoBairro, newEnderecoCidade, newEnderecoEstado, newEnderecoPais);
									enderecoDAO.updateEndereco(newEnderecoAtul);

									// new Produto
									List<Produto> newProdutosList = new ArrayList<>();
									System.out.print("===Atualize a lista dos produtos fornecidos: \n");
									System.out.print("===Atualize os dados de cada produto fornecido: \n");

									while (true) {
										System.out.print("Digite o ID do produto: ");
										String produtoId = scanner.next();
										System.out.print("Digite o nome do produto: ");
										String produtoNome = scanner.next();
										System.out.print("Digite o preco do produto: ");
										Double produtoPreco = scanner.nextDouble();
										scanner.next();
										Produto newProduto = null;
										while (true) {
											System.out.print("Digite o tipo do produto (bebida/comida): ");
											String produtoTipo = scanner.next();
											switch (produtoTipo.toLowerCase()) {
												case "bebida":
													if ("bebida".equals(produtoTipo)) {
														Bebida newBebida = new Bebida(produtoId, produtoNome, produtoPreco);
														newProduto = newBebida;
													}
													break;
												case "comida":
													if ("comida".equals(produtoTipo)) {
														Comida newComida = new Comida(produtoId, produtoNome, produtoPreco);
														newProduto = newComida;
													}
													break;
												default:
													System.out.println("Opcao invalida, por favor escolha uma opcao valida.");
											}
											if (newProduto != null) {
												produtoDAO.addProduto(newProduto);
												newProdutosList.add(newProduto);
												break;
											}
										}
										System.out.print("Deseja adicionar outro produto a lista de produtos fornecidos? (s/n): ");
										String continuar = scanner.next();

										if (!continuar.toLowerCase().equalsIgnoreCase("s")) {
											break;
										}
									}

									// Set the updated values to the Fornecedor entity
									updateFornecedor.setNome(newName);
									updateFornecedor.setTelefone(newTelefone);
									updateFornecedor.setEmail(newEmail);
									updateFornecedor.setEndereco(newEnderecoAtul);
									updateFornecedor.setProduto(newProdutosList);

									// Update the Fornecedor in the database
									fornecedorDAO.updateFornecedor(updateFornecedor);
									System.out.println("Fornecedor atualizado com sucesso.");
								} else {
									System.out.println("Fornecedor nao encontrado.");
								}

								break;						
							case 5:
								// Delete Fornecedor
								System.out.print("Insira o CNPJ a ser excluido: ");
								String deleteCnpj = scanner.next();
								Fornecedor deleteFornecedor = fornecedorDAO.getFornecedorByCnpj(deleteCnpj);
								if (deleteFornecedor != null) {
									fornecedorDAO.deleteFornecedor(deleteFornecedor);
									System.out.println("Fornecedor excluido com sucesso.");
								} else {
									System.out.println("Fornecedor nao encontrado.");
								}
								break;
							case 6:
								// Exit
								System.out.println("Voltando.");
								break;
						
							default:
								System.out.println("Opcao invalida, por favor escolha uma opcao valida.");
						}
						break;
					case 4:
						System.out.println("Escolha uma opcao da aba Estoque: ");
						System.out.println("1. Adicionar Estoque");
						System.out.println("2. Obter Estoque por Id");
						System.out.println("3. Obter todos Estoque");
						System.out.println("4. Atualizar Estoque");
						System.out.println("5. Excluir Estoque");
						System.out.println("6. Re-estoque do Produto");
						System.out.println("7. Ver detalhes do Estoque");
						System.out.println("8. Checar a disponibilidade do Estoque");
						System.out.println("9. Ajustar tamanho do Estoque");
						System.out.println("10. Gerar relatorio de Estoque");
						System.out.println("11. Voltar.");
						System.out.print("Insira sua escolha: ");
			
						int estoqueChoice = scanner.nextInt();
						scanner.next();

						switch (estoqueChoice) {
							case 1:
								// Add Estoque
								System.out.print("===Cadastre os dados do estoque: \n");
								System.out.print("Insira o ID do Estoque: ");
								String estoqueID = scanner.next();

								System.out.print("Insira a quantidade: ");
								int quantidade = scanner.nextInt();

								// Clear the scanner buffer
								scanner.next();
								//add Lista de produtos
								List<Produto> produtosList = new ArrayList<>();
								System.out.print("===Cadastre a lista dos produtos fornecidos: \n");
								System.out.print("===Cadastre os dados de cada produto fornecido: \n");
								while (true) {
									System.out.print("Digite o ID do produto: ");
									String produtoId = scanner.next();
									System.out.print("Digite o nome do produto: ");
									String produtoNome = scanner.next();
									System.out.print("Digite o preco do produto: ");
									Double produtoPreco = scanner.nextDouble();
									Produto newProduto = null;
									while (true) {
										System.out.print("Digite o tipo do produto (bebida/comida): ");
										String produtoTipo = scanner.next();
										switch (produtoTipo.toLowerCase()) {
											case "bebida":
												if ("bebida".equals(produtoTipo)) {
													Bebida newBebida = new Bebida(produtoId, produtoNome, produtoPreco);
													newProduto = newBebida;
												}
												break;
											case "comida":
												if ("comida".equals(produtoTipo)) {
													Comida newComida = new Comida(produtoId, produtoNome, produtoPreco);
													newProduto = newComida;
												}
												break;
											default:
												System.out.println("Opcao invalida, por favor escolha uma opcao valida.");
										}
										if (newProduto != null) {
											produtoDAO.addProduto(newProduto);
											produtosList.add(newProduto);
											break;
										}
									}
									System.out.print("Deseja adicionar outro produto a lista de produtos fornecidos? (s/n): ");
									String continuar = scanner.next();
									if (!continuar.toLowerCase().equalsIgnoreCase("s")) {
										break;
									}

									// Clear the scanner buffer
									scanner.next();
								}

								// List de fornecedores
								List<Fornecedor> fornecedoresList = new ArrayList<>();
								System.out.print("===Cadastre a lista de fornecedores do estoque: \n");
								System.out.print("===Cadastre os dados de cada fornecedor: \n");

								while (true) {
									System.out.print("Insira o CNPJ do fornecedor: ");
									String forncedorCnpj = scanner.next();
									System.out.print("Insira o nome do fornecedor: ");
									String fornecedorNome = scanner.next();
									System.out.print("Insira o telefone do fornecedor: ");
									String fornecedorTEL = scanner.next();
									System.out.print("Insira o email do fornecedor: ");
									String fornecedorEmail = scanner.next();

									System.out.print("===Cadastre os dados do endereco fornecedor: \n");
									System.out.print("Digite o CEP do endereco: ");
									String enderecoCEP = scanner.next();
									System.out.print("Digite a rua do endereco: ");
									String enderecoRua = scanner.next();
									System.out.print("Digite o bairro do endereco: ");
									String enderecoBairro = scanner.next();
									System.out.print("Digite a cidade do endereco: ");
									String enderecoCidade = scanner.next();
									System.out.print("Digite o estado do endereco: ");
									String enderecoEstado = scanner.next();
									System.out.print("Digite o pais do endereco: ");
									String enderecoPais = scanner.next();

									Endereco newEndereco = new Endereco(enderecoCEP, enderecoRua, enderecoBairro, enderecoCidade, enderecoEstado, enderecoPais);
									enderecoDAO.addEndereco(newEndereco);

									Fornecedor newFornecedor = new Fornecedor(forncedorCnpj, fornecedorNome, fornecedorTEL, fornecedorEmail, newEndereco, produtosList);
									fornecedorDAO.addFornecedor(newFornecedor);
									System.out.println("Fornecedor adicionado com sucesso.");

									System.out.print("Deseja adicionar outro fornecedor ao estoque? (s/n): ");
									String continuar = scanner.next();

									if (!continuar.toLowerCase().equalsIgnoreCase("s")) {
										break;
									}
								}
								// List de pedidos
								List<Pedido> pedidosList = new ArrayList<>();

								Estoque newEstoque = new Estoque(estoqueID, quantidade, produtosList, pedidosList, fornecedoresList);
								estoqueDAO.addEstoque(newEstoque);
								System.out.println("Estoque adicionado com sucesso.");
								break;
						
							case 2:
								// Get Estoque by ID
								System.out.print("Insira o ID do Estoque: ");
								String searchestoqueID = scanner.next();
								Estoque foundEstoque = estoqueDAO.getEstoqueById(searchestoqueID);
								if (foundEstoque != null) {
									System.out.println("Estoque encontrado: " + foundEstoque.toString());
								} else {
									System.out.println("Estoque nao encontrado.");
								}
								break;
						
							case 3:
								// Get todos Estoques
								List<Estoque> allEstoques = estoqueDAO.getAllEstoques();
								System.out.println("Todos os Estoques:");
								for (Estoque Estoque : allEstoques) {
									System.out.println(Estoque.toString());
								}
								break;
						
							case 4:
								// Update Estoque
								System.out.print("Insira o ID do estoque a ser atualizado: ");
								String updateEstoqueID = scanner.next();
								Estoque updateEstoque = estoqueDAO.getEstoqueById(updateEstoqueID);

								if (updateEstoque != null) {
									System.out.print("Insira a nova quantidade: ");
									int newQuantidade = scanner.nextInt();
									// Clear the scanner buffer
									scanner.next();

									// Update Lista de produtos
									List<Produto> newProdutosList = new ArrayList<>();
									System.out.print("===Atualize a lista dos produtos fornecidos: \n");
									System.out.print("===Atualize os dados de cada produto fornecido: \n");
									while (true) {
										System.out.print("Digite o ID do produto: ");
										String produtoId = scanner.next();
										System.out.print("Digite o nome do produto: ");
										String produtoNome = scanner.next();
										System.out.print("Digite o preco do produto: ");
										Double produtoPreco = scanner.nextDouble();
										Produto newProduto = null;
										while (true) {
											System.out.print("Digite o tipo do produto (bebida/comida): ");
											String produtoTipo = scanner.next();
											switch (produtoTipo.toLowerCase()) {
												case "bebida":
													if ("bebida".equals(produtoTipo)) {
														Bebida newBebida = new Bebida(produtoId, produtoNome, produtoPreco);
														newProduto = newBebida;
													}
													break;
												case "comida":
													if ("comida".equals(produtoTipo)) {
														Comida newComida = new Comida(produtoId, produtoNome, produtoPreco);
														newProduto = newComida;
													}
													break;
												default:
													System.out.println("Opcao invalida, por favor escolha uma opcao valida.");
											}
											if (newProduto != null) {
												produtoDAO.addProduto(newProduto);
												newProdutosList.add(newProduto);
												break;
											}
										}
										System.out.print("Deseja adicionar outro produto a lista de produtos fornecidos? (s/n): ");
										String continuar = scanner.next();
										if (!continuar.toLowerCase().equalsIgnoreCase("s")) {
											break;
										}

										// Clear the scanner buffer
										scanner.next();
									}

									// Update List de fornecedores
									List<Fornecedor> newFornecedoresList = new ArrayList<>();
									System.out.print("===Atualize a lista de fornecedores do estoque: \n");
									System.out.print("===Atualize os dados de cada fornecedor: \n");
																	while (true) {
									System.out.print("Insira o CNPJ do fornecedor: ");
									String forncedorCnpj = scanner.next();
									System.out.print("Insira o nome do fornecedor: ");
									String fornecedorNome = scanner.next();
									System.out.print("Insira o telefone do fornecedor: ");
									String fornecedorTEL = scanner.next();
									System.out.print("Insira o email do fornecedor: ");
									String fornecedorEmail = scanner.next();

									System.out.print("===Cadastre os dados do endereco fornecedor: \n");
									System.out.print("Digite o CEP do endereco: ");
									String enderecoCEP = scanner.next();
									System.out.print("Digite a rua do endereco: ");
									String enderecoRua = scanner.next();
									System.out.print("Digite o bairro do endereco: ");
									String enderecoBairro = scanner.next();
									System.out.print("Digite a cidade do endereco: ");
									String enderecoCidade = scanner.next();
									System.out.print("Digite o estado do endereco: ");
									String enderecoEstado = scanner.next();
									System.out.print("Digite o pais do endereco: ");
									String enderecoPais = scanner.next();

									Endereco newEndereco = new Endereco(enderecoCEP, enderecoRua, enderecoBairro, enderecoCidade, enderecoEstado, enderecoPais);
									enderecoDAO.addEndereco(newEndereco);

									Fornecedor newFornecedor = new Fornecedor(forncedorCnpj, fornecedorNome, fornecedorTEL, fornecedorEmail, newEndereco, newProdutosList);
									fornecedorDAO.addFornecedor(newFornecedor);
									System.out.println("Fornecedor adicionado com sucesso.");

									System.out.print("Deseja adicionar outro fornecedor ao estoque? (s/n): ");
									String continuar = scanner.next();

									if (!continuar.toLowerCase().equalsIgnoreCase("s")) {
										break;
									}
								}


									// Set the updated values to the Estoque entity
									updateEstoque.setQuantidade(newQuantidade);
									updateEstoque.setProduto(newProdutosList);
									updateEstoque.setFornecedor(newFornecedoresList);

									// Update the Estoque in the database
									estoqueDAO.updateEstoque(updateEstoque);
									System.out.println("Estoque atualizado com sucesso.");
								} else {
									System.out.println("Estoque nao encontrado.");
								}
								break;						
							case 5:
								// Delete Estoque
								System.out.print("Insira o ID do estoque a ser excluido: ");
								String deleteestoqueID = scanner.next();
								Estoque deleteEstoque = estoqueDAO.getEstoqueById(deleteestoqueID);
								if (deleteEstoque != null) {
									estoqueDAO.deleteEstoque(deleteEstoque);
									System.out.println("Estoque excluido com sucesso.");
								} else {
									System.out.println("Estoque nao encontrado.");
								}
								break;
						
							case 6:
								// Re-Estoque Produto
								System.out.print("Insira o ID do Produto que deseja relaizar re-estoque: ");
								String reEstoqueProdutoID = scanner.next();
								System.out.print("Insira o quantidade to add: ");
								int reEstoqueQuantidade = scanner.nextInt();
								estoqueDAO.reEstoqueProduto(reEstoqueProdutoID, reEstoqueQuantidade);
								System.out.println("Produto re-Estoqueed successfully.");
								break;
						
							case 7:
								// View Estoque Details
								System.out.print("Insira o ID do Produto para ver seus dados no Estoque: ");
								String viewEstoqueProdutoID = scanner.next();
								String EstoqueDetails = estoqueDAO.viewEstoqueDetails(viewEstoqueProdutoID);
								System.out.println(EstoqueDetails != null ? EstoqueDetails : "Produto nao encontrado no Estoque.");
								break;						
							case 8:
								// Check Estoque Availability
								System.out.print("Insira o ID do Produto para checar a disponibilidade de estoque: ");
								String checkAvailabilityProdutoID = scanner.next();
								System.out.print("Insira a quantidade que deseja adicionar ao estoque: ");
								int requestedQuantidade = scanner.nextInt();
								boolean isAvailable = estoqueDAO.checkEstoqueAvailability(checkAvailabilityProdutoID, requestedQuantidade);
								System.out.println("No momento o estoque: " + (isAvailable ? "Tem espaco disponivel" : "Nao tem espaco disponivel"));
								break;
							case 9:
								// Adjust Estoque Level
								System.out.print("Insira o ID do Produto que deseja ajustar a quantidade no estoque: ");
								String adjustEstoqueProdutoID = scanner.next();
								System.out.print("Insira a nova quantidade: ");
								int newEstoqueQuantidade = scanner.nextInt();
								estoqueDAO.adjustEstoqueLevel(adjustEstoqueProdutoID, newEstoqueQuantidade);
								System.out.println("Estoque level adjusted successfully.");
								break;						
							case 10:
								// Generate Estoque Report
								System.out.print("Insira o intervalo de datas desejado (no formato: yyyy-MM-dd to yyyy-MM-dd): ");
								String dateRange = scanner.next();
								System.out.print("Insira as categorias (separados por virgula ','): ");
								String categories = scanner.next();
								String report = estoqueDAO.generateEstoqueReport(dateRange, categories);
								System.out.println("Relatorio de Estoque:\n" + (report != null ? report : "Erro ao gerar relatorio."));
								break;
						
							case 11:
								// Exit
								System.out.println("Voltando.");
								break;
						
							default:
								System.out.println("Opcao invalida, por favor escolha uma opcao valida.");
						}						
						break;
					case 5:
						System.out.println("Escolha uma opcao da aba Pedido: ");
						System.out.println("1. Adicionar Pedido");
						System.out.println("2. Obter Pedido por Id");
						System.out.println("3. Obter todos Pedido");
						System.out.println("4. Atualizar Pedido");
						System.out.println("5. Excluir Pedido");
						System.out.println("6. Ver detalhes do Pedido");
						System.out.println("7. Calcular valor total");
						System.out.println("8. Gerar nota fiscal");
						System.out.println("9. Voltar.");
						System.out.print("Insira sua escolha: ");
			
						int pedidoChoice = scanner.nextInt();
						scanner.next();

						switch (pedidoChoice) {
							case 1:
								// Add Pedido
								System.out.print("Insira o ID do Pedido: ");
								String pedidoID = scanner.next();
								System.out.print("Insira o date and time (yyyy-MM-dd HH:mm:ss): ");
								String dateTime = scanner.next();

								//add cliente
								System.out.print("===Cadastre os dados do cliente: ");
								System.out.print("Insira o ID do cliente: ");
								String ClienteID = scanner.next();
								System.out.print("Insira o nome do cliente: ");
								String ClienteNome = scanner.next();
								System.out.print("Insira o telefone do cliente: ");
								String ClienteTEL = scanner.next();
								System.out.print("Insira o email do cliente: ");
								String ClienteEmail = scanner.next();

								System.out.print("===Cadastre os dados do endereco cliente: ");
								System.out.print("Digite o CEP do endereco: ");
								String enderecoCEP = scanner.next();
								System.out.print("Digite a rua do endereco: ");
								String enderecoRua = scanner.next();
								System.out.print("Digite o bairro do endereco: ");
								String enderecoBairro = scanner.next();
								System.out.print("Digite a cidade do endereco: ");
								String enderecoCidade = scanner.next();
								System.out.print("Digite o estado do endereco: ");
								String enderecoEstado = scanner.next();
								System.out.print("Digite o pais do endereco: ");
								String enderecoPais = scanner.next();

								Endereco newEndereco = new Endereco(enderecoCEP, enderecoRua, enderecoBairro, enderecoCidade, enderecoEstado, enderecoPais);
								enderecoDAO.addEndereco(newEndereco);
								Cliente newCliente = new Cliente(ClienteID, ClienteNome, ClienteTEL, ClienteEmail, newEndereco);
								clienteDAO.addCliente(newCliente);
								System.out.println("Cliente cadastrado com sucesso.");

								//add list de produtos
								List<Produto> produtosList = new ArrayList<>();
								System.out.print("===Cadastre a lista dos produtos fornecidos: \n");
								System.out.print("===Cadastre os dados de cada produto fornecido: \n");
								while (true) {
									System.out.print("Digite o ID do produto: ");
									String produtoId = scanner.next();
									System.out.print("Digite o nome do produto: ");
									String produtoNome = scanner.next();
									System.out.print("Digite o preco do produto: ");
									Double produtoPreco = scanner.nextDouble();
									Produto newProduto = null;
									while (true) {
										System.out.print("Digite o tipo do produto (bebida/comida): ");
										String produtoTipo = scanner.next();
										switch (produtoTipo.toLowerCase()) {
											case "bebida":
												if ("bebida".equals(produtoTipo)) {
													Bebida newBebida = new Bebida(produtoId, produtoNome, produtoPreco);
													newProduto = newBebida;
												}
												break;
											case "comida":
												if ("comida".equals(produtoTipo)) {
													Comida newComida = new Comida(produtoId, produtoNome, produtoPreco);
													newProduto = newComida;
												}
												break;
											default:
												System.out.println("Opcao invalida, por favor escolha uma opcao valida.");
										}
										if (newProduto != null) {
											produtoDAO.addProduto(newProduto);
											produtosList.add(newProduto);
											break;
										}
									}
									System.out.print("Deseja adicionar outro produto a lista de produtos fornecidos? (s/n): ");
									String continuar = scanner.next();
									if (!continuar.toLowerCase().equalsIgnoreCase("s")) {
										break;
									}

									// Clear the scanner buffer
									scanner.next();
								}

								Double valor = pedidoDAO.calculateTotal(pedidoID);
								Pedido newPedido = new Pedido(pedidoID, valor, dateTime, produtosList, newCliente);
								pedidoDAO.addPedido(newPedido);
								System.out.println("Pedido adicionado com sucesso.");
								break;

							case 2:
								// Get Pedido by ID
								System.out.print("Insira o ID do Pedido: ");
								String searchpedidoID = scanner.next();
								Pedido foundPedido = pedidoDAO.getPedidoById(searchpedidoID);
								if (foundPedido != null) {
									System.out.println("Pedido encontrado: " + foundPedido.toString());
								} else {
									System.out.println("Pedido nao encontrado.");
								}
								break;

							case 3:
								// Get todos Pedidos
								List<Pedido> allPedidos = pedidoDAO.getAllPedidos();
								System.out.println("Todos os Pedidos:");
								for (Pedido pedido : allPedidos) {
									System.out.println(pedido.toString());
								}
								break;

							case 4:
								// Update Pedido
								System.out.print("Insira o ID do Pedido a ser atualizado: ");
								String updatePedidoID = scanner.next();
								Pedido updatePedido = pedidoDAO.getPedidoById(updatePedidoID);

								if (updatePedido != null) {
									System.out.print("Insira o novo date and time (yyyy-MM-dd HH:mm:ss): ");
									String newDateTime = scanner.next();
									updatePedido.setDataHora(newDateTime);

									// Update Lista de produtos
									List<Produto> newProdutosList = new ArrayList<>();
									System.out.print("===Atualize a lista dos produtos fornecidos: \n");
									System.out.print("===Atualize os dados de cada produto fornecido: \n");
									while (true) {
										System.out.print("Digite o ID do produto: ");
										String produtoId = scanner.next();
										System.out.print("Digite o nome do produto: ");
										String produtoNome = scanner.next();
										System.out.print("Digite o preco do produto: ");
										Double produtoPreco = scanner.nextDouble();
										Produto newProduto = null;
										while (true) {
											System.out.print("Digite o tipo do produto (bebida/comida): ");
											String produtoTipo = scanner.next();
											switch (produtoTipo.toLowerCase()) {
												case "bebida":
													if ("bebida".equals(produtoTipo)) {
														Bebida newBebida = new Bebida(produtoId, produtoNome, produtoPreco);
														newProduto = newBebida;
													}
													break;
												case "comida":
													if ("comida".equals(produtoTipo)) {
														Comida newComida = new Comida(produtoId, produtoNome, produtoPreco);
														newProduto = newComida;
													}
													break;
												default:
													System.out.println("Opcao invalida, por favor escolha uma opcao valida.");
											}
											if (newProduto != null) {
												produtoDAO.addProduto(newProduto);
												newProdutosList.add(newProduto);
												break;
											}
										}
										System.out.print("Deseja adicionar outro produto a lista de produtos fornecidos? (s/n): ");
										String continuar = scanner.next();
										if (!continuar.toLowerCase().equalsIgnoreCase("s")) {
											break;
										}

										// Clear the scanner buffer
										scanner.next();
									}
									// Update Cliente
									System.out.print("===Atualize os dados do cliente: ");
									System.out.print("Insira o ID do cliente: ");
									String newClienteID = scanner.next();
									System.out.print("Insira o novo nome do cliente: ");
									String newClienteNome = scanner.next();
									System.out.print("Insira o novo telefone do cliente: ");
									String newClienteTEL = scanner.next();
									System.out.print("Insira o novo email do cliente: ");
									String newClienteEmail = scanner.next();

									// Update Endereco do cliente
									System.out.print("===Atualize os dados do endereco cliente: ");
									System.out.print("Digite o novo CEP do endereco: ");
									String newEnderecoCEP = scanner.next();
									System.out.print("Digite a nova rua do endereco: ");
									String newEnderecoRua = scanner.next();
									System.out.print("Digite o novo bairro do endereco: ");
									String newEnderecoBairro = scanner.next();
									System.out.print("Digite a nova cidade do endereco: ");
									String newEnderecoCidade = scanner.next();
									System.out.print("Digite o novo estado do endereco: ");
									String newEnderecoEstado = scanner.next();
									System.out.print("Digite o novo pais do endereco: ");
									String newEnderecoPais = scanner.next();

									Endereco newEnderecoAtual = new Endereco(newEnderecoCEP, newEnderecoRua, newEnderecoBairro, newEnderecoCidade, newEnderecoEstado, newEnderecoPais);
									enderecoDAO.updateEndereco(newEnderecoAtual);

									Cliente newClienteAtual = new Cliente(newClienteID, newClienteNome, newClienteTEL, newClienteEmail, newEnderecoAtual);
									clienteDAO.updateCliente(newClienteAtual);

									// Update the Pedido entity
									updatePedido.setProduto(newProdutosList);
									updatePedido.setCliente(newClienteAtual);

									// Update the Pedido in the database
									pedidoDAO.updatePedido(updatePedido);
									System.out.println("Pedido atualizado com sucesso.");
								} else {
									System.out.println("Pedido nao encontrado.");
								}
								break;

							case 5:
								// Delete Pedido
								System.out.print("Insira o ID do Pedido a ser excluido: ");
								String deletepedidoID = scanner.next();
								Pedido deletePedido = pedidoDAO.getPedidoById(deletepedidoID);
								if (deletePedido != null) {
									pedidoDAO.deletePedido(deletePedido);
									System.out.println("Pedido excluido com sucesso.");
								} else {
									System.out.println("Pedido nao encontrado.");
								}
								break;

							case 6:
								// View Pedido Details
								System.out.print("Insira o ID do Pedido para vizualizar os detalhes: ");
								String viewpedidoID = scanner.next();
								Pedido viewedPedido = pedidoDAO.viewOrderDetails(viewpedidoID);
								if (viewedPedido != null) {
									System.out.println("Detalhes do Pedid: " + viewedPedido.toString());
								} else {
									System.out.println("Pedido nao encontrado.");
								}
								break;

							case 7:
								// Calculate Total
								System.out.print("Insira o ID do Pedido para calcular o valor total: ");
								String calculateTotalID = scanner.next();
								Double total = pedidoDAO.calculateTotal(calculateTotalID);
								if (total != null) {
									System.out.println("O valor total do Pedido " + calculateTotalID + "e: $" + total);
								} else {
									System.out.println("Incapaz de calcular o valor total. Pedido nao encontrado.");
								}
								break;

							case 8:
								// Generate notinha
								System.out.print("Insira o ID do Pedido parar gerar a nota fiscal: ");
								String generatenotinhaID = scanner.next();
								String notinha = pedidoDAO.generateNotinha(generatenotinhaID);
								if (notinha != null) {
									System.out.println("nota fiscal:\n" + notinha);
								} else {
									System.out.println("Incapaz de gerar nota fiscal. Pedido nao encontrado.");
								}
								break;

							case 9:
								// Exit
								System.out.println("Voltando.");
								break;

							default:
								System.out.println("Opcao invalida, por favor escolha uma opcao valida.");
						}
						break;
					case 6:
						System.out.println("Escolha uma opcao da aba Bebida: ");
						System.out.println("1. Adicionar Bebida");
						System.out.println("2. Obter Bebida por Id");
						System.out.println("3. Obter todas as Bebidas");
						System.out.println("4. Atualizar Bebida");
						System.out.println("5. Excluir Bebida");
						System.out.println("6. Voltar.");
						System.out.print("Insira sua escolha: ");
			
						int bebidaChoice = scanner.nextInt();
						scanner.next();

						switch (bebidaChoice) {
							case 1:
								// Add Bebida
								System.out.print("Insira o ID da Bebida: ");
								String bebidaID = scanner.next();
								System.out.print("Insira o nome da Bebida: ");
								String bebidaNome = scanner.next();
								System.out.print("Insira o tipo da Bebida: ");
								String bebidaType = scanner.next();
								System.out.print("Digite o preco do produto: ");
								Double bebidaPreco = scanner.nextDouble();
								System.out.print("Insira o tamanho da porcao da Bebida em ml: ");
								Double bebidaPorcao = scanner.nextDouble();
								scanner.next();
								System.out.print("Insira os ingredientes da Bebida: ");
								String bebidaIngr = scanner.next();
								System.out.print("Insira em qual temperatura se serve essa Bebida: ");
								String bebidaTemp = scanner.next();
								System.out.print("Insira uma descrição para essa Bebida: ");
								String bebidaDesc = scanner.next();

								//add o fornecedor
								System.out.print("Insira o CNPJ do fornecedor: ");
								String forncedorCnpj = scanner.next();
								System.out.print("Insira o nome do fornecedor: ");
								String fornecedorNome = scanner.next();
								System.out.print("Insira o telefone do fornecedor: ");
								String fornecedorTEL = scanner.next();
								System.out.print("Insira o email do fornecedor: ");
								String fornecedorEmail = scanner.next();

								System.out.print("===Cadastre os dados do endereco fornecedor: \n");
								System.out.print("Digite o CEP do endereco: ");
								String enderecoCEP = scanner.next();
								System.out.print("Digite a rua do endereco: ");
								String enderecoRua = scanner.next();
								System.out.print("Digite o bairro do endereco: ");
								String enderecoBairro = scanner.next();
								System.out.print("Digite a cidade do endereco: ");
								String enderecoCidade = scanner.next();
								System.out.print("Digite o estado do endereco: ");
								String enderecoEstado = scanner.next();
								System.out.print("Digite o pais do endereco: ");
								String enderecoPais = scanner.next();

								Endereco newEndereco = new Endereco(enderecoCEP, enderecoRua, enderecoBairro, enderecoCidade, enderecoEstado, enderecoPais);
								enderecoDAO.addEndereco(newEndereco);
		
								List<Produto> produtosList = new ArrayList<>();
								System.out.print("===Cadastre a lista dos produtos fornecidos: \n");
								System.out.print("===Cadastre os dados de cada produto fornecido: \n");
								while (true) {
									System.out.print("Digite o ID do produto: ");
									String produtoId = scanner.next();
									System.out.print("Digite o nome do produto: ");
									String produtoNome = scanner.next();
									System.out.print("Digite o preco do produto: ");
									Double produtoPreco = scanner.nextDouble();
									Produto newProduto = null;
									while (true) {
										System.out.print("Digite o tipo do produto (bebida/comida): ");
										String produtoTipo = scanner.next();
										switch (produtoTipo.toLowerCase()) {
											case "bebida":
												if ("bebida".equals(produtoTipo)) {
													Bebida newBebida = new Bebida(produtoId, produtoNome, produtoPreco);
													newProduto = newBebida;
												}
												break;
											case "comida":
												if ("comida".equals(produtoTipo)) {
													Comida newComida = new Comida(produtoId, produtoNome, produtoPreco);
													newProduto = newComida;
												}
												break;
											default:
												System.out.println("Opcao invalida, por favor escolha uma opcao valida.");
										}
										if (newProduto != null) {
											produtoDAO.addProduto(newProduto);
											produtosList.add(newProduto);
											break;
										}
									}
									System.out.print("Deseja adicionar outro produto a lista de produtos fornecidos? (s/n): ");
									String continuar = scanner.next();
									if (!continuar.toLowerCase().equalsIgnoreCase("s")) {
										break;
									}
									// Clear the scanner buffer
									scanner.next();
								}
								Fornecedor newFornecedor = new Fornecedor(forncedorCnpj, fornecedorNome, fornecedorTEL, fornecedorEmail, newEndereco, produtosList);
								fornecedorDAO.addFornecedor(newFornecedor);
								System.out.println("Fornecedor adicionado com sucesso.");

								//add estoque pra bebida
								System.out.print("===Cadastre os dados do estoque: \n");
								System.out.print("Insira o ID do Estoque: ");
								String estoqueID = scanner.next();

								System.out.print("Insira a quantidade: ");
								int quantidade = scanner.nextInt();

								// Clear the scanner buffer
								scanner.next();

								// List de pedidos
								List<Pedido> pedidosList = new ArrayList<>();

								//list de fornecedor
								List<Fornecedor> fornecedoresList = new ArrayList<>();
								fornecedoresList.add(newFornecedor);
								//usamos a lista de produtos ja criada
								Estoque newEstoque = new Estoque(estoqueID, quantidade, produtosList, pedidosList, fornecedoresList);
								estoqueDAO.addEstoque(newEstoque);
								System.out.println("Estoque adicionado com sucesso.");

								Bebida newBebida = new Bebida(bebidaID, bebidaNome, bebidaPreco, bebidaPorcao, newFornecedor, newEstoque, bebidaType, bebidaIngr, bebidaTemp, bebidaDesc);
								bebidaDAO.addBebida(newBebida);
								System.out.println("Produto adicionado com sucesso.");
								break;
						
							case 2:
								// Get Bebida by ID
								System.out.print("Insira o ID do Bebida: ");
								String searchBebidaID = scanner.next();
								Bebida foundBebida = bebidaDAO.getBebidaById(searchBebidaID);
								if (foundBebida != null) {
									System.out.println("Bebida encontrado: " + foundBebida.toString());
								} else {
									System.out.println("Bebida nao encontrado.");
								}
								break;
						
							case 3:
								// Get todas Bebidas
								List<Bebida> allBebidas = bebidaDAO.getAllBebidas();
								System.out.println("Todas as Bebidas:");
								for (Bebida Bebida : allBebidas) {
									System.out.println(Bebida.toString());
								}
								break;
						
							case 4:
								// Update Bebida
								System.out.print("Insira o ID da Bebida a ser atualizada: ");
								String updateprodutoID = scanner.next();
								Bebida updateBebida = bebidaDAO.getBebidaById(updateprodutoID);

								if (updateBebida != null) {
									System.out.print("Insira o novo nome da Bebida: ");
									String newBebidaNome = scanner.next();

									System.out.print("Insira o novo tipo da Bebida: ");
									String newBebidaType = scanner.next();

									System.out.print("Digite o novo preco da Bebida: ");
									Double newBebidaPreco = scanner.nextDouble();

									System.out.print("Insira o novo tamanho da porcao da Bebida em ml: ");
									Double newBebidaPorcao = scanner.nextDouble();
									scanner.next(); // Clear the scanner buffer

									System.out.print("Insira os novos ingredientes da Bebida: ");
									String newBebidaIngr = scanner.next();

									System.out.print("Insira em qual nova temperatura se serve essa Bebida: ");
									String newBebidaTemp = scanner.next();

									System.out.print("Insira uma nova descrição para essa Bebida: ");
									String newBebidaDesc = scanner.next();

									// Update the Bebida attributes
									updateBebida.setNome(newBebidaNome);
									updateBebida.setTipo(newBebidaType);
									updateBebida.setPreco(newBebidaPreco);
									updateBebida.setPorcao(newBebidaPorcao);
									updateBebida.setIngredientes(newBebidaIngr);
									updateBebida.setTemperatura(newBebidaTemp);
									updateBebida.setDescricao(newBebidaDesc);

									// Update the Fornecedor details
									System.out.print("Insira o CNPJ do fornecedor: ");
									String updateFornecedorCnpj = scanner.next();
									Fornecedor updateFornecedor = fornecedorDAO.getFornecedorByCnpj(updateFornecedorCnpj);

									if (updateFornecedor != null) {
										System.out.print("Insira o novo nome do fornecedor: ");
										String newFornecedorNome = scanner.next();

										System.out.print("Insira o novo telefone do fornecedor: ");
										String newFornecedorTel = scanner.next();

										System.out.print("Insira o novo email do fornecedor: ");
										String newFornecedorEmail = scanner.next();

										// Update the Fornecedor attributes
										updateFornecedor.setNome(newFornecedorNome);
										updateFornecedor.setTelefone(newFornecedorTel);
										updateFornecedor.setEmail(newFornecedorEmail);

										// Update the Fornecedor in the database
										fornecedorDAO.updateFornecedor(updateFornecedor);
										System.out.println("Fornecedor atualizado com sucesso.");
									} else {
										System.out.println("Fornecedor nao encontrado.");
									}

									// Update the Bebida in the database
									bebidaDAO.updateBebida(updateBebida);
									System.out.println("Produto atualizado com sucesso.");
								} else {
									System.out.println("Produto nao encontrado.");
								}
								break;
						
							case 5:
								// Delete Bebida
								System.out.print("Insira o ID do Bebida a ser excluido: ");
								String deleteBebidaID = scanner.next();
								Bebida deleteBebida = bebidaDAO.getBebidaById(deleteBebidaID);
								if (deleteBebida != null) {
									bebidaDAO.deleteBebida(deleteBebida);
									System.out.println("Bebida excluido com sucesso.");
								} else {
									System.out.println("Bebida nao encontrado.");
								}
								break;
						
							case 6:
								// Exit
								System.out.println("Voltando.");
								break;
						
							default:
								System.out.println("Opcao invalida, por favor escolha uma opcao valida.");
						}
						break;
					case 7:
						System.out.println("Escolha uma opcao da aba Comida: ");
						System.out.println("1. Adicionar Comida");
						System.out.println("2. Obter Comida por Id");
						System.out.println("3. Obter todos Comidas");
						System.out.println("4. Atualizar Comida");
						System.out.println("5. Excluir Comida");
						System.out.println("6. Voltar.");
						System.out.print("Insira sua escolha: ");
			
						int comidaChoice = scanner.nextInt();
						scanner.next();

						switch (comidaChoice) {
							case 1:
								// Add Comida
								System.out.print("Insira o ID da Comida: ");
								String ComidaID = scanner.next();
								System.out.print("Insira o nome da Comida: ");
								String ComidaNome = scanner.next();
								System.out.print("Insira o tipo da Comida: ");
								String ComidaType = scanner.next();
								System.out.print("Digite o preco do produto: ");
								Double ComidaPreco = scanner.nextDouble();
								System.out.print("Insira o tamanho da porcao da Comida em ml: ");
								Double ComidaPorcao = scanner.nextDouble();
								scanner.next();
								System.out.print("Insira os ingredientes da Comida: ");
								String ComidaIngr = scanner.next();
								System.out.print("Insira uma descrição para essa Comida: ");
								String ComidaDesc = scanner.next();

								//add o fornecedor
								System.out.print("Insira o CNPJ do fornecedor: ");
								String forncedorCnpj = scanner.next();
								System.out.print("Insira o nome do fornecedor: ");
								String fornecedorNome = scanner.next();
								System.out.print("Insira o telefone do fornecedor: ");
								String fornecedorTEL = scanner.next();
								System.out.print("Insira o email do fornecedor: ");
								String fornecedorEmail = scanner.next();

								System.out.print("===Cadastre os dados do endereco fornecedor: \n");
								System.out.print("Digite o CEP do endereco: ");
								String enderecoCEP = scanner.next();
								System.out.print("Digite a rua do endereco: ");
								String enderecoRua = scanner.next();
								System.out.print("Digite o bairro do endereco: ");
								String enderecoBairro = scanner.next();
								System.out.print("Digite a cidade do endereco: ");
								String enderecoCidade = scanner.next();
								System.out.print("Digite o estado do endereco: ");
								String enderecoEstado = scanner.next();
								System.out.print("Digite o pais do endereco: ");
								String enderecoPais = scanner.next();

								Endereco newEndereco = new Endereco(enderecoCEP, enderecoRua, enderecoBairro, enderecoCidade, enderecoEstado, enderecoPais);
								enderecoDAO.addEndereco(newEndereco);

								//add lista produtos pro fornecedor
								List<Produto> produtosList = new ArrayList<>();
								System.out.print("===Cadastre a lista dos produtos fornecidos: \n");
								System.out.print("===Cadastre os dados de cada produto fornecido: \n");
								while (true) {
									System.out.print("Digite o ID do produto: ");
									String produtoId = scanner.next();
									System.out.print("Digite o nome do produto: ");
									String produtoNome = scanner.next();
									System.out.print("Digite o preco do produto: ");
									Double produtoPreco = scanner.nextDouble();
									Produto newProduto = null;
									while (true) {
										System.out.print("Digite o tipo do produto (Bebida/comida): ");
										String produtoTipo = scanner.next();
										switch (produtoTipo.toLowerCase()) {
											case "Bebida":
												if ("Bebida".equals(produtoTipo)) {
													Bebida newBebida = new Bebida(produtoId, produtoNome, produtoPreco);
													newProduto = newBebida;
												}
												break;
											case "comida":
												if ("comida".equals(produtoTipo)) {
													Comida newComida = new Comida(produtoId, produtoNome, produtoPreco);
													newProduto = newComida;
												}
												break;
											default:
												System.out.println("Opcao invalida, por favor escolha uma opcao valida.");
										}
										if (newProduto != null) {
											produtoDAO.addProduto(newProduto);
											produtosList.add(newProduto);
											break;
										}
									}
									System.out.print("Deseja adicionar outro produto a lista de produtos fornecidos? (s/n): ");
									String continuar = scanner.next();
									if (!continuar.toLowerCase().equalsIgnoreCase("s")) {
										break;
									}
									// Clear the scanner buffer
									scanner.next();
								}
								Fornecedor newFornecedor = new Fornecedor(forncedorCnpj, fornecedorNome, fornecedorTEL, fornecedorEmail, newEndereco, produtosList);
								fornecedorDAO.addFornecedor(newFornecedor);
								System.out.println("Fornecedor adicionado com sucesso.");

								//add estoque pra Comida
								System.out.print("===Cadastre os dados do estoque: \n");
								System.out.print("Insira o ID do Estoque: ");
								String estoqueID = scanner.next();

								System.out.print("Insira a quantidade: ");
								int quantidade = scanner.nextInt();

								// Clear the scanner buffer
								scanner.next();

								// List de pedidos
								List<Pedido> pedidosList = new ArrayList<>();

								//list de fornecedor
								List<Fornecedor> fornecedoresList = new ArrayList<>();
								fornecedoresList.add(newFornecedor);
								//usamos a lista de produtos ja criada
								Estoque newEstoque = new Estoque(estoqueID, quantidade, produtosList, pedidosList, fornecedoresList);
								estoqueDAO.addEstoque(newEstoque);
								System.out.println("Estoque adicionado com sucesso.");

								Comida newComida = new Comida(ComidaID, ComidaNome, ComidaPreco, ComidaPorcao, newFornecedor, newEstoque, ComidaType, ComidaIngr, ComidaDesc);
								comidaDAO.addComida(newComida);
								System.out.println("Produto adicionado com sucesso.");
								break;
						
							case 2:
								//Get Comida by ID
								System.out.print("Insira o ID da Comida: ");
								String searchComidaID = scanner.next();
								Comida foundComida = comidaDAO.getComidaById(searchComidaID);
								if (foundComida != null) {
									System.out.println("Comida encontrado: " + foundComida.toString());
								} else {
									System.out.println("Comida nao encontrado.");
								}
								break;
						
							case 3:
								// Get todas Comidas
								List<Comida> allComidas = comidaDAO.getAllComidas();
								System.out.println("Todas as Comidas:");
								for (Comida Comida : allComidas) {
									System.out.println(Comida.toString());
								}
								break;
						
							case 4:
								// Update Comida
								System.out.print("Insira o ID da Comida a ser atualizada: ");
								String updateprodutoID = scanner.next();
								Comida updateComida = comidaDAO.getComidaById(updateprodutoID);

								if (updateComida != null) {
									System.out.print("Insira o novo nome da Comida: ");
									String newComidaNome = scanner.next();

									System.out.print("Insira o novo tipo da Comida: ");
									String newComidaType = scanner.next();

									System.out.print("Digite o novo preco da Comida: ");
									Double newComidaPreco = scanner.nextDouble();

									System.out.print("Insira o novo tamanho da porcao da Comida em ml: ");
									Double newComidaPorcao = scanner.nextDouble();
									scanner.next(); // Clear the scanner buffer

									System.out.print("Insira os novos ingredientes da Comida: ");
									String newComidaIngr = scanner.next();

									System.out.print("Insira uma nova descrição para essa Comida: ");
									String newComidaDesc = scanner.next();

									// Update the Comida attributes
									updateComida.setNome(newComidaNome);
									updateComida.setTipo(newComidaType);
									updateComida.setPreco(newComidaPreco);
									updateComida.setPorcao(newComidaPorcao);
									updateComida.setIngredientes(newComidaIngr);
									updateComida.setDescricao(newComidaDesc);

									// Update the Fornecedor details
									System.out.print("Insira o CNPJ do fornecedor: ");
									String updateFornecedorCnpj = scanner.next();
									Fornecedor updateFornecedor = fornecedorDAO.getFornecedorByCnpj(updateFornecedorCnpj);

									if (updateFornecedor != null) {
										System.out.print("Insira o novo nome do fornecedor: ");
										String newFornecedorNome = scanner.next();

										System.out.print("Insira o novo telefone do fornecedor: ");
										String newFornecedorTel = scanner.next();

										System.out.print("Insira o novo email do fornecedor: ");
										String newFornecedorEmail = scanner.next();

										// Update the Fornecedor attributes
										updateFornecedor.setNome(newFornecedorNome);
										updateFornecedor.setTelefone(newFornecedorTel);
										updateFornecedor.setEmail(newFornecedorEmail);

										// Update the Fornecedor in the database
										fornecedorDAO.updateFornecedor(updateFornecedor);
										System.out.println("Fornecedor atualizado com sucesso.");
									} else {
										System.out.println("Fornecedor nao encontrado.");
									}

									// Update the Comida in the database
									comidaDAO.updateComida(updateComida);
									System.out.println("Produto atualizado com sucesso.");
								} else {
									System.out.println("Produto nao encontrado.");
								}
								break;
						
							case 5:
								// Delete Comida
								System.out.print("Insira o ID da Comida a ser excluido: ");
								String deleteComidaID = scanner.next();
								Comida deleteComida = comidaDAO.getComidaById(deleteComidaID);
								if (deleteComida != null) {
									comidaDAO.deleteComida(deleteComida);
									System.out.println("Produto excluido com sucesso.");
								} else {
									System.out.println("Produto nao encontrado.");
								}
								break;
						
							case 6:
								// Exit
								System.out.println("Voltando.");
								break;
						
							default:
								System.out.println("Opcao invalida, por favor escolha uma opcao valida.");
						}
						break;
					case 0:
						System.out.println("Exiting program. Goodbye!");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid choice. Please try again.");
				}
			}
		}	
	}
}