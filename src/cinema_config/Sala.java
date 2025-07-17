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
        System.out.println("SALA" + this.numSala + " - Assentos:\n\n");
        System.out.println(
                " [01] [02] [03] [04] [05] [06] [07] [08] [09] [10] [11] [12] [13] [14] [15] [16] [17] [18] [19] [20]\n");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
            }
        }
        System.out.println(
                "--------------------------------------------------------------------------------------------\n");
    }
}