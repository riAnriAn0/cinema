package Pessoa;

public class Cliente extends Pessoa{

    public Cliente(String nome, String categoria, int idade) {
        super(nome, categoria, idade);
        super.setCategoria(idade >= 60 ? "Idoso": categoria);
    }
    
}
