package Cinema_config;

public class Assento{
    private char fileiera;
    private int numero;
    private boolean status;

    public Assento(int numero, char fileiera){
        this.fileiera = fileiera;
        this.numero = numero;
        this.status = false;
    }

    public String localizacao(){
        String l = String.valueOf(fileiera);
        l += String.valueOf(numero);
        return l;
    }

    public char getFileiera() {
        return fileiera;
    }

    public void setFileiera(char fileiera) {
        this.fileiera = fileiera;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    
}