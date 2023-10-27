package br.com.gabrielarrien.app_auth_keycloak.keycloak;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/token")
public class TokenController {

    @Value("${external.url.connection.keycloak}")
    private String urlConnectionKeycloak;

    @PostMapping("/")
    public ResponseEntity<String> token(@RequestBody User user){

        HttpHeaders headers = new HttpHeaders();
        RestTemplate rt = new RestTemplate();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", user.client_id());
        formData.add("username", user.username());
        formData.add("password", user.password());
        formData.add("grant_type", user.grant_type());

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(formData, headers);
        var result = rt.postForEntity(urlConnectionKeycloak, entity, String.class);
        return result;
    }

    public record User(String client_id, String username, String grant_type, String password ) {}
}
