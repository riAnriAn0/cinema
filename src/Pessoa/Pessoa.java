package Pessoa;

public abstract class Pessoa {
    private String nome;
    private String categoria;
    private int idade;

    public Pessoa(String nome, String categoria, int idade) {
        this.nome = nome;
        this.categoria = categoria;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    

}
