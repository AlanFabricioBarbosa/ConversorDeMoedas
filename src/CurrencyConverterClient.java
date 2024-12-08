import java.net.http.HttpClient;

public class CurrencyConverterClient {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();
        System.out.println("HttpClient configurado com sucesso!");
    }
}

