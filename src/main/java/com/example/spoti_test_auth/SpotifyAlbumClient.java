package com.example.spoti_test_auth;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class SpotifyAlbumClient {

    @GetMapping("/album/{authorName}")
    public String  getAlbumsByAuthor(OAuth2Authentication details, @PathVariable String authorName) {
        String jwt = ((OAuth2AuthenticationDetails)details.getDetails()).getTokenValue();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + jwt);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<String> exchange = restTemplate.exchange("https://api.spotify.com/v1/search?query=taylor+swift&type=artist&market=ES&locale=pl-PL%2Cpl%3Bq%3D0.9%2Cen-US%3Bq%3D0.8%2Cen%3Bq%3D0.7&offset=5&limit=10",
                HttpMethod.GET,
                httpEntity,
                String.class);
        return exchange.getBody();

        //Request request = new Request.Builder()
        //  .url("https://api.spotify.com/v1/search?query=Boys&type=artist&market=PL&locale=pl-PL%2Cpl%3Bq%3D0.9%2Cen-US%3Bq%3D0.8%2Cen%3Bq%3D0.7&offset=5&limit=10")
        //  .method("GET", body)
        //  .addHeader("Authorization", "Bearer BQDhtWOco7sdd0gngHFwRO4gjHwhcP0t8DppAg_JhF3HhO2N_14mPOGZxVkag09mVQsvYphUAC5okPTxUDsXV0AOhrPtiM567LQUBkUwDCcaQ6XPkHGav3ijGpR1gVvZbdZ6OuLsjXgZL-I9Vtnixs6sscXCC-CWwDcs8t58ofpK9aMtgL7CczztiVSH9PyGvRFQB7tGhCbyfsdVeIexVw")
        //  .build();

    }
}
