package Cinema_config;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Pessoa.Cliente;
import Sistema.Menu;
import Sistema.Relatorio;

public class Cinema {
    private String nome;
    private Sala[] salas;
    private ArrayList<Filme> filmes;
    private ArrayList<Ingresso> ingressosVendidos;
    private Scanner scanner;
    private ArrayList<Relatorio> relatorio;
    private double valorTotal;

    public Cinema(String nome, Sala[] salas) {
        this.nome = nome;
        this.salas = salas;
        this.filmes = new ArrayList<Filme>();
        this.scanner = new Scanner(System.in);
        this.ingressosVendidos = new ArrayList<Ingresso>();
        this.valorTotal = 0.0;
        this.relatorio = new ArrayList<Relatorio>();
    }

    public ArrayList<Ingresso> getIngressosVendidos() {
        return ingressosVendidos;
    }

    public void setIngressosVendidos(ArrayList<Ingresso> ingressosVendidos) {
        this.ingressosVendidos = ingressosVendidos;
    }
    
    public double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public void atualizarValorTotal(double valorTotal) {
        this.valorTotal += valorTotal;
    }

    public void addRelatorio(Relatorio relatorio) {
        this.relatorio.add(relatorio);
    }

    public void addFilme(Filme filme) {
        filmes.add(filme);
    }

    public void removerFilme(Filme filme) {
        filmes.remove(filme);
        this.salas[filme.getSala() - 1].setFilme(null);
    }

    public void listarSalas() {
        System.out.println("      +---------------------------------------------------+");
        System.out.println("      |                  Salas do Cinema                  |");
        for (Sala sala : salas) {
            System.out.printf("      | Sala %d: %s%n", sala.getNumSala(), sala.getFilme() != null ? sala.getFilme().getTitulo() : "Sem filme em exibição");
            System.out.println("      +---------------------------------------------------+");
        }
    }

    public Filme buscarFilme() {
        System.out.println("      +---------------------------------------------------+");
        System.out.println("      |                  Busca de Filme                   |");
        System.out.println("      +---------------------------------------------------+");
        System.out.print("      | Digite o título do filme: ");
        String titulo = scanner.nextLine();
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                return filme;
            }
        }
        return null;
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
                filme.showFilme();
            }
        }
    }

    public void listarFilmesDisponiveis() {
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

    public Cliente cadastraCliente() throws NumberFormatException {
        String nome, categoria;
        int idade;
        boolean continueInput = false;
        Cliente cliente = null;

        do {
                System.out.println("      +-------------------------------------------+");
                System.out.println("      |              Cadastro de Cliente          |");
                System.out.println("      +-------------------------------------------+");
                System.out.print("      | Digite o nome do cliente: ");
                nome = scanner.nextLine();
                System.out.print("      | Digite a categoria do cliente (Professor, Normal, Estudante): ");
                categoria = scanner.nextLine();
            try {
                System.out.print("      | Digite a idade do cliente: ");
                idade = Integer.parseInt(scanner.nextLine());
                cliente = new Cliente(nome, categoria, idade);
                System.out.println("      +-------------------------------------------+");
                
            } catch (NumberFormatException e) {
                System.out.println("      !!! Entrada inválida. Tente novamente.");
                continue;
            }
        } while (continueInput);

        return cliente;
    }

    public Sala selecionarSala() {

        System.out.println("      +-------------------------------------------+");
        System.out.println("      |           Selecione uma Sala              |");
        for (Sala sala : salas) {
            System.out.printf("      | Sala %d: %s%n", sala.getNumSala(), sala.getFilme() != null ? sala.getFilme().getTitulo() : "Sem filme em exibição");
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

    public Assento selecionarAssento(Sala sala) throws NumberFormatException {
        // boolean continueInput = false;

        System.out.print("      | Digite a fileira do assento (A - T): ");
        char fileira = scanner.nextLine().toUpperCase().charAt(0);
       
        if (fileira < 'A' || fileira > 'T') {
            System.out.println("      !!! Fileira inválida. Deve ser entre A e T.");
            return null;
        }

        int numeroAssento = 0;

        do {
            System.out.print("      | Digite o número do assento (1 - 10): ");
            try {
                numeroAssento = Integer.parseInt(scanner.nextLine());
                if (numeroAssento < 1 || numeroAssento > 10) {
                    System.out.println("      !!! Número do assento inválido. Deve ser entre 1 e 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("      !!! Entrada inválida. Tente novamente.");
            }
        } while (numeroAssento < 1 || numeroAssento > 10);

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

        Ingresso ingresso = new Ingresso(cliente, sala, assento);

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

        atualizarValorTotal(ingresso.getPreco() * (1 - ingresso.getCliente().getDesconto()));

        return ingresso;
    }

    public Filme cadastrarFilme() throws InputMismatchException {
        String titulo = null, diretor = null, genero = null, sinopse = null;
        int duracao = 0;
        boolean continueInput = true;

        System.out.println("      +-------------------------------------------+");
        System.out.println("      |              Cadastro de Filme            |");
        System.out.println("      +-------------------------------------------+");
        do {
            try {
                System.out.print("      | Digite o título do filme: ");
                titulo = scanner.nextLine();
                System.out.print("      | Digite o gênero do filme: ");
                genero = scanner.nextLine();
                System.out.print("      | Digite o diretor do filme: ");
                diretor = scanner.nextLine();
                System.out.print("      | Digite a duração do filme (em MIN): ");
                duracao = scanner.nextInt();
                System.out.print("      | Digite a sinopse do filme: ");
                sinopse = scanner.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("      !!! Entrada inválida. Tente novamente.");
                scanner.nextLine();
                Menu.limparTela();
                continueInput = true;
                continue;
            }
        } while (continueInput);
        scanner.nextLine();

        Filme filme = new Filme(titulo, diretor, genero, duracao, sinopse);

        System.out.println("      +-------------------------------------------+");
        System.out.println("      | Filme cadastrado com sucesso!            |");
        System.out.println("      +-------------------------------------------+");

        return filme;
    }

    public void historicoVendas() {
        System.out.println("      +-------------------------------------------+");
        System.out.println("      |           Histórico de Vendas             |");
        System.out.println("      +-------------------------------------------+");
        if (ingressosVendidos.isEmpty()) {
            System.out.println("      | Nenhum ingresso vendido até o momento.   |");
        } else {
            for (Ingresso ingresso : ingressosVendidos) {
                System.out.printf("      | Cliente: %s, Filme: %s, Sala: %d, Assento: %s Valor: R$ %.2f%n",
                        ingresso.getCliente().getNome(),
                        ingresso.getSala().getFilme().getTitulo(),
                        ingresso.getSala().getNumSala(),
                        ingresso.getAssento().localizacao(),
                        ingresso.getPreco() * (1 - ingresso.getCliente().getDesconto()));
            }
        }
        System.out.println("      +-------------------------------------------+");
    }
}
