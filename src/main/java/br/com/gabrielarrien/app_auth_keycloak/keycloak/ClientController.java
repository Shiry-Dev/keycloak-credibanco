package br.com.gabrielarrien.app_auth_keycloak.keycloak;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("openfin/create/user")
public class ClientController {

    @Value("${external.url.connection.create.user}")
    private String urlConnectionKeycloak;

    @PostMapping("/")
    public ResponseEntity<String> createClient(@RequestHeader("Authorization")String authorization,
                                       @RequestBody User user) {

        HttpHeaders headers = new HttpHeaders();
        RestTemplate rt = new RestTemplate();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", authorization);
        Map<String, String> jsonBody = new HashMap<>();
        jsonBody.put("username", user.username());

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(jsonBody, headers);
        var result = rt.postForEntity(urlConnectionKeycloak, entity, String.class);
        return result;

    }

    public record User(String username) {}
}
