package Cinema_config;

public class Sala {
    private int numSala;
    private Assento[][] assentos;
    private String nomeFilme;
    private static final int MAX_LINHAS = 20;
    private static final int MAX_COLUNAS = 10;

    public Sala(int numSala, String nomeFilme) {
        this.numSala = numSala;
        this.nomeFilme = nomeFilme;
        this.assentos = new Assento[MAX_LINHAS][MAX_COLUNAS];
        initSala();
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

    public void initSala() {
        char fileiera = 'A';
        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[i].length; j++) {
                assentos[i][j] = new Assento(j + 1, fileiera);
            }
            fileiera++;
        }

    }

    public void showAssentos() {
        System.out.println("      +---------------------------------------------------+");
        System.out.println("        SALA " + numSala + " - " + nomeFilme);
        System.out.println("      +---------------------------------------------------+");
        System.out.println("      | [01] [02] [03] [04] [05] [06] [07] [08] [09] [10] |");
        System.out.println("      +---------------------------------------------------+");
        char fileiera = 'A';
        for (int i = 0; i < MAX_LINHAS; i++) {
            System.out.print(fileiera + " ->  |");
            for (int j = 0; j < MAX_COLUNAS; j++) {
                System.out.print(assentos[i][j].getStatus() ? " [XX]" : " [  ]");
            }
            System.out.print(" |");
            System.out.print("\n");
            fileiera++;
        }
        System.out.println("      +---------------------------------------------------+");
    }
}