import cinema_config.Sala;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Sala sala1 = new Sala(1, "Filme A");
        sala1.showAssentos();
    }
}
