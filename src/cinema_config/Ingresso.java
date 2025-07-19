package Cinema_config;

import Pessoa.Pessoa;

public class Ingresso {
    private double preco;
    private Pessoa pessoa;
    private Sala sala;
    private Assento assento;

    public Ingresso(Pessoa pessoa, Sala sala, Assento assento, double preco) {
        this.pessoa = pessoa;
        this.sala = sala;
        this.assento = assento;
        this.preco = preco;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void mostrarIngresso() {
        System.out.println("      +-------------------------------------------+");
        System.out.println("      |                  Ingresso                 |");
        System.out.println("      +-------------------------------------------+");
        System.out.println("      |  Cliente: " + pessoa.getNome());
        System.out.println("      |  Filme: " + sala.getFilme().getTitulo());
        System.out.println("      |  Sala: " + sala.getNumSala());
        System.out.println("      |  Assento: " + assento.localizacao());
        System.out.println("      +-------------------------------------------+");
    }

}
