package Service;

import com.google.gson.Gson;

import java.util.Scanner;

public class Menu {
    private final ServiceAPI CONSUMO_API = new ServiceAPI();
    private final Gson GSON = new Gson();
    private String json;
    private final Scanner SCANNNER = new Scanner(System.in);

    public void exibeMenu(){

        while (true) {
            System.out.println("""
                    *********************************************************
                    Seja bem vindo ao Conversor de Moedas!
                    
                    1) Dólar =>> Peso argentino
                    2) Peso Argentino =>> Dólar
                    3) Dólar =>> Real brasileiro
                    4) Real brasileiro =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Sair
                    Escolha uma opção válida:
                    **********************************************************
                    """);
            int opcao = SCANNNER.nextInt();
            if (opcao == 7){
                System.out.println("Encerrando o programa...");
                break;
            }
            processaOpcao(opcao);
        }

    }

    public void processaOpcao (int opcao){
        System.out.println("Digite o valor que deseja converter: ");
        double taxa;
        double valor = SCANNNER.nextDouble();
        String moedaEscolhida;
        String moedaConversao;
        switch (opcao){
            case 1 -> {moedaEscolhida = "USD"; moedaConversao = "ARS";}
            case 2 -> {moedaEscolhida = "ARS"; moedaConversao = "USD";}
            case 3 -> {moedaEscolhida = "USD"; moedaConversao = "BRL";}
            case 4 -> {moedaEscolhida = "BRL"; moedaConversao = "USD";}
            case 5 -> {moedaEscolhida = "USD"; moedaConversao = "COP";}
            case 6 -> {moedaEscolhida = "COP"; moedaConversao = "USD";}
            default -> {
                System.out.println("Opção inválida!");
                return;
            }

        }
        this.json = CONSUMO_API.obterDados("https://v6.exchangerate-api.com/v6/6d30a12c182f166781b3ce3b/latest/" + moedaEscolhida);
        ConverteDados dados = GSON.fromJson(json, ConverteDados.class);
        taxa = dados.conversion_rates().get(moedaConversao);
        double resultado = valor * taxa;
        System.out.printf("Valor convertido de [%s], para [%s]. Resultado: %.2f\n", moedaEscolhida, moedaConversao, resultado);

    }
}

