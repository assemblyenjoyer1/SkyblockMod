package org.example;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import static org.example.Urls.BASE_URL;

public class HypixelApi {

    private final HttpClient client;
    private Urls baseUrl;

    public HypixelApi() {
        this.client = HttpClient.newBuilder()
                .sslContext(createInsecureSslContext())
                .build();
        this.baseUrl = Urls.BASE_URL;
    }

    public String sendAsync(HttpMethod method, String endpoint, String body) {
        HttpRequest.BodyPublisher publisher = (body != null) ? HttpRequest.BodyPublishers.ofString(body) : HttpRequest.BodyPublishers.noBody();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .method(method.name(), publisher)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .build();
        System.out.println(request);

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body).join();
    }

    private SSLContext createInsecureSslContext() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
                }

                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

            }};
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new SecureRandom());
            return sslContext;
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException(e);


        }
    }
}
