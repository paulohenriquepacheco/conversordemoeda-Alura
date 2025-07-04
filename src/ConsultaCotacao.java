import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCotacao {

    public Moeda consultar (String moeda) {
        String url_str = "https://v6.exchangerate-api.com/v6/b066c2e1e79cb4757b8c35d4/pair/" + moeda;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_str))
                .build();


        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moeda.class);


        } catch (Exception e) {
            throw new RuntimeException("Erro verificar!");
        }
    }
}
