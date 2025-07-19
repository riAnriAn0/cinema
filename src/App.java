import Cinema_config.*;
import Sistema.Menu;
import Sistema.SisteMenus;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Criando o cinema
        Cinema cinema = new Cinema("Absolute Cinema");
      
        // Criando os menus
        Menu menuPrincipal = new Menu("Menu Principal", 4, new String[] {
                "Filmes Em Cartaz",
                "Comprar Ingresso",
                "Gerenciar Cinema",
                "Gerenciar Pessoas",
        }, new Scanner(System.in));
        Menu menuGerenciarCinema = new Menu("Gerenciar Cinema", 5, new String[] {
                "Adicionar Filme",
                "Listar Filmes",
                "Listar Salas",
                "Historico de vendas",
                "Gerar Relatório .txt",
        }, new Scanner(System.in));
        Menu menuGerenciarPessoas = new Menu("Gerenciar Pessoas", 2, new String[] {
                "Adicionar Cliente",
                "Listar Clientes",
        }, new Scanner(System.in));

        // Lista de menus
        ArrayList<Menu> menus = new ArrayList<>();

        // Adicionando menus à lista
        menus.add(menuPrincipal);
        menus.add(menuGerenciarCinema);
        menus.add(menuGerenciarPessoas);

        // Criando o sistema de menus
        SisteMenus sistemaMenus = new SisteMenus(menus, cinema);

        // Adicionando filmes de exemplo
        Filme filme1 = new Filme("Avatar", "James Cameron", "Aventura/Sci-Fi", 180,
                "A história de um ex-fuzileiro que se junta a uma tribo alienígena em Pandora.");
        Filme filme2 = new Filme("Inception", "Christopher Nolan", "Aventura/Sci-Fi", 148,
                "Um ladrão que invade os sonhos das pessoas para roubar segredos.");
        Filme filme3 = new Filme("The Godfather", "Francis Ford Coppola", "Crime/Drama", 175,
                "A saga da família mafiosa Corleone na América dos anos 40 e 50.");
        Filme filme4 = new Filme("The Dark Knight", "Christopher Nolan", "Ação/Crime", 152,
                "Batman enfrenta o Coringa em Gotham City.");
        Filme filme5 = new Filme("Pulp Fiction", "Quentin Tarantino", "Crime/Drama", 154,
                "Histórias interligadas de criminosos em Los Angeles.");
        Filme filme6 = new Filme("The Shawshank Redemption", "Frank Darabont", "Drama", 142,
                "A amizade entre dois prisioneiros em Shawshank.");
        Filme filme7 = new Filme("Forrest Gump", "Robert Zemeckis", "Drama/Romance", 142,
                "A vida extraordinária de um homem simples com um coração puro.");
        Filme filme8 = new Filme("The Matrix", "Lana Wachowski, Lilly Wachowski", "Ação/Sci-Fi", 136,
                "Um hacker descobre a verdade sobre a realidade em que vive.");
        Filme filme9 = new Filme("Interstellar", "Christopher Nolan", "Aventura/Sci-Fi", 169,
                "Uma equipe de astronautas viaja através de um buraco de minhoca em busca de um novo lar para a humanidade.");
        Filme filme10 = new Filme("Gladiator", "Ridley Scott", "Ação/Aventura", 155,
                "Um general romano é traído e busca vingança como gladiador.");

        // Definindo disponibilidade dos filmes
        filme1.setDisponiveis(true);
        filme2.setDisponiveis(true);
        filme3.setDisponiveis(true);
        filme4.setDisponiveis(true);
        filme5.setDisponiveis(true);
        
        // Adicionando filmes ao cinema
        cinema.addFilme(filme1);
        cinema.addFilme(filme2);
        cinema.addFilme(filme3);
        cinema.addFilme(filme4);
        cinema.addFilme(filme5);
        cinema.addFilme(filme6);
        cinema.addFilme(filme7);
        cinema.addFilme(filme8);
        cinema.addFilme(filme9);
        cinema.addFilme(filme10);

        // Iniciando o sistema de menus
        sistemaMenus.initSistema();
    }
}
