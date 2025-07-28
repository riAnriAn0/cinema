import Cinema_config.*;
import Sistema.Menu;
import Sistema.SisteMenus;
import java.util.ArrayList;
import java.util.Scanner;
import Pessoa.Admin;

public class App {
    public static void main(String[] args) throws Exception {

        // Criando os menus
        Menu menuPrincipal = new Menu("Menu Principal", 3, new String[] {
                "Filmes Em Cartaz",
                "Comprar Ingresso",
                "Gerenciar Cinema",
        }, new Scanner(System.in));
        Menu menuGerenciarCinema = new Menu("Gerenciar Cinema", 7, new String[] {
                "Adicionar Filme",
                "Remover Filme",
                "Alocar Filme a Sala",
                "Listar Filmes",
                "Listar Salas",
                "Historico de vendas",
                "Gerar Relatório .txt",
        }, new Scanner(System.in));

        // Lista de menus
        ArrayList<Menu> menus = new ArrayList<>();

        // Adicionando menus à lista
        menus.add(menuPrincipal);
        menus.add(menuGerenciarCinema);

        // Adicionando filmes de exemplo
        Filme filme1 = new Filme("Avatar", "James Cameron", "Aventura/Sci-Fi", 180,
                "A história de um ex-fuzileiro que se junta a uma tribo alienígena em Pandora.", 1);
        Filme filme2 = new Filme("Inception", "Christopher Nolan", "Aventura/Sci-Fi", 148,
                "Um ladrão que invade os sonhos das pessoas para roubar segredos.", 2);
        Filme filme3 = new Filme("The Godfather", "Francis Ford Coppola", "Crime/Drama", 175,
                "A saga da família mafiosa Corleone na América dos anos 40 e 50.", 3);
        Filme filme4 = new Filme("O Cavaleiro das Trevas", "Christopher Nolan", "Ação/Crime", 152,
                "Batman enfrenta o Coringa em Gotham City.", 4);
        Filme filme5 = new Filme("Pulp Fiction", "Quentin Tarantino", "Crime/Drama", 154,
                "Histórias interligadas de criminosos em Los Angeles.", 5);
        Filme filme6 = new Filme("Um Sonho de Liberdade", "Frank Darabont", "Drama", 142,
                "A amizade entre dois prisioneiros em Shawshank.");
        Filme filme7 = new Filme("Forrest Gump", "Robert Zemeckis", "Drama/Romance", 142,
                "A vida extraordinária de um homem simples com um coração puro.");
        Filme filme8 = new Filme("Matrix", "Lana Wachowski, Lilly Wachowski", "Ação/Sci-Fi", 136,
                "Um hacker descobre a verdade sobre a realidade em que vive.");
        Filme filme9 = new Filme("Interestelar", "Christopher Nolan", "Aventura/Sci-Fi", 169,
                "Uma equipe de astronautas viaja através de um buraco de minhoca em busca de um novo lar para a humanidade.");
        Filme filme10 = new Filme("Gladiador", "Ridley Scott", "Ação/Aventura", 155,
                "Um general romano é traído e busca vingança como gladiador.");

        // Definindo disponibilidade dos filmes
        filme1.setDisponiveis(true);
        filme2.setDisponiveis(true);
        filme3.setDisponiveis(true);
        filme4.setDisponiveis(true);
        filme5.setDisponiveis(true);
        
        //Criando Salas
        Sala sala1 = new Sala(1, filme1);
        Sala sala2 = new Sala(2, filme2);
        Sala sala3 = new Sala(3, filme3);
        Sala sala4 = new Sala(4, filme4);
        Sala sala5 = new Sala(5, filme5);

        Sala[] salas = { sala1, sala2, sala3, sala4, sala5 };
        
        // Criando o cinema
        Cinema cinema = new Cinema("Absolute Cinema", salas);
        
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

        //Admin Dono do cinema
        Admin donoCinema1 = new Admin("Rian", 20, "rian", 1234, cinema);
        Admin donoCinema2 = new Admin("Gian", 20, "gian", 1234, cinema);

        ArrayList<Admin> donoCinema = new ArrayList<>();
        donoCinema.add(donoCinema1);
        donoCinema.add(donoCinema2);

        // Criando o sistema de menus
        SisteMenus sistemaMenus = new SisteMenus(menus, donoCinema);

        // Iniciando o sistema de menus
        sistemaMenus.initSistema();
    }
}
