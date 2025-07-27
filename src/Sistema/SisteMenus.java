package Sistema;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Cinema_config.*;
import Pessoa.*;

public class SisteMenus {
    private ArrayList<Menu> menus;
    private ArrayList<Admin> donoCinema;

    public SisteMenus(ArrayList<Menu> menus, ArrayList<Admin> donoCinema) {
        this.menus = menus;
        this.donoCinema = donoCinema;
    }

    public boolean verificarLogin() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        String login = "";
        int senha = 0;
        
        do{
            Menu.limparTela();
            System.out.println("      +---------------------------------------------------+");
            System.out.println("      |               Configurações Cinema                |");
            System.out.println("      +---------------------------------------------------+");
            
            do{
                try {
                    System.out.print("      | Digite o login: ");
                    login = scanner.nextLine();
                    System.out.print("      | Digite a senha: ");
                    senha = scanner.nextInt();
                    scanner.nextLine();

                } catch (InputMismatchException e) {
                    Menu.mostrarMensagem("      !!! Entrada inválida. Tente novamente.");
                    scanner.nextLine(); 
                }
                break;
            }while (true);

            for (Admin admin : donoCinema) {
                if (admin.getLogin().equals(login) && admin.getSenha() == senha) {
                    Menu.mostrarMensagem("      Login realizado com sucesso!");
                    return true;
                }
            }
            
            Menu.mostrarMensagem("      !!! Login ou senha inválidos. Tente novamente.");
            
            System.out.println("      Pressione 0 para sair ou 1 para tentar novamente...");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            if (opcao == 0) {
                Menu.limparTela();
                System.out.println("      Obrigado por usar o sistema ^_^ !!!");
                return false;
            }
        } while (true);
    }

    public void menuGerenciamento() {
        Menu.limparTela();
        menus.get(1).mostrarMenu();
        int opGerenciarCinema = menus.get(1).obterOpcao();
        switch (opGerenciarCinema) {
            case 1:
                // Cadastrar filme
                Menu.limparTela();
                Filme filme = donoCinema.getFirst().getCinema().cadastrarFilme();
                if (filme != null) {
                    donoCinema.getFirst().getCinema().addFilme(filme);
                    Menu.mostrarMensagem("      Filme cadastrado com sucesso!");
                } else {
                    Menu.mostrarMensagem("      !!! Não foi possível cadastrar o filme.");
                }
                Menu.mostrarMensagem("      Pressione 0 para voltar...");
                menus.get(1).obterOpcao();
                Menu.limparTela();
                menuGerenciamento();
                break;
            case 2:
                // Remover filme
                Menu.limparTela();
                do {
                    filme = donoCinema.getFirst().getCinema().buscarFilme();
                    Menu.limparTela();
                } while (filme == null);

                donoCinema.getFirst().getCinema().removerFilme(filme);
                Menu.mostrarMensagem("      Filme removido com sucesso!");
                Menu.mostrarMensagem("      Pressione 0 para voltar...");
                menus.get(1).obterOpcao();
                Menu.limparTela();
                menuGerenciamento();
                break;
            case 3:
                // Listar filmes
                Menu.limparTela();
                donoCinema.getFirst().getCinema().listarFilmes();
                Menu.mostrarMensagem("      Pressione 0 para voltar...");
                menus.get(1).obterOpcao();
                Menu.limparTela();
                menuGerenciamento();
                break;
            case 4:
                // Listar salas
                Menu.limparTela();
                donoCinema.getFirst().getCinema().listarSalas();
                Menu.mostrarMensagem("      Pressione 0 para voltar...");
                menus.get(1).obterOpcao();
                Menu.limparTela();
                menuGerenciamento();

                break;
            case 5:
                // Histórico de vendas
                Menu.limparTela();
                donoCinema.getFirst().getCinema().historicoVendas();
                Menu.mostrarMensagem("      Pressione 0 para voltar...");
                menus.get(1).obterOpcao();
                Menu.limparTela();
                menuGerenciamento();
                break;

            case 6:
                // Gerar relatório
                LocalTime horaAtual = LocalTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                Menu.limparTela();

                Relatorio relatorio = new Relatorio("Relatorio de vendas", new java.util.Date().toString(), horaAtual.format(formatter), donoCinema.getFirst().getCinema().getValorTotal(), donoCinema.getFirst().getCinema().getIngressosVendidos());

                relatorio.gerarRelatorio();
                donoCinema.getFirst().getCinema().addRelatorio(relatorio);

                Menu.mostrarMensagem("      Pressione 0 para voltar...");
                menus.get(1).obterOpcao();
                Menu.limparTela();
                menuGerenciamento();
                break;

            case 0:

                Menu.limparTela();
                initSistema();
                break;
            default:
                Menu.mostrarMensagem("      Opção inválida. Tente novamente.");
        }
    }

    public void initSistema() {

        Cinema cinema = donoCinema.getFirst().getCinema();

        int op = -1;
        while (op != 0) {
            Menu.limparTela();
            menus.getFirst().mostrarMenu();
            op = menus.getFirst().obterOpcao();
            switch (op) {
                case 1:
                // Listar filmes disponíveis
                Menu.limparTela();
                    cinema.listarFilmesDisponiveis();
                    Menu.mostrarMensagem("      Pressione 0 para voltar...");
                    menus.getFirst().obterOpcao();
                    Menu.limparTela();
                    initSistema();
                    break;
                case 2:
                    // Comprar ingresso
                    Menu.limparTela();
                    Sala sala = null;
                    Assento assento = null;
                    Cliente cliente = null;

                    do {
                        Menu.limparTela();
                        cliente = cinema.cadastraCliente();
                    } while (cliente == null);

                    do {
                        Menu.limparTela();
                        sala = cinema.selecionarSala();
                    } while (sala == null);

                    do {
                        Menu.limparTela();
                        sala.showAssentos();
                        assento = cinema.selecionarAssento(sala);

                    } while (assento == null);

                    Menu.limparTela();
                    Ingresso ingresso = cinema.comprarIngresso(cliente, sala, assento);
                    if (ingresso == null) {
                        Menu.mostrarMensagem("      !!! Não foi possível comprar o ingresso.");
                        Menu.mostrarMensagem("      Pressione 0 para voltar...");
                        menus.get(0).obterOpcao();
                        Menu.limparTela();
                        initSistema();
                        break;
                    }

                    cinema.addIngresso(ingresso);

                    Menu.mostrarMensagem("      Ingresso comprado com sucesso! \n");
                    Menu.mostrarMensagem("      Pressione 0 para voltar...");

                    menus.get(0).obterOpcao();

                    Menu.limparTela();
                    initSistema();

                    break;
                case 3:
                    // Gerenciar cinema
                    if(!verificarLogin()) {
                        return;
                    }
                    menuGerenciamento();
                    break;
                case 4:
                    // Chamar método para gerenciar pessoas
                    break;
                case 0:
                    Menu.mostrarMensagem("Obrigado por usar o sistema ^_^ !!!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

}
