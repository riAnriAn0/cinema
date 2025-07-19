package Pessoa;

public class Cliente extends Pessoa{

    public Cliente(String nome, String categoria, int idade) {
        super(nome, categoria, idade);
        super.setCategoria(idade >= 60 ? "Idoso": categoria);
    }

    public double getDesconto() {
        switch (super.getCategoria()) {
            case "Professor":
                return 0.30; 
            case "Estudante":
                return 0.50; 
            case "Idoso":
                return 1.00; 
            default:
                return 0.00; 
        }
    }
    
}
