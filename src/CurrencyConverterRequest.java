import java.net.URI;
import java.net.http.HttpRequest;

public class CurrencyConverterRequest {
    public static void main(String[] args) {
        String apiUrl = "Digite aqui a sua chave api";
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .header("Accept", "application/json")
                .build();
        System.out.println("Requisição criada com sucesso!");
        System.out.println("URI: " + httpRequest.uri());
    }
}

