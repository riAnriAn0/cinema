package Sistema;

import java.util.ArrayList;
import java.util.Scanner;

import Cinema_config.Cinema;

public class SisteMenus {
    private ArrayList<Menu> menus;
    private Cinema cinema;

    public SisteMenus(ArrayList<Menu> menus, Cinema cinema) {
        this.menus = menus;
        this.cinema = cinema;
    }

    public void initSistema() {
        int op = -1;
        // Scanner scanner = new Scanner(System.in);
        while (op != 0) {
            Menu.limparTela();  
            menus.get(0).mostrarMenu();
            op = menus.get(0).obterOpcao();
            switch (op) {
                case 1:
                    Menu.limparTela();
                    cinema.listarFilmes();
                    Menu.mostrarMensagem("      Pressione 0 para voltar...");
                    menus.get(0).obterOpcao();
                    Menu.limparTela();
                    initSistema();
                    break;
                case 2:
                    // Chamar método para comprar ingresso
                    break;
                case 3:
                    // Chamar método para gerenciar cinema
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
