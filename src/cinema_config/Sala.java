package cinema_config;

public class Sala {
    private int numSalas;
    private Assento[][] assentos; 
    private String nomeFilme;
    
    public Sala(int numSalas, String nomeFilme) {
        this.numSalas = numSalas;
        this.nomeFilme = nomeFilme;
        this.assentos = new Assento[10][20];
    }

    public int getNumSalas() {
        return numSalas;
    }

    public void setNumSalas(int numSalas) {
        this.numSalas = numSalas;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }
    
}
