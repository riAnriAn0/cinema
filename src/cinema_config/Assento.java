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

    public char getFileiera() {
        return fileiera;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isStatus() {
        return status;
    }

    public void setFileiera(char fileiera) {
        this.fileiera = fileiera;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}