import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    private static final String API_KEY = "Digite aqui sua api key";
    private static final String API_URL = "Digite aqui a url do seu request";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Authorization", "Bearer " + API_KEY)
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("Resposta recebida com sucesso.");
                CurrencyResponse currencyResponse = gson.fromJson(response.body(), CurrencyResponse.class);
                System.out.println("Moedas disponíveis:");
                System.out.println("BRL - Real Brasileiro");
                System.out.println("USD - Dólar Americano");
                System.out.println("ARS - Peso Argentino");
                System.out.println("BOB - Boliviano Boliviano");
                System.out.println("CLP - Peso Chileno");
                System.out.println("COP - Peso Colombiano");
                System.out.print("Escolha a moeda de origem (por exemplo, USD): ");
                String fromCurrency = scanner.next().toUpperCase();
                System.out.print("Escolha a moeda de destino (por exemplo, BRL): ");
                String toCurrency = scanner.next().toUpperCase();
                System.out.print("Digite o valor para conversão: ");
                double amount = scanner.nextDouble();
                double conversionRate = getConversionRate(currencyResponse, fromCurrency, toCurrency);
                if (conversionRate == -1) {
                    System.out.println("Conversão não disponível.");
                } else {
                    double convertedAmount = amount * conversionRate;
                    System.out.printf("%.2f %s é igual a %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
                }
            } else {
                System.out.println("Erro na requisição. Código de status: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Erro ao realizar a requisição: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    private static double getConversionRate(CurrencyResponse response, String fromCurrency, String toCurrency) {

        if (response.rates.containsKey(fromCurrency) && response.rates.containsKey(toCurrency)) {
            double fromRate = response.rates.get(fromCurrency);
            double toRate = response.rates.get(toCurrency);
            return toRate / fromRate;
        }
        return -1;
    }
    static class CurrencyResponse {
        public String base;
        public java.util.Map<String, Double> rates;
    }
}
