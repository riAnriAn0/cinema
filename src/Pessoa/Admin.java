package Pessoa;

import cinema_config.Cinema;

public class Admin extends Pessoa {
    private String login;
    private int senha;
    private Cinema cinema;
    private static final String CATEGORIA = "Admin";

    public Admin(String nome, int idade, String login, int senha, Cinema cinema) {
        super(nome, CATEGORIA, idade);
        this.login = login;
        this.senha = senha;
        this.cinema = cinema;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getSenha() {
        return senha;
    }

    public Cinema getCinema() {
        return cinema;
    }
    
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
    
}
