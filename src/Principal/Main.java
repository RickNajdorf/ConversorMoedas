package Principal;

import Service.ConversionRates;
import Service.ConverteDados;

import Service.ServiceAPI;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        ServiceAPI consumoApi = new ServiceAPI();
        Gson gson = new Gson();
        String json = consumoApi.obterDados("https://v6.exchangerate-api.com/v6/6d30a12c182f166781b3ce3b/latest/USD");
        ConversionRates dados = gson.fromJson(json, ConverteDados.class).conversion_rates();
        System.out.println(dados);

    }
}