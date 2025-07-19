package Cinema_config;

public class Sala {
    private int numSala;
    private Assento[][] assentos;
    private Filme filme;
    private static final int MAX_LINHAS = 20;
    private static final int MAX_COLUNAS = 10;

    public Sala(int numSala, Filme filme) {
        this.numSala = numSala;
        this.filme = filme;
        this.assentos = new Assento[MAX_LINHAS][MAX_COLUNAS];
        initSala();
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
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
        System.out.println("        SALA " + numSala + " - " + filme.getTitulo());
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

    public Assento getAssento(char fileira, int numero) {
        int linha = fileira - 'A';
        int coluna = numero - 1;
        if (linha < 0 || linha >= MAX_LINHAS || coluna < 0 || coluna >= MAX_COLUNAS) {
            return null;
        }
        return assentos[linha][coluna];
    }

}