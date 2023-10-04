import controller.Empresa;
import entitiesFunc.Administrador;
import entitiesFunc.Entregador;
import entitiesFunc.Funcionario;
import entitiesFunc.Vendedor;
import extras.Beneficio;
import extras.Departamento;
import extras.Desconto;

import java.util.Locale;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Empresa empresa = new Empresa();

        while (true) {
            System.out.println("\n\t==============MENU==============");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar funcionário");
            System.out.println("2. Remover funcionário");
            System.out.println("3. Emitir detalhamento");
            System.out.println("4. Realizar pagamento");
            System.out.println("5. Ajustar valores(bonificações, comissões e adicionais)");
            System.out.println("6. Sair");

            System.out.print("Digite sua opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println();
                    System.out.println("1. Administrador");
                    System.out.println("2. Vendedor");
                    System.out.println("3. Entregador");
                    System.out.print("Escolha o tipo de funcionário: ");
                    int tipoFuncionario = scanner.nextInt();

                    System.out.print("Digite o nome do funcionário: ");
                    scanner.nextLine();
                    String nomeFuncionario = scanner.nextLine();

                    System.out.print("Digite o CPF do funcionário: ");
                    String cpfFuncionario = scanner.nextLine();

                    System.out.print("Digite o salário do funcionário: ");
                    double salarioFuncionario = scanner.nextDouble();

                    System.out.print("Digite o nome do departamento: ");
                    scanner.nextLine(); // Limpa o buffer do scanner
                    String nomeDepartamento = scanner.nextLine();
                    Departamento departamento = new Departamento(nomeDepartamento);

                    Beneficio beneficiosPadrao = new Beneficio(200.0, 100.0);
                    Desconto descontosPadrao = new Desconto();

                    if (tipoFuncionario == 1) {
                        System.out.print("Digite o bônus de chefia(EM R$): ");
                        double bonusChefia = scanner.nextDouble();
                        Funcionario administrador = new Administrador(nomeFuncionario, cpfFuncionario, salarioFuncionario, departamento, beneficiosPadrao, descontosPadrao, bonusChefia);
                        if(empresa.addFuncionario(administrador)){
                            System.out.println("Funcionario adicionado com sucesso!");
                        }
                        else{
                            System.out.println("Erro ao adicionar funcionario.");
                        }
                    } else if (tipoFuncionario == 2) {
                        System.out.print("Digite a comissão(EM DECIMAL: Ex: 30% = 0.3): ");
                        double comissao = scanner.nextDouble();
                        Funcionario vendedor = new Vendedor(nomeFuncionario, cpfFuncionario, salarioFuncionario, departamento, beneficiosPadrao, descontosPadrao, comissao);
                        if(empresa.addFuncionario(vendedor)) {
                            System.out.println("Funcionario adicionado com sucesso!\n");
                            System.out.print("Total de vendas feita pelo funcionário: ");
                            int totVendas = scanner.nextInt();
                            scanner.nextLine();
                            int i = 0;
                            while (i < totVendas) {
                                System.out.print("\nData da venda (dd/MM/aaaa): ");
                                String dataS = scanner.nextLine();

                                // Validar o formato da data usando regex
                                if (dataS.matches("\\d{2}/\\d{2}/\\d{4}")) {
                                    System.out.print("Valor da venda: ");
                                    double valorDaVenda = scanner.nextDouble();
                                    scanner.nextLine();
                                    ((Vendedor) vendedor).registrarVenda(dataS, valorDaVenda, true);
                                    i++;
                                } else {
                                    System.out.println("Formato de data inválido. Por favor, insira a data no formato yyyy-MM-dd.");
                                }
                            }
                            System.out.println("Venda adicionada com sucesso.");
                        }
                        else{
                            System.out.println("Erro ao adicionar funcionario.");
                        }
                    } else if (tipoFuncionario == 3) {
                        System.out.print("Digite o adicional de periculosidade(EM R$): ");
                        double periculosidade = scanner.nextDouble();
                        Funcionario entregador = new Entregador(nomeFuncionario, cpfFuncionario, salarioFuncionario, departamento, beneficiosPadrao, descontosPadrao, periculosidade);
                        if(empresa.addFuncionario(entregador)){
                            System.out.println("Funcionario adicionado com sucesso!");
                        }
                        else{
                            System.out.println("Erro ao adicionar funcionario.");
                        }
                    } else {
                        System.out.println("Opção inválida. Funcionário não adicionado.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o nome do funcionário a ser removido: ");
                    scanner.nextLine();
                    String nome = scanner.nextLine();
                    if(empresa.removerFuncionario(nome)){
                        System.out.println("\nFuncionário removido com sucesso!");
                    }
                    else {
                        System.out.println("Funcionário não encontrado. Nenhuma remoção realizada.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome do funcionário: ");
                    scanner.nextLine();
                    String nomeDetalhamento = scanner.nextLine();
                    System.out.println();
                    if(!empresa.emitirDetalhamento(nomeDetalhamento)){
                        System.out.println("ERRO AO EMITIR DETALHAMENTO!");
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome do funcionário que deseja realizar o pagamento: ");
                    scanner.nextLine();
                    String nomePagament = scanner.nextLine();
                    double pagamento = empresa.fazerPagamento(nomePagament);
                    if(pagamento != 0){
                        System.out.printf("Pagamento de %.2fR$ realizado com sucesso para %s!\n", pagamento, nomePagament);
                    }
                    else{
                        System.out.println("ERRO AO REALIZAR PAGAMENTO.");
                    }
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Escolha o que deseja ajustar:");
                    System.out.println("1. Bonificação de Chefia");
                    System.out.println("2. Comissão de Vendedor");
                    System.out.println("3. Adicional de Periculosidade para Entregador");
                    int opcaoAjuste = scanner.nextInt();

                    System.out.print("Digite o CPF do funcionário: ");
                    scanner.nextLine();
                    String cpfFuncionarioAjuste = scanner.nextLine();

                    Funcionario funcionarioAjuste = null;
                    for (Funcionario func : empresa.getFuncionarios()) {
                        if (func.getCpf().equals(cpfFuncionarioAjuste)) {
                            funcionarioAjuste = func;
                            break;
                        }
                    }

                    if (funcionarioAjuste != null) {
                        switch (opcaoAjuste) {
                            case 1:
                                if (funcionarioAjuste instanceof Administrador) {
                                    System.out.println("Digite a nova bonificação de chefia:");
                                    double novaBonificacao = scanner.nextDouble();
                                    ((Administrador) funcionarioAjuste).setBonusChefia(novaBonificacao);
                                    System.out.println("Bonificação de Chefia ajustada com sucesso!");
                                } else {
                                    System.out.println("Funcionário não é um Administrador. Bonificação de Chefia não ajustada.");
                                }
                                break;
                            case 2:
                                if (funcionarioAjuste instanceof Vendedor) {
                                    System.out.println("Digite a nova comissão:");
                                    double novaComissao = scanner.nextDouble();
                                    ((Vendedor) funcionarioAjuste).setComissao(novaComissao);
                                    System.out.println("Comissão ajustada com sucesso!");
                                } else {
                                    System.out.println("Funcionário não é um Vendedor. Comissão não ajustada.");
                                }
                                break;
                            case 3:
                                if (funcionarioAjuste instanceof Entregador) {
                                    System.out.println("Digite o novo adicional de periculosidade:");
                                    double novoAdicional = scanner.nextDouble();
                                    ((Entregador) funcionarioAjuste).setPericulosidade(novoAdicional);
                                    System.out.println("Adicional de Periculosidade ajustado com sucesso!");
                                } else {
                                    System.out.println("Funcionário não é um Entregador. Adicional de Periculosidade não ajustado.");
                                }
                                break;
                            default:
                                System.out.println("Opção inválida. Nenhum ajuste realizado.");
                        }
                    } else {
                        System.out.println("Funcionário não encontrado. Nenhum ajuste realizado.");
                    }
                    break;

                case 6:
                    // Sair
                    System.out.println("Programa encerrado.");
                    return;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}