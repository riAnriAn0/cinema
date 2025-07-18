package Cinema_config;
import java.util.ArrayList;

public class Cinema{
    private String nome;
    private Sala[] salas;
    private Filme[] filmes;
    private ArrayList<Ingresso> ingressosVendidos;

    public Cinema(String nome) {
        this.nome = nome;
        this.salas = new Sala[5];
        this.filmes = new Filme[10];
        this.ingressosVendidos = new ArrayList<Ingresso>();
    }

}