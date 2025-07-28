package cinema_config;

import Pessoa.Cliente;

public class Ingresso {
    private static final double PRECO = 22.00;
    private Cliente cliente;
    private Sala sala;
    private Assento assento;

    public Ingresso(Cliente cliente, Sala sala, Assento assento) {
        this.cliente = cliente;
        this.sala = sala;
        this.assento = assento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        return PRECO;
    }
    
    public void mostrarIngresso() {
        System.out.println("      +-------------------------------------------+");
        System.out.println("      |                  Ingresso                 |");
        System.out.println("      +-------------------------------------------+");
        System.out.println("      |  Cliente: " + cliente.getNome());
        System.out.println("      |  Filme: " + sala.getFilme().getTitulo());
        System.out.println("      |  Sala: " + sala.getNumSala());
        System.out.println("      |  Assento: " + assento.localizacao());
        System.out.println("      +-------------------------------------------+");
    }

}
