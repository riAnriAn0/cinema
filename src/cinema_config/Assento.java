package cinema_config;

public class Assento{
    private char fileiera;
    private int numero;
    private boolean status;

    public Assento(int numero,boolean status, char fileiera){
        this.fileiera = fileiera;
        this.numero = numero;
        this.status = status;
    }

}