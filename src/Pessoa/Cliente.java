package Pessoa;

public class Cliente extends Pessoa{

    public Cliente(String nome, String categoria, int idade) {
        super(nome, categoria, idade);
        super.setCategoria(idade >= 60 ? "Idoso": categoria);
    }

    public double getDesconto() {
        if(super.getCategoria().equalsIgnoreCase("Professor")) {
            return 0.3; 
        } else if (super.getCategoria().equalsIgnoreCase("Estudante")) {
            return 0.5; 
        } else if (super.getCategoria().equalsIgnoreCase("Idoso")) {
            return 1.0; 
        }else{
            return 0.0; 
        }
    }
    
}
