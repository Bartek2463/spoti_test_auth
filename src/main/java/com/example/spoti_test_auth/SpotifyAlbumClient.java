package com.example.spoti_test_auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class SpotifyAlbumClient {

    @GetMapping("/album/{authorName}")
    public Principal getAlbumsByAuthor(Principal principal, @PathVariable) {
        return principal;
    }
}
