package com.example.userservice;

import com.example.userservice.security.repositories.JpaRegisteredClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    private JpaRegisteredClientRepository clientRegistrationRepository;

    @Test
    void contextLoads() {
    }

//    @Test
//    public void createClient(){
//        RegisteredClient oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
//                .clientId("oidc-client")
//                .clientSecret("{noop}secret")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//                .redirectUri("https://oauth.pstmn.io/v1/browser-callback")
//                .postLogoutRedirectUri("http://127.0.0.1:8080/")
//                .scope("camera")
//                .scope("profile")
//                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
//                .build();
//
//        clientRegistrationRepository.save(oidcClient);
//    }

}
