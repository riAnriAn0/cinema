package Cinema_config;

import java.util.ArrayList;

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

}