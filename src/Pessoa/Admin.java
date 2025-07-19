package Pessoa;

import Cinema_config.Cinema;

public class Admin extends Pessoa {
    private String login;
    private String senha;
    private Cinema cinema;
    private static final String CATEGORIA = "Admin";
    private static final int SENHA_TAMANHO = 8;


    public Admin(String nome, String categoria, int idade, String login, String senha, Cinema cinema) {
        super(nome, categoria, idade);
        super.setCategoria(CATEGORIA);
        this.login = login;
        this.senha = senha;
        if (senha.length() < SENHA_TAMANHO) {
            throw new IllegalArgumentException("A senha deve ter pelo menos " + SENHA_TAMANHO + " caracteres."); ////////////// verificar se login funciona ///////////////////////////////////////////////
        }else if (senha.length() > SENHA_TAMANHO) {
            throw new IllegalArgumentException("A senha não pode ter mais de " + SENHA_TAMANHO + " caracteres.");
        }
        this.cinema = cinema;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cinema getCinema() {
        return cinema;
    }
    
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
    
}
