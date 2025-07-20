package Cinema_config;

import java.util.ArrayList;
import java.util.Scanner;
import Pessoa.Cliente;

public class Cinema {
    private String nome;
    private Sala[] salas;
    private ArrayList<Filme> filmes;
    private ArrayList<Ingresso> ingressosVendidos;
    private Scanner scanner;

    public Cinema(String nome, Sala[] salas) {
        this.nome = nome;
        this.salas = salas;
        this.filmes = new ArrayList<Filme>();
        this.scanner = new Scanner(System.in);
        this.ingressosVendidos = new ArrayList<Ingresso>();
    }

    public void addFilme(Filme filme) {
        filmes.add(filme);
    }

    public void addIngresso(Ingresso ingresso) {
        ingressosVendidos.add(ingresso);
    }

    public void listarFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
        } else {
            System.out.println("      +---------------------------------------------------+");
            System.out.println("      |                  Filmes em Cartaz                 |");
            for (int i = 0; i < filmes.size(); i++) {
                Filme filme = filmes.get(i);
                if (filme.isDisponiveis()) {
                    filme.showFilme();
                }
            }
        }
    }

    public Cliente cadastraCliente() {
        String nome, categoria;
        int idade;

        System.out.println("      +-------------------------------------------+");
        System.out.println("      |              Cadastro de Cliente          |");
        System.out.println("      +-------------------------------------------+");
        System.out.print("      | Digite o nome do cliente: ");
        nome = scanner.nextLine();
        System.out.print("      | Digite a categoria do cliente (Professor, Normal, Estudante): ");
        categoria = scanner.nextLine();
        System.out.print(
                "      | Digite a idade do cliente: "); ///////////////////////////////////////////////// TRATAR EXCEÇÃO DE TIPO DE DADOS 
        idade = Integer.parseInt(scanner.nextLine());
        Cliente cliente = new Cliente(nome, categoria, idade);
        System.out.println("      +-------------------------------------------+");

        return cliente;

    }

    public Sala selecionarSala() {

        System.out.println("      +-------------------------------------------+");
        System.out.println("      |           Selecione uma Sala              |");
        for (Sala sala : salas) {
            System.out.printf("      | Sala %d: %s%n", sala.getNumSala(), sala.getFilme().getTitulo());
            System.out.println("      +-------------------------------------------+");
        }
        System.out.print("      | Digite o número da sala desejada: ");
        int numeroSala = Integer.parseInt(scanner.nextLine());
        if (numeroSala < 1 || numeroSala > salas.length) {
            System.out.println("      !!! Sala inválida. Deve ser entre 1 e " + salas.length + ".");
            return null;
        }
        return salas[numeroSala - 1];
    }

    public Assento selecionarAssento(Sala sala) {
        System.out.print("      | Digite a fileira do assento (A - T): ");
        char fileira = scanner.nextLine().toUpperCase().charAt(0);
        if (fileira < 'A' || fileira > 'T') {
            System.out.println("      !!! Fileira inválida. Deve ser entre A e T.");
            return null;
        }

        System.out.print("      | Digite o número do assento (1 - 10): ");
        int numeroAssento = Integer.parseInt(scanner.nextLine());
        if (numeroAssento < 1 || numeroAssento > 10) {
            System.out.println("      !!! Número do assento inválido. Deve ser entre 1 e 10.");
            return null;
        }

        if (sala.getAssento(fileira, numeroAssento).getStatus()) {
            System.out.println("      !!! Assento já está ocupado.");
            return null;
        }

        Assento a = sala.getAssento(fileira, numeroAssento);
        a.setStatus(true);
        return a;
    }

    public Ingresso comprarIngresso(Cliente cliente, Sala sala, Assento assento) {

        Ingresso ingresso = new Ingresso(cliente, sala, assento, 22.00);

        System.out.println("      +----------------------------.---------------+");
        System.out.println("      |           Pagamento de Ingresso           |");
        System.out.println("      +-------------------------------------------+");
        System.out.printf("      | Cliente: %s%n", cliente.getNome());
        System.out.printf("      | Filme: %s%n", sala.getFilme().getTitulo());
        System.out.printf("      | Sala: %d%n", sala.getNumSala());
        System.out.printf("      | Assento: %s%n", assento.localizacao());

        System.out.println("      | Valor --------------------------- R$ 22.00");
        if (cliente.getCategoria().equalsIgnoreCase("Professor")) {
            System.out.println("      | Desconto: --------------------------- 30%");
        } else if (cliente.getCategoria().equalsIgnoreCase("Estudante")) {
            System.out.println("      | Desconto: --------------------------- 50%");
        } else if (cliente.getCategoria().equalsIgnoreCase("Idoso")) {
            System.out.println("      | Desconto: ------------------------- 100%");
        } else {
            System.out.println("      | Desconto: ----------------------------- 0%");
        }
        System.out.printf("      | Valor do ingresso: -------------- R$ %.2f%n",
                ingresso.getPreco() * (1 - cliente.getDesconto()));
        System.out.println("      +-------------------------------------------+");

        return ingresso;
    }
}