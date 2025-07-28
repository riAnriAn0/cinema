package Sistema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import cinema_config.Ingresso;
import java.util.ArrayList;

public class Relatorio {
    private String nomeRelatorio;
    private String data;
    private String hora;
    private double valorTotal;
    private static int id = 0;
    private ArrayList<Ingresso> ingressosVendidos = new ArrayList<>();

    public Relatorio(String nomeRelatorio, String data, String hora, double valorTotal, ArrayList<Ingresso> ingressosVendidos) {
        this.nomeRelatorio = nomeRelatorio;
        this.data = data;
        this.hora = hora;
        this.ingressosVendidos = ingressosVendidos;
        this.valorTotal = valorTotal;
        id++;
    }

    public void gerarRelatorio(){
        String conteudo = ""; 
        conteudo += "      +-------------------------------------------------------------------------------------------------+\n";
        conteudo += "      |                                Cinema                   \n";
        conteudo += "      +-------------------------------------------------------------------------------------------------+\n\n\n";
        conteudo += "      +-------------------------------------------------------------------------------------------------+\n";
        conteudo += "      | Nome do Relatório: " + nomeRelatorio + "\n";
        conteudo += "      | Data: " + data + "\n";
        conteudo += "      | Hora: " + hora + "\n";
        conteudo += "      +-------------------------------------------------------------------------------------------------+\n";
        conteudo += "\n                                   Relatório de Vendas             \n\n";
        conteudo += "      | Nome         | Filme                     | Sala | Assento | Valor | Desconto % | Valor Final |\n";
        conteudo += "      +-------------------------------------------------------------------------------------------------+\n";
        if (ingressosVendidos.isEmpty()) {
            conteudo += "      | Nenhum ingresso vendido até o momento.   |\n";
        } else {
            for (Ingresso ingresso : ingressosVendidos) {
                conteudo += String.format("      | %-12s | %-25s | %-4d | %-7s | %-6.2f | %-8.0f | %-12.2f |\n",
                        ingresso.getCliente().getNome(),
                        ingresso.getSala().getFilme().getTitulo(),
                        ingresso.getSala().getNumSala(),
                        ingresso.getAssento().localizacao(),
                        ingresso.getPreco(),
                        ingresso.getCliente().getDesconto() * 100,
                        ingresso.getPreco() * (1 - ingresso.getCliente().getDesconto()));
                        conteudo += "      +-------------------------------------------------------------------------------------------------+\n";
            }
        }

        conteudo += "      +-------------------------------------------------------------------------------------------------+\n";
        conteudo += "      | Valor Total: R$ " + String.format("%.2f", valorTotal) + " |\n";
        conteudo += "      +-------------------------------------------------------------------------------------------------+\n";
        conteudo += "      | Data de Geração: " + data + " |\n";
        conteudo += "      +-------------------------------------------------------------------------------------------------+\n";
        conteudo += "      | Gerado por: Sistema de Cinema |\n";
        conteudo += "      +-------------------------------------------------------------------------------------------------+\n";

        java.util.Date data = new java.util.Date();
        conteudo += "\n"+ data.toString();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(".\\src\\relatorios\\relatorio_" + Relatorio.id + ".txt"))) {
            writer.write(conteudo);
            System.out.println("Arquivo relatorio_" + Relatorio.id + ".txt gerado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
