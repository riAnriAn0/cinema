package Sistema;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Cinema_config.*;
import Pessoa.*;

public class SisteMenus {
    private ArrayList<Menu> menus;
    private Admin donoCinema;

    public SisteMenus(ArrayList<Menu> menus, Admin donoCinema) {
        this.menus = menus;
        this.donoCinema = donoCinema;
    }

    public void menuGerenciamento() {
        Menu.limparTela();
        menus.get(1).mostrarMenu();
        int opGerenciarCinema = menus.get(1).obterOpcao();
        switch (opGerenciarCinema) {
            case 1:
                Menu.limparTela();
                Filme filme = donoCinema.getCinema().cadastrarFilme();
                if (filme != null) {
                    donoCinema.getCinema().addFilme(filme);
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
                Menu.limparTela();
                do {
                    filme = donoCinema.getCinema().buscarFilme();
                    Menu.limparTela();
                } while (filme == null);

                donoCinema.getCinema().removerFilme(filme);
                Menu.mostrarMensagem("      Filme removido com sucesso!");
                Menu.mostrarMensagem("      Pressione 0 para voltar...");
                menus.get(1).obterOpcao();
                Menu.limparTela();
                menuGerenciamento();
                break;
            case 3:
                Menu.limparTela();
                donoCinema.getCinema().listarFilmes();
                Menu.mostrarMensagem("      Pressione 0 para voltar...");
                menus.get(1).obterOpcao();
                Menu.limparTela();
                menuGerenciamento();
                break;
            case 4:
                Menu.limparTela();
                donoCinema.getCinema().listarSalas();
                Menu.mostrarMensagem("      Pressione 0 para voltar...");
                menus.get(1).obterOpcao();
                Menu.limparTela();
                menuGerenciamento();

                break;
            case 5:
                Menu.limparTela();
                donoCinema.getCinema().historicoVendas();
                Menu.mostrarMensagem("      Pressione 0 para voltar...");
                menus.get(1).obterOpcao();
                Menu.limparTela();
                menuGerenciamento();
                break;

            case 6:
                LocalTime horaAtual = LocalTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                Menu.limparTela();

                Relatorio relatorio = new Relatorio("Relatorio de vendas", new java.util.Date().toString(), horaAtual.format(formatter), donoCinema.getCinema().getValorTotal(), donoCinema.getCinema().getIngressosVendidos());

                relatorio.gerarRelatorio();
                donoCinema.getCinema().addRelatorio(relatorio);

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

        Cinema cinema = donoCinema.getCinema();

        int op = -1;
        while (op != 0) {
            Menu.limparTela();
            menus.getFirst().mostrarMenu();
            op = menus.getFirst().obterOpcao();
            switch (op) {
                case 1:
                    Menu.limparTela();
                    cinema.listarFilmes();
                    Menu.mostrarMensagem("      Pressione 0 para voltar...");
                    menus.getFirst().obterOpcao();
                    Menu.limparTela();
                    initSistema();
                    break;
                case 2:
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
