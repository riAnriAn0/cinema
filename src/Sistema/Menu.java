package Sistema;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private int maxOpcoes;
    private String[] opcoes;
    private String nome;

    public Menu(String nome, int maxOpcoes, String[] opcoes, Scanner scanner) {
        this.scanner = scanner;
        this.maxOpcoes = maxOpcoes;
        this.opcoes = opcoes;
        this.nome = nome;
    }

    public void mostrarMenu() {
        System.out.println("      +---------------------------------------------------+");
        System.out.println("      |                  " + nome + "                   |");
        System.out.println("      +---------------------------------------------------+");
        for (int i = 1; i <= maxOpcoes; i++) {
            System.out.printf("      | [ %02d ] %s                                   \n", i, opcoes[i - 1]);
        }
        System.out.println("      | [ 00 ] Sair");
        System.out.println("      +---------------------------------------------------+");
    }

    public static void mostrarMensagem(String mensagem) {
        System.out.println("\n" + mensagem + "\n");
    }

    public int obterOpcao() throws NumberFormatException {
        int n = -1;
        do {
            try {
                System.out.print("      | Digite a opção desejada: ");
                n = Integer.parseInt(scanner.nextLine());
                if (n < 0 || n > maxOpcoes) {
                    mostrarMensagem(nome + " -> Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                mostrarMensagem(nome + " ->> Entrada inválida. Digite um número.");
            }
        } while (n < 0 || n > maxOpcoes);

        return n;
    }

    public static void limparTela() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fechar() {
        scanner.close();
    }
}
