package Cinema_config;

import java.util.ArrayList;
import java.util.Scanner;
import Pessoa.Cliente;

public class Cinema {
    private String nome;
    private Sala[] salas;
    private ArrayList<Filme> filmes;
    private ArrayList<Ingresso> ingressosVendidos;

    public Cinema(String nome) {
        this.nome = nome;
        this.salas = new Sala[5];
        this.filmes = new ArrayList<Filme>();
        this.ingressosVendidos = new ArrayList<Ingresso>();
    }

    public void addFilme(Filme filme) {
        filmes.add(filme);
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

        Scanner scanner = new Scanner(System.in);
        System.out.println("      +-------------------------------------------+");
        System.out.println("      |              Cadastro de Cliente          |");
        System.out.println("      +-------------------------------------------+");
        System.out.print("| Digite o nome do cliente: ");
        nome = scanner.nextLine();
        System.out.print("| Digite a categoria do cliente (Professor, Normal, Estudante): ");
        categoria = scanner.nextLine();
        System.out.print("| Digite a idade do cliente: ");
        idade = Integer.parseInt(scanner.nextLine());
        Cliente cliente = new Cliente(nome, categoria, idade);
        System.out.println("      +-------------------------------------------+");
        scanner.close();

        return cliente;

    }

    public Filme SelecionarFilme() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("      +-------------------------------------------+");
        System.out.println("      |           Selecione um Filme              |");
        listarFilmes();
        if (filmes.isEmpty()) {
            System.out.println("      !!! Nenhum filme disponível.");
            scanner.close();
            return null;
        }

        System.out.print("| Digite o título do filme desejado: ");
        String nomeFilme = scanner.nextLine();
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(nomeFilme)) {
                scanner.close();
                return filme;
            }
        }
        System.out.println("      !!! Filme inválido.");
        scanner.close();
        return null;
    }

    public void comprarIngresso(Cliente cliente, Sala sala, Assento assento) {
        
    }

}