/*package br.ufla.gac106.s2023_1.AdventureWorld.moduloAdministracao;

import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner entrada; // Objeto Scanner para ler entradas do usuário
    private Central central; // Objeto Central para gerenciar os dados

    public InterfaceUsuario() {
        entrada = new Scanner(System.in); // Inicializa o Scanner para ler a entrada do usuário
        central = new Central(); // Inicializa o objeto Central para gerenciar os dados
    }

    public void executar() {
        System.out.println(central.carregarDados("dados.bin"));
        String opcao;
        do {
            System.out.println("--- Bem-Vindo ao módulo adminstrativo ---");
            System.out.println("1- Administrar Eventos");
            System.out.println("2- Administrar Locais");
            System.out.println("3- Administrar Atividades");
            System.out.println("4- Sair do Programa");
            System.out.println("0- Excluir dados\n");
            System.out.print("Digite a opção desejada: " + "\n > "); 

            opcao = entrada.nextLine(); // Lê a opção digitada pelo usuário
            System.out.println();

            tratarMenu(opcao); // Chama o método tratarMenu para processar a opção escolhida

        } while (!opcao.equals("4")); // Continua executando até que a opção seja "4" (Sair do Programa)
    }

    private void tratarMenu(String opcao) {
        switch (opcao) {
            case "0":
                System.out.println(central.limparDados());
                break;
            case "1":
                administrarEventos(); // Chama o método para administrar eventos
                break;
            case "2":
                administrarLocais(); // Chama o método para administrar locais
                break;
            case "3":
                administrarAtividades(); // Chama o método para administrar atividades
                break;
            case "4":
                System.out.println("Saindo..."); // Exibe mensagem de saída
                System.out.println(central.salvarDados("dados.bin"));
                break;
            default:
                System.out.println("Opção inválida!"); // Exibe mensagem de opção inválida
                break;
        }
    }

    private void administrarEventos() {
        String opcao;

        do {
            String tipo = "=== Eventos ===";
            exibirMenu(tipo); // Exibe o menu para administrar eventos

            opcao = entrada.nextLine(); // Lê a opção digitada pelo usuário
            System.out.println();

            switch (opcao) {
                case "1":
                    cadastrarEvento();
                    break;
                case "2":
                    System.out.println(central.listarParques());
                    break;
                case "3":
                    String nomeDetalhe = pedirString("Digite o nome do Parque que deseja detalhar\n");
                    System.out.println(central.detalharParque(nomeDetalhe));
                    break;
                case "4":
                    String nomeParqueRemover = pedirString("Digite o nome do Parque a ser removido");
                    System.out.println(central.removerParque(nomeParqueRemover));
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (!opcao.equals("5"));
    }

    private void cadastrarEvento() {
        String nomeParque = pedirString("Digite o nome do Parque");
        if (central.verificaParque(nomeParque)) {
            System.out.println("Parque já cadastrado.\n");
        } else {
            ArrayList<String> listaAtracoes = lerAtracoesDoUsuario();
            central.cadastrarParque(nomeParque, listaAtracoes);
        }
    }

    private void administrarLocais() {
        String opcao;

        do {
            String tipo = "=== Locais ===";
            exibirMenu(tipo); // Exibe o menu para administrar locais

            opcao = entrada.nextLine(); // Lê a opção digitada pelo usuário
            System.out.println();

            switch (opcao) {
                case "1":
                    cadastrarLocal();
                    break;
                case "2":
                    System.out.println(central.listarCidades());
                    break;
                case "3":
                    String nomeDetalhe = pedirString("Digite o nome da Cidade que deseja detalhar\n");
                    System.out.println(central.detalharCidade(nomeDetalhe));
                    break;
                case "4":
                    String nomeLocalRemover = pedirString("Digite o nome do local a ser removido");
                    System.out.println(central.removerCidade(nomeLocalRemover));
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (!opcao.equals("5"));
    }

    private void cadastrarLocal() {
        String nomeCidade = pedirString("Digite o nome da Cidade");
        if (central.verificaCidade(nomeCidade)) {
            System.out.println("Local já cadastrado.\n");
        } else {
            String nomeEstado = pedirString("Digite o nome da Estado");
            central.cadastrarCidade(nomeCidade, nomeEstado);
        }
    }

    private void administrarAtividades() {
        String opcao;

        do {
            String tipo = "=== Atividades ===";
            exibirMenu(tipo); // Exibe o menu para administrar atividades

            opcao = entrada.nextLine(); // Lê a opção digitada pelo usuário
            System.out.println();

            switch (opcao) {
                case "1":
                    cadastrarAtividade();
                    break;
                case "2":
                    String nomeListarVisitas = pedirString(
                            "Digite o nome do parque associado à visita que deseja listar");
                    System.out.println(central.listarVisitas(nomeListarVisitas));
                    break;
                case "3":
                    String nomeDetalharVisita = pedirString("Digite o nome da visita que deseja detalhar");
                    System.out.println(central.detalharVisita(nomeDetalharVisita));
                    break;
                case "4":
                    String nomeParqueAtividade = pedirString("Digite o nome da visita que deseja remover");
                    System.out.println(central.removerVisita(nomeParqueAtividade));
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (!opcao.equals("5"));
    }

    private void cadastrarAtividade() {
        String nomeVisita = pedirString("Digite o nome da Visita");
        if (central.verificaVisita(nomeVisita)) {
            System.out.println("Visita já cadastrada.\n");
        } else {
            String nomeParque = pedirString("Digite o nome do Parque");
            if (!central.verificaParque(nomeParque)) {
                System.out.println("Parque não existente.\n");
            } else {
                String nomeCidade = pedirString("Digite o nome da Cidade");
                if (!central.verificaCidade(nomeCidade)) {
                    System.out.println("Cidade não existente.\n");
                } else {
                    String tipoIngresso = pedirString("Digite o tipo de Ingresso (1 Para Normal / 2 Para Vip)");
                    String data = pedirString("Digite a data da visita");
                    String horario = pedirString("Digite o horario da visita");

                    central.cadastrarVisita(nomeVisita, central.obterParquePorNome(nomeParque),
                            central.obterCidadePorNome(nomeCidade), tipoIngresso, data, horario);
                }
            }
        }
    }

    public void exibirMenu(String tipo) {
        System.out.println(tipo); // Exibe o menu, informando o tipo dele
        System.out.println("1- Cadastrar");
        System.out.println("2- Listar");
        System.out.println("3- Detalhar");
        System.out.println("4- Remover");
        System.out.println("5- Sair\n");
        System.out.print("Digite a opção desejada: " + "\n > ");
    }

    private String pedirString(String instrucao) {
        System.out.print(instrucao + ": "); // Exibe a instrução recebida como parâmetro
        String informacao = entrada.nextLine(); // Lê a informação digitada pelo usuário
        return informacao; // Retorna a informação lida
    }

    public ArrayList<String> lerAtracoesDoUsuario() {
        ArrayList<String> listaStrings = new ArrayList<String>(); // Cria uma lista de strings vazia

        System.out.print("Digite as atrações (digite 'fim' para encerrar): ");
        String atracao = entrada.nextLine(); // Lê a primeira atração digitada pelo usuário

        while (!atracao.equalsIgnoreCase("fim")) {
            listaStrings.add(atracao); // Adiciona a atração à lista
            atracao = entrada.nextLine(); // Lê a próxima atração digitada pelo usuário
        }

        System.out.println();

        return listaStrings; // Retorna a lista de atrações preenchida
    }
}
*/
