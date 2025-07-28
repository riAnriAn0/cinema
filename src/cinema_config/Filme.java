package cinema_config;

public class Filme {
    private String titulo;
    private int duracao;
    private String genero;
    private String diretor;
    private String sinopse;
    private boolean disponiveis;
    private int sala;

    public Filme(String titulo, String diretor, String genero, int duracao, String sinopse, int sala) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
        this.diretor = diretor;
        this.sinopse = sinopse;
        this.disponiveis = false;
        this.sala = sala;
    }

    public Filme(String titulo, String diretor, String genero, int duracao, String sinopse) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
        this.diretor = diretor;
        this.sinopse = sinopse;
        this.disponiveis = false; 
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public boolean isDisponiveis() {
        return disponiveis;
    }

    public void setDisponiveis(boolean disponiveis) {
        this.disponiveis = disponiveis;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public void showFilme(int op) {
        System.out.println("      +---------------------------------------------------+");
        System.out.printf("      |                  %s         SALA: %2d       %n", titulo, sala);
        System.out.println("      +---------------------------------------------------+");
        if(op == 1){
            System.out.println("      | Diretor: " + diretor);
            System.out.println("      | Gênero: " + genero);
            System.out.println("      | Duração: " + duracao + " min");
            System.out.println("      | Sinopse: " + sinopse);
        }
    }
}
