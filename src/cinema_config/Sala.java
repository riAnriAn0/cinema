package cinema_config;

public class Sala {
    private int numSala;
    private Assento[][] assentos;
    private String nomeFilme;

    public Sala(int numSala, String nomeFilme) {
        this.numSala = numSala;
        this.nomeFilme = nomeFilme;
        this.assentos = new Assento[10][20];
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public void showAssentos() {
        
    }
}